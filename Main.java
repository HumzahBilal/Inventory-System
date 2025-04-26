public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        Electronics e1 = new Electronics(1, "Laptop", 1200.00, 3, 12);
        Clothing c1 = new Clothing(2, "Shirt", 25.99, 10, "M");
        Grocery g1 = new Grocery(3, "Milk", 3.99, 2, "2025-05-01");
        Toys t1 = new Toys(4, "Action Figure", 15.50, 4, "Hasbro");

        manager.addProduct(e1);
        manager.addProduct(c1);
        manager.addProduct(g1);
        manager.addProduct(t1);

        manager.printProducts();
        System.out.println();
        manager.printRestockQueue();
        System.out.println();
        manager.printLog();
    }
}

