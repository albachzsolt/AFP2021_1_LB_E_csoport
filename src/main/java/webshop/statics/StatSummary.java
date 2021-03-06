package webshop.statics;

import webshop.order.OrderStatus;

public class StatSummary {

    private OrderStatus orderStatus;
    private int piece;
    private long amount;


    public StatSummary(OrderStatus orderStatus, int piece, long amount) {
        this.orderStatus = orderStatus;
        this.piece = piece;
        this.amount = amount;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public int getPiece() {
        return piece;
    }

    public long getAmount() {
        return amount;
    }
}
