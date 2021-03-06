package webshop.basket;

import org.springframework.stereotype.Service;
import webshop.product.ProductDao;
import webshop.product.ProductData;
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

    public BasketData getBasketDataByUser(String loggedInUsername) {

        User user = userDao.getUserByUsername(loggedInUsername);

        long userId = user.getId();
        long basketId = getOrCreateAndReturnBasketIdByUserId(userId);

        List<BasketItem> actualItemsInBasket = basketDao.getBasketItemsInBasketByBasketId(basketId);

        Basket basket = new Basket(basketId, new UserData(user.getUsername(), user.getUserRole()));
        for (BasketItem basketItem : actualItemsInBasket) {
            basket.addBasketItem(basketItem);
        }

        int sumPieces = basketDao.sumProductPiecesInBasketByBasketId(basketId);
        int sumPrice = basketDao.sumProductPriceInBasketByBasketId(basketId);

        return new BasketData(sumPieces, sumPrice, basket);
    }

    public int addProductToLoggedInBasketByProductData(String loggedInUsername, ProductData productData) {
        long userId = userDao.getUserByUsername(loggedInUsername).getId();
        long basketId = getOrCreateAndReturnBasketIdByUserId(userId);
        int quantity = productData.getProductPieces();
        long productId = productDao.getProductIdByProductCode(productData.getProductCode());
        return basketDao.addProductToBasket(basketId, productId, quantity);
    }

    public int clearBasketByUsername(String loggedInUsername) {
        long userId = userDao.getUserByUsername(loggedInUsername).getId();
        long basketId = getOrCreateAndReturnBasketIdByUserId(userId);
        return basketDao.clearBasketByBasketId(basketId);
    }

    public int deleteOneProductFromBusket(String loggedInUsername, Long productId){
        long userId = userDao.getUserByUsername(loggedInUsername).getId();
        long basketId = getOrCreateAndReturnBasketIdByUserId(userId);
        return basketDao.deleteOneProductFromBusket(basketId,productId);
    }

    public int updateProductQuantityInoLoggedInBasket(String loggedInUsername, ProductData productData) {
        long userId = userDao.getUserByUsername(loggedInUsername).getId();
        long basketId = getOrCreateAndReturnBasketIdByUserId(userId);
        int quantity = productData.getProductPieces();
        long productId = productDao.getProductIdByProductCode(productData.getProductCode());
        return basketDao.updateProductQuantityInBasket(basketId, productId, quantity);
    }

    private long getOrCreateAndReturnBasketIdByUserId(long userId) {
        long basketId = 0;
        if (!basketDao.getAllBasketOwnerIds().contains(userId)) {
            basketId = basketDao.createBasketForUserIdAndReturnBasketId(userId);
        } else {
            basketId = basketDao.getBasketIdByUserId(userId);
        }
        if (basketId == 0) {
            throw new IllegalStateException("Basket does not exist.");
        }
        return basketId;
    }
}
