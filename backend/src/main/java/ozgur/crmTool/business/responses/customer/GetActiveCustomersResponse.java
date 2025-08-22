package ozgur.crmTool.business.responses.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) representing active customer data in API responses.
 * Contains a subset of customer information suitable for listing active customers.
 * Used to control data exposure and optimize payloads for client applications.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetActiveCustomersResponse {
    /**
     * Unique identifier of the customer
     */
    @Schema(description = "Unique database identifier of the customer",
            example = "1025",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private int id;

    /**
     * Full name of the customer
     */
    @Schema(description = "Full legal name of the customer",
            example = "Jane Doe",
            minLength = 1,
            maxLength = 100)
    private String name;

    /**
     * Contact email address
     */
    @Schema(description = "Verified email address for communications",
            example = "jane.doe@example.com",
            pattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String email;

    /**
     * Primary contact phone number
     */
    @Schema(description = "Primary contact phone number with country code",
            example = "+905551112233",
            pattern = "^\\+?[0-9\\s-]{6,20}$")
    private String phone;

    /**
     * Physical business address
     */
    @Schema(description = "Full postal address including city and country",
            example = "123 Business Ave, Istanbul, Turkey")
    private String address;

    /**
     * Associated company name
     */
    @Schema(description = "Legal company name for business customers",
            example = "Acme Corporation",
            maxLength = 100,
            nullable = true)
    private String companyName;

    /**
     * Customer classification type
     */
    @Schema(description = "Business segmentation category",
            example = "PREMIUM",
            maxLength = 50,
            nullable = true)
    private String customerType;

    /**
     * Active status flag (always true for this response)
     */
    @Schema(description = "Active status of the customer account",
            example = "true",
            defaultValue = "true")
    private boolean isActive;
}
