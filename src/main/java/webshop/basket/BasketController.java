package webshop.basket;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import webshop.CustomResponseStatus;
import webshop.Response;
import webshop.product.ProductData;
import webshop.user.UserData;
import webshop.user.UserRole;

@RestController
public class BasketController {

    private BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping(value = "/basket")
    @ResponseBody
    public BasketData getBasketDataForActualUser(Authentication authentication) {

        if (authentication != null) {
            String loggedInUsername = authentication.getName();
            return basketService.getBasketDataByUser(loggedInUsername);
        } else {
            return (new BasketData(0, 0, new Basket(0, new UserData("",
                    UserRole.NOT_AUTHENTICATED))));
        }
    }

    @PostMapping("/basket")
    public CustomResponseStatus addProductToLoggedInBasket(Authentication authentication,
                                                           @RequestBody ProductData productData) {
        if (authentication != null) {
            String loggedInUsername = authentication.getName();
            int numberOfSqlAffectedRows =
                    basketService.addProductToLoggedInBasketByProductData(loggedInUsername,
                            productData);
            if (numberOfSqlAffectedRows != 1) {
                return new CustomResponseStatus(Response.FAILED, "Error. Could not add to basket.");
            } else {
                return new CustomResponseStatus(Response.SUCCESS, "Succesfully added to basket.");
            }
        } else {
            return new CustomResponseStatus(Response.FAILED, "Please sign in to start shopping.");
        }
    }

    @DeleteMapping("/basket")
    public CustomResponseStatus clearBasket(Authentication authentication) {
        if (authentication != null) {
            String loggedInUsername = authentication.getName();
            int numberOfSqlAffectedRows =
                    basketService.clearBasketByUsername(loggedInUsername);
            if (numberOfSqlAffectedRows == 0) {
                return new CustomResponseStatus(Response.SUCCESS, "Your basket is already empty.");
            } else {
                return new CustomResponseStatus(Response.SUCCESS, "Your basket has been cleared.");
            }
        } else {
            return new CustomResponseStatus(Response.FAILED, "Please sign in to manage your basket.");
        }
    }

    @DeleteMapping("/basketitem/{productId}")
    public CustomResponseStatus deleteOneProductFromBasket(Authentication authentication, @PathVariable long productId
    ) {
        if (authentication != null) {
            String loggedInUsername = authentication.getName();
            int numberOfSqlAffectedRows =
                    basketService.deleteOneProductFromBusket(loggedInUsername, productId);
            if (numberOfSqlAffectedRows != 1) {
                return new CustomResponseStatus(Response.FAILED, "Error. Could not delete from basket.");
            } else {
                return new CustomResponseStatus(Response.SUCCESS, "Succesfully deleted from basket.");
            }
        } else {
            return new CustomResponseStatus(Response.FAILED, "Please sign in to start shopping.");
        }
    }

    @PostMapping("/basket/update")
    public CustomResponseStatus updateProductQuantityInoLoggedInBasket(Authentication authentication,
                                                                       @RequestBody ProductData productData) {
        if (authentication != null) {
            String loggedInUsername = authentication.getName();
            int numberOfSqlAffectedRows =
                    basketService.updateProductQuantityInoLoggedInBasket(loggedInUsername,
                            productData);
            if (numberOfSqlAffectedRows != 1) {
                return new CustomResponseStatus(Response.FAILED, "Error. Could not update basket.");
            } else {
                return new CustomResponseStatus(Response.SUCCESS, "Basket successfully updated.");
            }
        } else {
            return new CustomResponseStatus(Response.FAILED, "Please sign in to manage your basket.");
        }
    }
}
