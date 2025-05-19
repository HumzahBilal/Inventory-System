public class Electronics extends Products {
    private int warranty;

    public Electronics(int id, String name, double price, int quantity, int warranty) {
        super(id, name, price, quantity);
        this.warranty = warranty;
    }

    public int getWarranty() {
        return warranty;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Warranty: " + warranty + " months");
    }

    @Override
    public String getType() {
        return "Electronics";
    }

    @Override
    public String toFileString() {
        return super.toFileString() + "," + warranty;
    }
}


