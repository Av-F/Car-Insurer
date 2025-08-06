package services;

import entities.Customer;
import entities.Policy;
import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Map;
public class PolicyService {
    // Add a map for storage and logger for logging
    private final Map<String, Policy> policies = new HashMap<>();
    private static final Logger logger = Logger.getLogger(PolicyService.class.getName());

    // Function to create a new policy
   public Policy createPolicy(String customer, double premium, String startDate, String endDate) {
        // Write checks to ensure that the policy can be created
        if(customer == null) {
            logger.warning("Cannot create policy: Customer is null");
            return null;
        }
        if(premium <= 0) {
            logger.warning("Cannot create policy: Premium must be greater than zero");
            return null;
        }
        if(startDate == null || endDate == null) {
            logger.warning("Cannot create policy: Start date or end date is null");
            return null;
        }
        // If the checks are fine, create the policy and put it into the list of policies
        Policy policy = new Policy(customer, premium, startDate, endDate);
        policies.put(policy.getPolicyId(), policy);
        logger.info("Created policy: " + policy);
        return policy;
    }
    // Function to cancel a policy
    public boolean cancelPolicy(String policyId) {
        // Check if the policy exists
        Policy policy = policies.get(policyId);
        if (policy == null) {
            logger.warning("Cannot cancel policy: Policy with ID " + policyId + " does not exist");
            return false;
        }
        // If it exists, cancel the policy
        policy.cancel();
        logger.info("Cancelled policy: " + policy);
        return true;
    }
    // Function to get a policy by ID
    public Policy getPolicyById(String policyId) {
        // Check if the policy exists
        Policy policy = policies.get(policyId);
        if (policy == null) {
            logger.warning("Policy with ID " + policyId + " does not exist");
            return null;
        }
        logger.info("Retrieved policy: " + policy);
        return policy;
    }

    // Function to get all active policies
    public Map<String, Policy> getActivePolicies() {
        Map<String, Policy> activePolicies = new HashMap<>();
        for (Policy policy : policies.values()) {
            if (policy.isActive()) {
                activePolicies.put(policy.getPolicyId(), policy);
            }
        }
        logger.info("Retrieved all active policies");
        return activePolicies;
    }
    // function get policies per customer
   public Map<String, Policy> getPoliciesByCustomer(String customer) {
        if (customer == null) {
            logger.warning("Cannot retrieve policies: Customer is null");
            return new HashMap<>();
        }
        Map<String, Policy> customerPolicies = new HashMap<>();
        for (Policy policy : policies.values()) {
            if (policy.getCustomer().equals(customer)) {
                customerPolicies.put(policy.getPolicyId(), policy);
            }
        }
        logger.info("Retrieved policies for customer: " + customer);
        return customerPolicies;
    }
}
