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

    public Integer getSumOfActiveOrdersForThisMonth() {
        return sumOfActiveOrdersForThisMonth;
    }

    public void setSumOfActiveOrdersForThisMonth(Integer sumOfActiveOrdersForThisMonth) {
        this.sumOfActiveOrdersForThisMonth = sumOfActiveOrdersForThisMonth;
    }

    public Integer getSumOfAmountForActiveOrdersForThisMonth() {
        return sumOfAmountForActiveOrdersForThisMonth;
    }

    public void setSumOfAmountForActiveOrdersForThisMonth(Integer sumOfAmountForActiveOrdersForThisMonth) {
        this.sumOfAmountForActiveOrdersForThisMonth = sumOfAmountForActiveOrdersForThisMonth;
    }

    public Integer getSumOfDeliveredOrdersForThisMonth() {
        return sumOfDeliveredOrdersForThisMonth;
    }

    public void setSumOfDeliveredOrdersForThisMonth(Integer sumOfDeliveredOrdersForThisMonth) {
        this.sumOfDeliveredOrdersForThisMonth = sumOfDeliveredOrdersForThisMonth;
    }

    public Integer getSumOfDeletedOrdersForThisMonth() {
        return sumOfDeletedOrdersForThisMonth;
    }

    public void setSumOfDeletedOrdersForThisMonth(Integer sumOfDeletedOrdersForThisMonth) {
        this.sumOfDeletedOrdersForThisMonth = sumOfDeletedOrdersForThisMonth;
    }

    public Integer getSumOfAmountDeletedOrdersForThisMonth() {
        return sumOfAmountDeletedOrdersForThisMonth;
    }

    public void setSumOfAmountDeletedOrdersForThisMonth(Integer sumOfAmountDeletedOrdersForThisMonth) {
        this.sumOfAmountDeletedOrdersForThisMonth = sumOfAmountDeletedOrdersForThisMonth;
    }

    @Override
    public String toString() {
        return "StatusOrderReport{" +
                "year=" + year +
                ", month=" + month +
                ", sumOfActiveOrdersForThisMonth=" + sumOfActiveOrdersForThisMonth +
                ", sumOfAmountForActiveOrdersForThisMonth=" + sumOfAmountForActiveOrdersForThisMonth +
                ", sumOfDeliveredOrdersForThisMonth=" + sumOfDeliveredOrdersForThisMonth +
                ", sumOfDeletedOrdersForThisMonth=" + sumOfDeletedOrdersForThisMonth +
                ", sumOfAmountDeletedOrdersForThisMonth=" + sumOfAmountDeletedOrdersForThisMonth +
                '}';
    }
}
