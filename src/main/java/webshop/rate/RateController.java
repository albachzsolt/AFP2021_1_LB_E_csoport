package webshop.rate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import webshop.product.Product;
import webshop.product.ProductService;
import webshop.user.UserService;

import java.util.List;

@RestController
public class RateController {
    @Autowired
    private RateService rateService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @GetMapping("/api/rating/list/{productid}")
    public List<Rate> getRatesForProduct(@PathVariable long productid) {
        Product product = productService.getProductByProductId(productid);
        return rateService.getRatesForProduct(product);
    }

    @GetMapping("/api/rating/avg/{productid}")
    public double getAvgRatesForProduct(@PathVariable long productid) {
        Product product = productService.getProductByProductId(productid);
        return rateService.getAvgRatesForProduct(product);
    }
}
