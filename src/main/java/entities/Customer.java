package entities;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private String email;

    private List<Account> accounts = new ArrayList<>();

    public Customer(String customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }

    public String getCustomerId() {

        return customerId;
    }

    public String getName() {

        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
    public void addAccount(Account account) {
        if (account != null) {
            accounts.add(account);
        }
    }
    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    @Override
    public String toString() {
        return "entities.Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}