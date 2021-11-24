package webshop.basket;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasketController {

    private BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }
}
