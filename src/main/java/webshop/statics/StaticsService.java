package webshop.statics;

import webshop.product.ProductDao;
import webshop.user.UserDao;

public class StaticsService {

    private UserDao userDao;
    private ProductDao productDao;
    private StaticsDao staticsDao;
    //private OrderDao orderDao;


    public StaticsService(UserDao userDao, ProductDao productDao, StaticsDao staticsDao/*, OrderDao orderDao*/) {
        this.userDao = userDao;
        this.productDao = productDao;
        this.staticsDao = staticsDao;
        //this.orderDao = orderDao;
    }
}
