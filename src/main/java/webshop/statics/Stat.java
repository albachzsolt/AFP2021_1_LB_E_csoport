package webshop.statics;

public class Stat {

    private int numOfUsers;
    private int numOfActiveProducts;
    private int numOfProducts;
    private int numOfActiveOrders;
    private int numOfOrders;


    public Stat(int numOfUsers, int numOfActiveProducts, int numOfProducts, int numOfActiveOrders, int numOfOrders) {
        this.numOfUsers = numOfUsers;
        this.numOfActiveProducts = numOfActiveProducts;
        this.numOfProducts = numOfProducts;
        this.numOfActiveOrders = numOfActiveOrders;
        this.numOfOrders = numOfOrders;
    }
}
