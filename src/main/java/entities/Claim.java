package entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class Claim {
    private final String claimId;
    private final Policy policy;
    private String description;

    private boolean approved;

    public Claim(Policy policy, String description) {
        this.claimId = UUID.randomUUID().toString();
        this.policy = policy;
        this.description = description;
        this.approved = false;
    }

    public String getClaimId() {
        return claimId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                ", policyId='" +  + '\'' +
                ", description='" + description + '\'' +
                ", approved=" + approved +
                '}';
    }
}