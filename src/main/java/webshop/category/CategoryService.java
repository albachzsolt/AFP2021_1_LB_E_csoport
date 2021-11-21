package webshop.category;

import org.springframework.stereotype.Service;
import webshop.product.ProductDao;

@Service
public class CategoryService {

    private CategoryDao categoryDao;
    private ProductDao productDao;

    public CategoryService(CategoryDao categoryDao, ProductDao productDao) {
        this.categoryDao = categoryDao;
        this.productDao = productDao;
    }
}
