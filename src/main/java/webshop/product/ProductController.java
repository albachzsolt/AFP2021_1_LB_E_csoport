package webshop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webshop.CustomResponseStatus;
import webshop.Response;
import webshop.category.Category;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    private ProductValidator productValidator = new ProductValidator(productService);

    public static final String INVALID_ADDRESS = "Invalid address";

    @GetMapping("/api/product/")
    public Object throwErrorOnWrongAddress() {
        return new CustomResponseStatus(Response.FAILED, INVALID_ADDRESS);
    }

    @GetMapping("/api/product/{address}")
    public Object findProductByAddressTwo(@PathVariable String address) {
        productValidator = new ProductValidator(productService);
        if (productValidator.isValidAddress(address)) {
            try {
                return productService.findProductByAddress(address);
            } catch (Exception e) {
                return new CustomResponseStatus(Response.FAILED, INVALID_ADDRESS);
            }
        } else {
            return new CustomResponseStatus(Response.FAILED, INVALID_ADDRESS);
        }
    }

    //  @GetMapping("/api/product/{address}")
    public Category findProductByAddress(@PathVariable String address) {
        return productService.findProductByAddress(address);
    }

    @PostMapping("/api/products")
    public CustomResponseStatus addNewProduct(@RequestBody Category category) {
        productValidator.isAddressNull(category.getProducts().get(0));
        try {
            CustomResponseStatus responseStatus = productValidator.validateProduct(category.getProducts().get(0));
            if (responseStatus.getResponse().equals(Response.SUCCESS)) {
                long id = productService.addNewProductAndGetId(category);
                return new CustomResponseStatus(Response.SUCCESS, String.format("Successfully created with %d id", id));
            } else {
                return responseStatus;
            }
        } catch (IllegalArgumentException iae) {
            return new CustomResponseStatus(Response.FAILED, iae.getMessage());
        }
    }

    @PostMapping("/api/product/{productId}")
    public CustomResponseStatus updateProduct(@PathVariable Long productId, @RequestBody Category category) {
        CustomResponseStatus responseStatus = productValidator.validateProduct(category.getProducts().get(0));
        if (responseStatus.getResponse().equals(Response.FAILED)) {
            return responseStatus;
        } else {
            return productService.updateProduct(productId, category);
        }
    }

    @DeleteMapping("/api/product/{productId}")
    public CustomResponseStatus logicalDeleteProductById(@PathVariable long productId){
        return productService.logicalDeleteProductById(productId);
    }
}
