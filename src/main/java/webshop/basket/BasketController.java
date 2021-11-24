package webshop.basket;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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


}
