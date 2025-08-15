package ozgur.crmTool.business.requests.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteContactRequest {
    private int id;
    private boolean isActive;
}
