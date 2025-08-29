package ozgur.crmTool.business.abstracts;

import ozgur.crmTool.business.responses.category.GetAllCategoriesResponse;
import java.util.List;

public interface CategoryService {
    List<GetAllCategoriesResponse> getAll();
}
