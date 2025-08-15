package ozgur.crmTool.business.requests.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateContactRequest {
    private int id;

    private int customerId;

    private String name;

    private String phone;

    private String email;

    private String title;

    private String position;

    private String contactPreferences;

}
