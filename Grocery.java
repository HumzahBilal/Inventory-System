public class Grocery extends Products {
    private String expiryDate;

    public Grocery(int id, String name, double price, int quantity, String expiryDate) {
        super(id, name, price, quantity);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Expiry Date: " + expiryDate);
    }

    @Override
    public String getType() {
        return "Grocery";
    }

    @Override
    public String toFileString() {
        return super.toFileString() + "," + expiryDate;
    }
}

