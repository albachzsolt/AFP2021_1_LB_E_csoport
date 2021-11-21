package webshop.category;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import webshop.CustomResponseStatus;
import webshop.Response;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    private CategoryValidator categoryValidator = new CategoryValidator();


    @GetMapping("/api/products")
    public List<Category> listAllProducts(){
        return categoryService.listAllProducts();
    }

    @GetMapping("/api/categories")
    public List<Category> listAllCategories(){
        return categoryService.listAllCategories();
    }

    @PostMapping("/api/categories")
    public CustomResponseStatus addNewCategory(@RequestBody Category category){
        if (categoryValidator.isEmpty(category.getCategoryName())){
            return new CustomResponseStatus(Response.FAILED, "Category name can not be empty.");
        }
        return categoryService.addNewCategory(category);
    }
}
