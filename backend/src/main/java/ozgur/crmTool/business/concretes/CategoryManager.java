package ozgur.crmTool.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ozgur.crmTool.business.abstracts.CategoryService;
import ozgur.crmTool.business.responses.category.GetAllCategoriesResponse;
import ozgur.crmTool.core.utilities.mappers.ModelMapperManager;
import ozgur.crmTool.dataAccess.abstracts.CategoryRepository;
import ozgur.crmTool.entities.concretes.Category;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapperManager modelMapperService;

    @Override
    public List<GetAllCategoriesResponse> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<GetAllCategoriesResponse> categoriesResponses = categories.stream()
                .map(category->this.modelMapperService.forResponse()
                        .map(category, GetAllCategoriesResponse.class)).collect(Collectors.toList());
        return categoriesResponses;
    }
}
