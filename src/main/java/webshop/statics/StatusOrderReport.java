package webshop.statics;

public class StatusOrderReport {

    private int year;
    private int month;
    private Integer sumOfActiveOrdersForThisMonth;
    private Integer sumOfAmountForActiveOrdersForThisMonth;
    private Integer sumOfDeliveredOrdersForThisMonth;
    private Integer sumOfDeletedOrdersForThisMonth;
    private Integer sumOfAmountDeletedOrdersForThisMonth;

    public StatusOrderReport(int year, int month) {
        this.year = year;
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }
}
