package ozgur.crmTool.business.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) representing complete customer data in API responses.
 * Contains all customer information suitable for administrative views and reporting.
 * Includes both active and inactive customer records with full details.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCustomersResponse {
    /**
     * Unique customer identifier
     */
    @Schema(description = "Unique database identifier of the customer",
            example = "1025",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private int id;

    /**
     * Legal name of the customer
     */
    @Schema(description = "Full legal name of the customer",
            example = "Jane Doe",
            minLength = 1,
            maxLength = 100)
    private String name;

    /**
     * Primary contact email
     */
    @Schema(description = "Verified email address for communications",
            example = "jane.doe@example.com",
            pattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;

    /**
     * Formatted contact number
     */
    @Schema(description = "Primary contact phone number with country code",
            example = "+905551112233",
            pattern = "^\\+?[0-9\\s-]{6,20}$")
    private String phone;

    /**
     * Complete physical address
     */
    @Schema(description = "Full postal address including city and country",
            example = "123 Business Ave, Istanbul, Turkey")
    private String address;

    /**
     * Registered company name
     */
    @Schema(description = "Legal company name for business customers",
            example = "Acme Corporation",
            maxLength = 100,
            nullable = true)
    private String companyName;

    /**
     * Customer classification category
     */
    @Schema(description = "Business segmentation category",
            example = "PREMIUM",
            maxLength = 50,
            nullable = true)
    private String customerType;

    /**
     * Account status flag
     */
    @Schema(description = "Active status of the customer account",
            example = "true",
            defaultValue = "true")
    private boolean isActive;
}
