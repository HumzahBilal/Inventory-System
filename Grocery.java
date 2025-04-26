import java.util.Date;

public class Grocery extends Products {
    Date expiryDate;

    public Grocery(int id, String name, double price, int quantity, String expiryDate) {
        super(id, name, price, quantity);
        this.expiryDate = expiryDate;
    }

    public Date getDate() {
        return expiryDate;
    }
}
