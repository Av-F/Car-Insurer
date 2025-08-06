package services;

import entities.Claim;
import entities.Customer;
import entities.Policy;

import java.util.*;
import java.util.logging.Logger;
public class ClaimService {
    // Create logger and initialize claims storage
    private static final Logger log = Logger.getLogger(ClaimService.class.getName());
    private final Map<String, Claim> claims = new HashMap<>();
    // create a claim
    public Claim createClaim(Policy policy, String description, String date) {
        Claim claim = new Claim(policy, description, date);
        claims.put(claim.getClaimId(), claim);
        log.info("Created claim: " + claim);
        return claim;
    }
    // Getters and methods for claim management
    public Claim getClaim(String claimId) {
        Claim claim = claims.get(claimId);
        if (claim == null) {
            log.warning("Claim not found: " + claimId);
            return null;
        }
        log.info("Retrieved claim: " + claim);
        return claim;
    }
    // Function to return all claims for a specific customer
    public List<Claim> getClaimsByCustomer(Customer customer) {
        List<Claim> customerClaims = new ArrayList<>();
        for (Claim claim : claims.values()) {
            if (claim.getPolicy().getCustomer().equals(customer)) {
                customerClaims.add(claim);
            }
        }
        log.info("Retrieved " + customerClaims.size() + " claims for customer: " + customer.getName());
        return customerClaims;
    }
    // Function to return all claims
    public List<Claim> getAllClaims() {
        log.info("Retrieved all claims, count: " + claims.size());
        return new ArrayList<>(claims.values());
    }
    // Function to approve/deny claims
    public boolean approveClaim(String claimId) {
        Claim claim = claims.get(claimId);
        if (claim == null) {
            log.warning("Claim not found for approval: " + claimId);
            return false;
        }
        claim.approve();
        log.info("Approved claim: " + claim);
        return true;
    }
    // Function to delete a claim
    public boolean deleteClaim(String claimId) {
        Claim claim = claims.remove(claimId);
        if (claim == null) {
            log.warning("Claim not found for deletion: " + claimId);
            return false;
        }
        log.info("Deleted claim: " + claim);
        return true;
    }
    // Function to clear all claims
    public void clearClaims() {
        claims.clear();
        log.info("All claims cleared.");
    }
}
