package webshop.product;

import org.springframework.stereotype.Service;
import webshop.category.Category;
import webshop.category.CategoryDao;

import java.util.HashMap;
import java.util.List;

@Service
public class ProductService {

    private ProductDao productDao;
    private CategoryDao categoryDao;

    public ProductService(ProductDao productDao, CategoryDao categoryDao) {
        this.productDao = productDao;
        this.categoryDao = categoryDao;
    }

    public List<Product> listAllProducts() {
        return productDao.listAllProducts();
    }

    public Category findProductByAddress(String address) {
        return productDao.findProductByAddressWithCategory(address);
    }

    public long addNewProductAndGetId(Category category) {

        Category foundCategory = categoryDao.getIdOfTheUpdatedName(category);

        if (!productDao.isCodeUnique(category.getProducts().get(0).getCode())) {
            throw new IllegalArgumentException("This code already exists.");
        }
        if (!productDao.isNameUnique(category.getProducts().get(0).getName())) {
            throw new IllegalArgumentException("This name already exists.");
        }
        return productDao.addNewProductAndGetId(category, foundCategory.getId());
    }

    public Object findProductByAddressTwo(String address) {
        return productDao.findProductByAddressTwo(address);
    }

    public List<Product> lastThreeProducts() {
        return productDao.lastThreeProducts();
    }

    public Product getProductByProductId(long productId) {
        return productDao.getProductByProductId(productId);
    }
}
