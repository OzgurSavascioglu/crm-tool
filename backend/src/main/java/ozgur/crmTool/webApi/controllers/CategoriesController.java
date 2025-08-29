package ozgur.crmTool.webApi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ozgur.crmTool.business.abstracts.CategoryService;
import ozgur.crmTool.business.responses.category.GetAllCategoriesResponse;
import ozgur.crmTool.business.responses.customer.GetAllCustomersResponse;
import ozgur.crmTool.business.responses.wrapper.ListResponseWrapper;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    private CategoryService categoryService;
    @GetMapping("/getAll")
    public ListResponseWrapper<GetAllCategoriesResponse> getAll() {
        try {
            Thread.sleep(5000); // 5000 ms = 5 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // restore interrupted status
            e.printStackTrace();
        }

        List<GetAllCategoriesResponse> customers = categoryService.getAll();
        return new ListResponseWrapper<>(true, "Customers successfully retrieved", customers);
    }
}
