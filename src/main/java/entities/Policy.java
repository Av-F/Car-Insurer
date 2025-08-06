package entities;
import java.util.UUID;

public class Policy {
    private final String policyId;
    private String  customer;
    private double premium;
    private String startDate;
    private String endDate;
    private boolean active;

    public Policy(String customer, double premium, String startDate, String endDate) {
        this.policyId = UUID.randomUUID().toString();
        this.customer = customer;
        this.premium = premium;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = true;
    }

    public String getPolicyId() {
        return policyId;
    }

    public String getCustomer() {
        return customer;
    }

    public double getPremium() {
        return premium;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public boolean isActive() {
        return active;
    }

    public void cancel() {
        this.active = false;
    }

    @Override
    public String toString() {
        return "entities.Policy{" +
                "id='" + policyId + '\'' +
                ", customer=" + customer +
                ", premium=" + premium +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", active=" + active +
                '}';
    }
}
