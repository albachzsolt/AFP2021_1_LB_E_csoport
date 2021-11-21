package webshop.category;

import org.springframework.stereotype.Service;
import webshop.CustomResponseStatus;
import webshop.Response;
import webshop.product.ProductDao;

import java.util.List;

@Service
public class CategoryService {

    private CategoryDao categoryDao;
    private ProductDao productDao;

    public CategoryService(CategoryDao categoryDao, ProductDao productDao) {
        this.categoryDao = categoryDao;
        this.productDao = productDao;
    }

    public List<Category> listAllProducts() {
        List<Category> categoryList = categoryDao.listAllCategories();

        for (Category category : categoryList) {
            category.setProducts(productDao.listAllProductsByCategory(category));
        }
        return categoryList;
    }

    public List<Category> listAllCategories() {
        return categoryDao.listAllCategories();
    }

    public CustomResponseStatus addNewCategory(Category category){
        if ((categoryDao.getNumberOfCategories() + 1) < category.getSequence()) {
            return new CustomResponseStatus(Response.FAILED,"Sequence can not be bigger then the number of categories.");
        }
        if (category.getSequence() == 0){
            category.setSequence(categoryDao.getNumberOfCategories() + 1);
        }
        if (categoryDao.doesSequenceAlreadyExist(category)){
            List<Category> categories = categoryDao.listAllCategories();
            for (int i = 0; i < categories.size(); i++){
                int sequence = categoryDao.getSequenceById(categories.get(i).getId());
                if (categories.get(i).getSequence() < category.getSequence()){
                    continue;
                }
                categoryDao.updateSequence(sequence + 1, categories.get(i).getId());
            }
        }
        long id = categoryDao.addNewCategoryAndGetId(category);
        return new CustomResponseStatus(Response.SUCCESS, String.format("Category added successfully with ID %d", id));
    }
}
