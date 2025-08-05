package entities;

import java.time.LocalDate;
import java.util.UUID;

public class Policy {
    private final String policyId;
    private final Customer customer;
    private double premium;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean active;

    public Policy(Customer customer, double premium, LocalDate startDate, LocalDate endDate) {
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

    public Customer getCustomer() {
        return customer;
    }

    public double getPremium() {
        return premium;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
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
                ", customer=" + customer.getName() +
                ", premium=" + premium +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", active=" + active +
                '}';
    }
}
