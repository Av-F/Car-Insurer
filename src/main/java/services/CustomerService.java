package services;

import entities.Customer;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.*;
public class CustomerService {
    // create a logger
    private static final Logger log = Logger.getLogger(CustomerService.class.getName());

    // use a map to store customers by their ID
    private final Map<String, Customer> customers = new HashMap<>();

    // Function to create a new customer with check for email
    public Customer createCustomer(String name, String email) {
        // Check if the name exists
        if (name == null || name.trim().isEmpty()) {
            log.severe("Customer name cannot be empty");
            throw new IllegalArgumentException("Customer name cannot be empty");
        }
        // Check if there is an email given
        if (email == null || email.trim().isEmpty()) {
            log.severe("Customer email cannot be empty");
            throw new IllegalArgumentException("Customer email cannot be empty");
        }
        // If passed, create the customer and put into the list of customers
        // Create a unique ID for the customer too
        String id = UUID.randomUUID().toString();
        Customer customer = new Customer(id, name, email);
        customers.put(customer.getCustomerId(), customer);
        // Log the creation of the customer
        log.info(String.format("Created customer: ID=%s, Name='%s', Email='%s'",
                customer.getCustomerId(), name, email));
        // Return the created customer
        return customer;
    }
    // Function to get a customer by their ID
    public Customer getCustomerById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be empty");
        }
        return customers.get(id); // Returns customer if customer ID is found
    }
    // Function to return all customers
    public List<Customer> getAllCustomers() {
        log.info("List of all customers (total: " + customers.size() + ")");
        return new ArrayList<>(customers.values());
    }

    // Function to delete a customer
    public boolean deleteCustomer(String id) {
        if (id == null || id.trim().isEmpty()) {
            log.warning("Customer ID cannot be empty when deleting");
            throw new IllegalArgumentException("Customer ID cannot be empty");
        }
        Customer removed = customers.remove(id);
        if (removed != null) {
            log.info("Deleted customer: ID=" + removed.getCustomerId() + ", Name='" + removed.getName() + "'");
            return true;
        } else {
            log.warning("Attempted to delete non-existent customer: ID=" + id);
            return false;
        }
    }
}