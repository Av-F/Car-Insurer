package entities;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private String email;

    private List<Account> accounts = new ArrayList<>();

    private List<Claim> claims = new ArrayList<>();

    private List<Policy> policies = new ArrayList<>();

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

    public List<Claim> getClaims() {
        return claims;
    }
    public void addClaim(Claim claim) {
        if (claim != null) {
            claims.add(claim);
        }
    }
    public void removeClaim(Claim claim) {
        claims.remove(claim);
    }
    public List<Policy> getPolicies() {
        return policies;
    }
    public void addPolicy(Policy policy) {
        if (policy != null) {
            policies.add(policy);
        }
    }
    public void removePolicy(Policy policy) {
        policies.remove(policy);
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