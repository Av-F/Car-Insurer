package services;

import entities.Account;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Map;

public class AccountService {
    // add a logger
    private static final Logger log = Logger.getLogger(AccountService.class.getName());
    // add a map to store the accounts
    private final Map<String, Account> accounts = new HashMap<>();

    public Account createAccount(String accountNumber, String accountHolderName, double initialBalance) {
        // Check if the account number, account name and balance are given
        if (accountNumber == null) {
            log.severe("Account number cannot be empty");
            throw new IllegalArgumentException("Account number cannot be empty");
        }
        if (accountHolderName == null) {
            log.severe("Account holder name cannot be empty");
            throw new IllegalArgumentException("Account holder name cannot be empty");
        }
        if (initialBalance < 0) {
            log.severe("Initial balance cannot be negative");
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        // If so, create the account and add it to the map
        Account account = new Account(accountNumber, accountHolderName, initialBalance);
        accounts.put(account.getAccountNumber(), account);
        log.info("Account created: " + account.getAccountNumber() + " for " +
                account.getAccountHolderName() + " with initial balance: " + initialBalance);
        return account;
    }

    public Account getAccount(String accountNumber) {
        // Check if the account number is given
        if (accountNumber == null) {
            log.severe("Account number cannot be empty");
            throw new IllegalArgumentException("Account number cannot be empty");
        }
        // If so, return the account from the map
        Account account = accounts.get(accountNumber);
        if (account == null) {
            log.severe("Account not found: " + accountNumber);
            throw new IllegalArgumentException("Account not found");
        }
        return account;
    }
    public String getAccountHolderName(String accountNumber) {
        if(accountNumber == null) {
            log.severe("Account number cannot be empty");
            throw new IllegalArgumentException("Account number cannot be empty");
        }
        // Get the account from the map
        Account account = getAccount(accountNumber);
        // Return the account holder name
        return account.getAccountHolderName();
    }

    public double getBalance(String accountNumber) {
        if(accountNumber == null) {
            log.severe("Account number cannot be empty");
            throw new IllegalArgumentException("Account number cannot be empty");
        }
        // Get the account from the map
        Account account = getAccount(accountNumber);
        // Return the balance of the account
        return account.getBalance();
    }
    public void deposit(String accountNumber, double amount) {
        if(amount > 0) {
            // Get the account from the map
            Account account = getAccount(accountNumber);
            // Deposit the amount to the account
            account.deposit(amount);
            log.info("Deposited " + amount + " to account " + accountNumber +
                    ". New balance: " + account.getBalance());
        } else {
            log.severe("Deposit amount must be positive");
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        // Get the account from the map
        Account account = getAccount(accountNumber);
        // Check if the balance has sufficent funds for a withdrawal
        if (account.getBalance() < amount) {
            log.severe("Insufficient balance for withdrawal from account " + accountNumber +
                    ". Current balance: " + account.getBalance() + ", attempted withdrawal: " + amount);
            throw new IllegalArgumentException("Insufficient balance");
        } else {
            // Withdraw the amount from the account
            account.withdraw(amount);
            log.info("Withdrew " + amount + " from account " + accountNumber +
                    ". New balance: " + account.getBalance());
        }
    }
    public void transfer(String startNumber, String endNumber, double amount) {
        // Get the accounts from the map
        Account fromAccount = getAccount(startNumber);
        Account toAccount = getAccount(endNumber);
        // Withdraw the amount from the from account if there is sufficient balance
        if(fromAccount.getBalance() < amount) {
            log.severe("Insufficient balance for transfer from account " + startNumber +
                    ". Current balance: " + fromAccount.getBalance() + ", attempted transfer: " + amount);
            throw new IllegalArgumentException("Insufficient balance");
        } else {
            log.info("Transferring " + amount + " from account " + startNumber +
                    " to account " + endNumber + ".");
            fromAccount.withdraw(amount);
            // Deposit the amount to the to account
            toAccount.deposit(amount);
        }
    }
}
