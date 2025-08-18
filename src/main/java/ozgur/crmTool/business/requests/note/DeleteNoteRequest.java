package ozgur.crmTool.business.requests.note;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteNoteRequest {
    private int id;
    private boolean isActive;
}
