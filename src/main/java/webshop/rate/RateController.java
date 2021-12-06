package webshop.rate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import webshop.product.ProductService;
import webshop.user.UserService;

@RestController
public class RateController {
    @Autowired
    private RateService rateService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
}
