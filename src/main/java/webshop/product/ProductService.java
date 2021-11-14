package webshop.product;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ProductService {

    private ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> listAllProducts(){
        return productDao.listAllProducts();
    }

    public Object findProductByAddressTwo(String address){
        return productDao.findProductByAddressTwo(address);
    }

    public List<Product> lastThreeProducts(){
        return productDao.lastThreeProducts();
    }

    public Product getProductByProductId(long productId){
        return productDao.getProductByProductId(productId);
    }
}
