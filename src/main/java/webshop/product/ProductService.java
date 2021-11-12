package webshop.product;

import org.springframework.stereotype.Service;

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
}
