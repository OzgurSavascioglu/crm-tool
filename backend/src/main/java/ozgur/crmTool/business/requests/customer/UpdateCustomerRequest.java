package ozgur.crmTool.business.requests.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for updating existing customer records.
 * Contains all updatable customer fields with validation constraints.
 * Used to ensure only valid data reaches the service layer.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {
    /**
     * Unique identifier of the customer to update.
     */
    private int id;

    /**
     * Updated full name of the customer.
     */
    private String name;

    /**
     * Email address of the customer.
     */
    private String email;

    /**
     * Contact phone number of the customer.
     */
    private String phone;

    /**
     * Physical address of the customer.
     */
    private String address;

    /**
     * Name of the company the customer represents.
     */
    private String companyName;

    /**
     * Type/category of the customer.
     */
    private String customerType;
}
