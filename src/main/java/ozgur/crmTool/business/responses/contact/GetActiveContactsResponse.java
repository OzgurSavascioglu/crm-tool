package ozgur.crmTool.business.responses.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetActiveContactsResponse {
    private int id;

    private int customerId;

    private String name;

    private String phone;

    private String email;

    private String title;

    private String position;

    private String contactPreferences;

    private boolean isActive;
}
