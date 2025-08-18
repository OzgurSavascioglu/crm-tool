package ozgur.crmTool.business.requests.note;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateNoteRequest {
    private int customer;
    private String content;
    private String author;
}
