import java.util.ArrayList;

public class InventoryManager {
    private ArrayList<Products> productList;
    private ProductTree productTree;
    private ProductHashTable hashTable;

    public InventoryManager() {
        productList = new ArrayList<>();
        productTree = new ProductTree();
        hashTable = new ProductHashTable();
    }

    public void addProduct(Products p) {
        productList.add(p);
        productTree.insert(p);
        hashTable.addProduct(p);
    }

    public void removeProduct(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(i);
                break;
            }
        }
        System.out.println("Note: Removed from list only (tree/hash not updated).");
    }

    public void displayAll() {
        for (Products p : productList) {
            p.showInfo();
        }
    }

    public void searchByName(String name) {
        Products found = productTree.search(name);
        if (found != null) {
            System.out.println("Found in Tree:");
            found.showInfo();
        } else {
            System.out.println("Product not found in Tree.");
        }
    }

    public void searchById(int id) {
        Products found = hashTable.getProduct(id);
        if (found != null) {
            System.out.println("Found in Hash Table:");
            found.showInfo();
        } else {
            System.out.println("Product not found in Hash Table.");
        }
    }
}
