package webshop.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.basket.BasketDao;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BasketDao basketDao;

    public UserService(UserDao userDao, BasketDao basketDao) {
        this.userDao = userDao;
        this.basketDao = basketDao;
    }
}
