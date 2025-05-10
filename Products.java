public class Products {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Products(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void showInfo() {
        System.out.println("ID: " + id + ", Name: " + name +
                ", Price: $" + price + ", Qty: " + quantity);
    }

    public void adjustStock(int amount) {
        this.quantity += amount;
    }

    // Needed for the tree and hash table
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}


