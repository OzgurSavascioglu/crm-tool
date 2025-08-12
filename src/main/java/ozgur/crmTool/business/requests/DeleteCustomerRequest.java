package ozgur.crmTool.business.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for deactivating customers.
 * Used to receive deletion requests from API endpoints with options for
 * soft deletion (deactivation).
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCustomerRequest {
    /**
     * Unique identifier of the customer to be deleted/deactivated.
     * Required field, must reference an existing customer.
     */
    @NotNull(message = "Customer ID cannot be null")
    @Positive(message = "ID must be a positive number")
    private int id;

    /**
     * Flag indicating user status:
     * - true: active user
     * - false: Soft delete (set isActive=false)
     */
    private boolean isActive;
}
