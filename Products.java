public class Products {
    int id;
    String name;
    double price;
    int quantity;

    public Products(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void showInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Price: $" + price + ", Quantity: " + quantity);
    }

    public void adjustStock(int amount) {
        quantity = quantity + amount;
    }

    public String getName() {
        return name;
    }
}
