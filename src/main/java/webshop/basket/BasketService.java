package webshop.basket;

import org.springframework.stereotype.Service;
import webshop.product.ProductDao;
import webshop.user.User;
import webshop.user.UserDao;
import webshop.user.UserData;

import java.util.List;

@Service
public class BasketService {

    private BasketDao basketDao;
    private UserDao userDao;
    private ProductDao productDao;

    public BasketService(BasketDao basketDao, UserDao userDao, ProductDao productDao) {
        this.basketDao = basketDao;
        this.userDao = userDao;
        this.productDao = productDao;
    }


}
