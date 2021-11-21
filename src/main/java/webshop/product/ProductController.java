package webshop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import webshop.CustomResponseStatus;
import webshop.Response;
import webshop.category.Category;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    private ProductValidator productValidator = new ProductValidator(productService);

    public static final String INVALID_ADDRESS = "Invalid address";

    @GetMapping("/api/product/{address}")
    public Object findProductByAddressTwo(@PathVariable String address) {
        productValidator = new ProductValidator(productService);
        if (productValidator.isValidAddress(address)) {
            try {
                return productService.findProductByAddress(address);
            } catch (Exception e){
                return new CustomResponseStatus(Response.FAILED, INVALID_ADDRESS);
            }
        } else {
            return new CustomResponseStatus(Response.FAILED,  INVALID_ADDRESS);
        }
    }

    //  @GetMapping("/api/product/{address}")
    public Category findProductByAddress(@PathVariable String address) {
        return productService.findProductByAddress(address);
    }
}
