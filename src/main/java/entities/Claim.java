package entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class Claim {
    private final String claimId;
    private final Policy policy;
    private String description;
    private String date;
    private boolean approved;

    public Claim(Policy policy, String description, String date) {
        this.claimId = UUID.randomUUID().toString();
        this.policy = policy;
        this.description = description;
        this.date = date;
        this.approved = false;
    }

    public String getClaimId() {
        return claimId;
    }

    public Policy getPolicy() {
        return policy;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public boolean isApproved() {
        return approved;
    }

    public void approve() {
        this.approved = true;
    }

    @Override
    public String toString() {
        return "entities.Claim{" +
                "id='" + claimId + '\'' +
                ", policyId='" + policy.getPolicyId() + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", approved=" + approved +
                '}';
    }
}