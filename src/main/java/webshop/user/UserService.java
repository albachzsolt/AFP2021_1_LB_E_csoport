package webshop.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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

    public User findUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    public List<Long> listUserIds() {
        return userDao.listUserIds();
    }

    public long createAndReturnUserId(User user) throws DuplicateKeyException {
        long newlyCreatedUserId = userDao.createUserAndReturnUserId(user);
        if (newlyCreatedUserId == 0) {
            return 0;
        }
        long basketId = basketDao.createBasketForUserIdAndReturnBasketId(newlyCreatedUserId);
        if (basketId < 1) {
            throw new IllegalStateException("Basket was not created for userId: " + newlyCreatedUserId);
        }
        return newlyCreatedUserId;
    }
}
