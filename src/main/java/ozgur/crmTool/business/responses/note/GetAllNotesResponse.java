package ozgur.crmTool.business.responses.note;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ozgur.crmTool.entities.concretes.Customer;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllNotesResponse {
    private int id;

    private int customerId;

    private String content;

    private String author;

    private boolean isActive;
}
