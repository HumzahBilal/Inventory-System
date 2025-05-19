public class Toys extends Products {
    private String brand;

    public Toys(int id, String name, double price, int quantity, String brand) {
        super(id, name, price, quantity);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Brand: " + brand);
    }

    @Override
    public String getType() {
        return "Toys";
    }

    @Override
    public String toFileString() {
        return super.toFileString() + "," + brand;
    }
}


