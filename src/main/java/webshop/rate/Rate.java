package webshop.rate;

import webshop.product.Product;
import webshop.user.User;

import java.time.LocalDate;

public class Rate {
    private long id;
    private String message;
    private int stars;
    private LocalDate date;
    private User user;
    private Product product;
}
