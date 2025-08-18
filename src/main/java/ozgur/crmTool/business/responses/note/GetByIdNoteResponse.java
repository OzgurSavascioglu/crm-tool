package ozgur.crmTool.business.responses.note;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdNoteResponse {
    private int id;

    private int customerId;

    private String content;

    private String author;

    private boolean isActive;
}
