package webshop.category;

import org.springframework.stereotype.Service;
import webshop.CustomResponseStatus;
import webshop.Response;
import webshop.product.Product;
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

    public CustomResponseStatus deleteCategoryAndUpdateProductCategoryId(long categoryId){
        productDao.updateProductCategoryIfCategoryIsDeleted(categoryId);

        boolean found = false;
        for (Category category : categoryDao.listAllCategories()){
            if (category.getId() == categoryId){
                found = true;
            }
        }
        if (found){
            categoryDao.deleteCategoryById(categoryId);
            for (int i = 0; i < categoryDao.listAllCategories().size(); i++){
                categoryDao.updateSequence(i + 1, categoryDao.listAllCategories().get(i).getId());
            }
            return new CustomResponseStatus(Response.SUCCESS, "Deleted successfully.");
        } else {
            return new CustomResponseStatus(Response.FAILED, "This category is already deleted.");
        }
    }

    public CustomResponseStatus updateCategoryById(Category category){
        if ((categoryDao.getNumberOfCategories() + 1) < category.getSequence()) {
            return new CustomResponseStatus(Response.FAILED,"Sequence can not be bigger then the number of categories.");
        }
        if (category.getSequence() == 0){
            category.setSequence(categoryDao.getNumberOfCategories() + 1);
        }
        categoryDao.updateCategoryById(category);
        if (categoryDao.doesSequenceAlreadyExist(category)){
            List<Category> categories = categoryDao.listAllCategories();
            for (int i = 0; i < categories.size(); i++){
                if (i + 1 == category.getSequence() && categories.get(i).getId() == category.getId()) {
                    continue;
                }
                categoryDao.updateSequenceTwo(i + 1, categories.get(i));
            }
        }
        return new CustomResponseStatus(Response.SUCCESS, String.format("Category updated successfully with ID %d", category.getId()));
    }

    public CustomResponseStatus updateAllCategories(List<Category> categories) {
        categories.forEach(category -> categoryDao.updateCategoryById(category));
        return new CustomResponseStatus(Response.SUCCESS, "done");
    }

    public List<Product> listProductsByCategoryName(String categoryName) {

        return categoryDao.listAllProductsByCategoryName(categoryName);
    }

    public Category getCategoryWithProductsByName(String categoryName){
        List<Category> categoryList = categoryDao.listAllCategories();

        Category foundCategory = new Category();

        for (Category category : categoryList){
            if (category.getCategoryName().equals(categoryName)){
                category.setProducts(categoryDao.listAllProductsByCategoryName(categoryName));
                foundCategory = category;
            }
        }
        return foundCategory;
    }
}
