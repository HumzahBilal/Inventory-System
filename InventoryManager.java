import java.util.ArrayList;

public class InventoryManager {

    private ArrayList<Products> inventory = new ArrayList<>();

    public void addProduct(Products p) {
        inventory.add(p);
    }

    public ArrayList<Products> getInventory() {
        return inventory;
    }

    public void removeProductById(int id) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getId() == id) {
                inventory.remove(i);
                break;
            }
        }
    }

    public void updateProduct(int id, Products updatedProduct) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getId() == id) {
                inventory.set(i, updatedProduct);
                break;
            }
        }
    }
}

