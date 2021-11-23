package webshop.statics;

public class StatData {
    private int year;
    private int month;
    private int piece;
    private int amount;

    public StatData(int year, int month, int piece, int amount) {
        this.year = year;
        this.month = month;
        this.piece = piece;
        this.amount = amount;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getPiece() {
        return piece;
    }

    public int getAmount() {
        return amount;
    }
}
