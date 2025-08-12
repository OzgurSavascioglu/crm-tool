package ozgur.crmTool.business.requests;

import jakarta.validation.constraints.*;
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
     * Must be a positive number corresponding to an existing customer.
     */
    @NotNull(message = "ID cannot be null")
    @Positive(message = "ID must be a positive number")
    private int id;

    /**
     * Updated full name of the customer.
     * Required field with length constraints.
     */
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 1, max = 100, message = "Name must be 1-100 characters")
    private String name;

    /**
     * Email address of the customer.
     * Required field with length validation.
     * Validated for proper email format and required.
     */
    @NotBlank(message = "Email cannot be empty")
    @Size(max = 100, message = "Email cannot exceed 100 characters")
    @Email(message = "Invalid email format")
    private String email;

    /**
     * Contact phone number of the customer.
     * Optional field with format validation when provided.
     */
    @Pattern(regexp = "^$|^[+]?[(]?[0-9]{1,4}[)]?[-\\s.]?[0-9]{3}[-\\s.]?[0-9]{4,6}$",
            message = "Invalid phone number format")
    @Size(max = 100, message = "Phone cannot exceed 20 characters")
    private String phone;

    /**
     * Physical address of the customer.
     */
    private String address;

    /**
     * Name of the company the customer represents.
     * Optional field with length validation when provided.
     */
    @Size(max = 100, message = "Company name cannot exceed 100 characters")
    private String companyName;

    /**
     * Type/category of the customer.
     * Optional field with length validation when provided.
     */
    @Size(max = 50, message = "Customer type cannot exceed 50 characters")
    private String customerType;
}
