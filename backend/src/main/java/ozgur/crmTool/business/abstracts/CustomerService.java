package ozgur.crmTool.business.abstracts;

import ozgur.crmTool.business.requests.customer.CreateCustomerRequest;
import ozgur.crmTool.business.requests.customer.UpdateCustomerRequest;
import ozgur.crmTool.business.responses.customer.GetActiveCustomersResponse;
import ozgur.crmTool.business.responses.customer.GetAllCustomersResponse;
import ozgur.crmTool.business.responses.customer.GetByIDCustomerResponse;

import java.util.List;

/**
 * Service interface for customer management operations.
 * Defines the business logic contract for customer-related operations.
 *
 * Uses Request/Response DTO pattern.
 */
public interface CustomerService {
    /**
     * Retrieves all customers in the system.
     * @return List of customer responses
     */
    List<GetAllCustomersResponse> getAll();

    /**
     * Retrieves only active customers in the system.
     * @return List of active customer responses.
     */
    List<GetActiveCustomersResponse> getActiveCustomers();

    /**
     * Finds a customer by their unique identifier.
     * @param id The ID of the customer to retrieve
     * @return Detailed customer response including all relevant fields
     * @throws exception if customer not found
     */
    GetByIDCustomerResponse getById(int id);

    /**
     * Creates a new customer record.
     * @param createCustomerRequest Contains all required fields for customer creation
     */
    void add(CreateCustomerRequest createCustomerRequest);

    /**
     * Updates an existing customer record.
     * @param updateCustomerRequest Contains fields to be updated
     */
    void update(UpdateCustomerRequest updateCustomerRequest);

    /**
     * Permanently deletes a customer record from the system.
     * @param id The ID of the customer to delete
     */
    void delete(Integer id);

    /**
     * Performs a soft delete operation on a customer record.
     * Marks the customer as inactive rather than physically deleting.
     * @param id The ID of the customer to deactivate
     * @throws exception if customer not found
     */
    void softDeleteCustomer(Integer id);
}