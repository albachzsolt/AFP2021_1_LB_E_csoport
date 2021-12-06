package webshop.rate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import webshop.CustomResponseStatus;
import webshop.Response;
import webshop.product.Product;
import webshop.product.ProductService;
import webshop.user.User;
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

    @GetMapping("/api/rating/{productid}")
    public RateWithStatus getUserRateForProduct(Authentication authentication, @PathVariable long productid) {
        Product product = productService.getProductByProductId(productid);
        Rate rateFromDB;
        if (authentication != null) {
            String loggedInUsername = authentication.getName();
            User loggedInUser = userService.getUserByUsername(loggedInUsername);
            Rate rate = new Rate(loggedInUser, product);
            try {
                rateFromDB = rateService.getRateForUserAndProduct(rate);
                return new RateWithStatus(new CustomResponseStatus(Response.SUCCESS, "Rate successfully " +
                        "selected"), rateFromDB);
            }
            catch (IllegalArgumentException ie) {
                CustomResponseStatus responseStatus = new CustomResponseStatus(Response.FAILED, ie.getMessage());
                Rate returnRate = new Rate();
                return new RateWithStatus(responseStatus, returnRate);
            }
        }
        return new RateWithStatus(new CustomResponseStatus(Response.FAILED, "Not logged in!"), new Rate());
    }


}
