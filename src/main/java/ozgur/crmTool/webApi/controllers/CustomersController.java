package ozgur.crmTool.webApi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ozgur.crmTool.business.abstracts.CustomerService;
import ozgur.crmTool.business.requests.CreateCustomerRequest;
import ozgur.crmTool.business.requests.UpdateCustomerRequest;
import ozgur.crmTool.business.responses.GetActiveCustomersResponse;
import ozgur.crmTool.business.responses.GetAllCustomersResponse;
import ozgur.crmTool.business.responses.GetByIDCustomerResponse;

import java.util.List;

/**
 * REST API controller for customer management operations.
 * Provides endpoints for CRUD operations and customer status management.
 */
@RestController
@RequestMapping("/api/customers")
public class CustomersController {
    private CustomerService customerService;

    @Autowired
    public CustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Retrieves all customers
     */
    @Operation(
            summary = "Get all customers",
            description = "Returns both active and inactive customer records",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    @GetMapping("/getAll")
    public List<GetAllCustomersResponse> getAll() {
        return customerService.getAll();
    }

    /**
     * Retrieves only active customers
     */
    @Operation(summary = "Get active customers")
    @GetMapping("/getActive")
    public List<GetActiveCustomersResponse> getActive() {
        return customerService.getActiveCustomers();
    }

    /**
     * Retrieves a specific customer by ID
     */
    @Operation(summary = "Get customer by ID")
    @GetMapping("/getById/{id}")
    public GetByIDCustomerResponse getById(@PathVariable int id) {
        return customerService.getById(id);
    }

    /**
     * Creates a new customer
     */
    @Operation(summary = "Create new customer")
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(CreateCustomerRequest createCustomerRequest) {
        this.customerService.add(createCustomerRequest);
    }

    /**
     * Updates an existing customer
     */
    @Operation(summary = "Update customer")
    @PutMapping("/update")
    public void update(UpdateCustomerRequest updateCustomerRequest) {
        this.customerService.update(updateCustomerRequest);
    }

    /**
     * Permanently deletes a customer
     */
    @Operation(summary = "Delete customer permanently")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.customerService.delete(id);
    }

    /**
     * Deactivates a customer (soft delete)
     */
    @Operation(summary = "Deactivate customer account")
    @DeleteMapping("/softDelete/{id}")
    public void softDeleteCustomer(@PathVariable int id){
        this.customerService.softDeleteCustomer(id);
    }
}
