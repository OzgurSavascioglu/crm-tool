package ozgur.crmTool.business.responses.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListResponseWrapper<T>{
    private boolean success;
    private String message;
    private List<T> data;
}
