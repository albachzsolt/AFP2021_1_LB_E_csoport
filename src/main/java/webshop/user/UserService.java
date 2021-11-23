package webshop.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.basket.BasketDao;

import java.util.List;

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

    public List<String> getAllUsernames() {
        return userDao.getAllUsernames();
    }

    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    public List<User> listAllUsers() {
        return userDao.listAllUsers();
    }
}
