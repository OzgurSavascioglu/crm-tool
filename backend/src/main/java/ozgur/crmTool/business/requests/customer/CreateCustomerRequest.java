package ozgur.crmTool.business.requests.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {

    /**
     * Full name of the customer.
     * Required field with length validation.
     */
    @NotBlank(message = "Name cannot be empty")
    @Size(min=1, max = 100, message = "Name must be between 1-100 characters")
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
