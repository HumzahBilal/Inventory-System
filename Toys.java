public class Toys extends Products {
    String brand;

    public Toys(int id, String name, double price, int quantity, String brand) {
        super(id, name, price, quantity);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}
