package ozgur.crmTool.business.concretes;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ozgur.crmTool.business.abstracts.CustomerService;
import ozgur.crmTool.business.requests.customer.CreateCustomerRequest;
import ozgur.crmTool.business.requests.customer.UpdateCustomerRequest;
import ozgur.crmTool.business.responses.customer.GetActiveCustomersResponse;
import ozgur.crmTool.business.responses.customer.GetAllCustomersResponse;
import ozgur.crmTool.business.responses.customer.GetByIDCustomerResponse;
import ozgur.crmTool.business.rules.CustomerBusinessRules;
import ozgur.crmTool.core.utilities.mappers.ModelMapperService;
import ozgur.crmTool.core.utilities.validation.CustomerValidationUtility;
import ozgur.crmTool.dataAccess.abstracts.CustomerRepository;
import ozgur.crmTool.entities.concretes.Customer;
import ozgur.crmTool.core.utilities.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of CustomerService containing business logic for customer operations.
 * Handles CRUD operations, data transformation between entities and DTOs,
 * and manages transaction boundaries for customer data.
 */
@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;
    private CustomerBusinessRules customerBusinessRules;

    /**
     * Retrieves all customers and maps them to response DTOs.
     *
     * @return List of GetAllCustomersResponse containing customer data
     */
    @Override
    @Transactional
    public List<GetAllCustomersResponse> getAll() {
        List<Customer> customers = customerRepository.findAll();
        List<GetAllCustomersResponse> customerResponse = customers.stream()
                .map(customer->this.modelMapperService.forResponse()
                        .map(customer,GetAllCustomersResponse.class)).collect(Collectors.toList());
        return customerResponse;
    }

    /**
     * Retrieves only active customers and maps them to specialized response DTOs.
     *
     * @return List of GetActiveCustomersResponse with active customer data
     */
    @Override
    @Transactional
    public List<GetActiveCustomersResponse> getActiveCustomers() {
        List<Customer> customers = customerRepository.findAllActive();
        List<GetActiveCustomersResponse> customerResponse = customers.stream()
                .map(customer->this.modelMapperService.forResponse()
                        .map(customer,GetActiveCustomersResponse.class)).collect(Collectors.toList());
        return customerResponse;
    }

    /**
     * Finds a customer by ID and maps it to detailed response DTO.
     *
     * @param id Customer ID to search for
     * @return GetByIDCustomerResponse with detailed customer information
     * @throws NotFoundException if customer not found
     */
    @Override
    @Transactional
    public GetByIDCustomerResponse getById(int id) {
        Customer customer = this.customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found"));
        GetByIDCustomerResponse customerResponse = this.modelMapperService.forResponse()
                .map(customer,GetByIDCustomerResponse.class);
        return customerResponse;
    }

    /**
     * Creates a new customer from the provided request DTO.
     * Uses request mapper for DTO to entity conversion.
     *
     * @param createCustomerRequest Contains data for new customer
     * @throws BusinessException if request is not valid
     */
    @Override
    public void add(CreateCustomerRequest createCustomerRequest) {
        CustomerValidationUtility.validateCreateCustomer(createCustomerRequest);
        this.customerBusinessRules.checkIfEmailExists(createCustomerRequest.getEmail());
        Customer customer = modelMapperService.forRequest().map(createCustomerRequest, Customer.class);
        this.customerRepository.save(customer);
    }

    /**
     * Updates an existing customer from the provided request DTO.
     *
     * @param updateCustomerRequest Contains updated customer data
     * @throws BusinessException if request is not valid
     */
    @Override
    public void update(UpdateCustomerRequest updateCustomerRequest) {
        CustomerValidationUtility.validateUpdateCustomer(updateCustomerRequest);
        Customer customer = modelMapperService.forRequest().map(updateCustomerRequest, Customer.class);
        this.customerRepository.save(customer);
    }

    /**
     * Permanently deletes a customer by ID.
     *
     * @param id Customer ID to delete
     */
    @Override
    public void delete(Integer id) {
        this.customerRepository.deleteById(id);
    }

    /**
     * Performs a soft delete by marking customer as inactive.
     * Maintains the record in database but sets isActive flag to false.
     *
     * @param id Customer ID to deactivate
     * @throws NotFoundException if customer not found
     */

    @Override
    @Transactional
    public void softDeleteCustomer(Integer id) {
        Customer customer = this.customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found"));
        customer.setActive(false);
        this.customerRepository.save(customer);
    }


}
