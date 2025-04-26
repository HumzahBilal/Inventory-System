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

    public String getInfo() {
        return id + " " + name + " $" + price + " Qty: " + quantity;
    }
}

