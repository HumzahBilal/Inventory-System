public class Products {
    protected int id;
    protected String name;
    protected double price;
    protected int quantity;

    public Products(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void showInfo() {
        System.out.println("ID: " + id + ", Name: " + name +
                ", Price: $" + price + ", Quantity: " + quantity);
    }

    public void adjustStock(int amount) {
        quantity += amount;
    }

    public String getType() {
        return "Products";
    }

    public String toFileString() {
        return id + "," + name + "," + price + "," + quantity;
    }
}




