package ozgur.crmTool.business.requests.note;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateNoteRequest {
    private int id;
    private int customerId;
    private String content;
    private String author;
}
