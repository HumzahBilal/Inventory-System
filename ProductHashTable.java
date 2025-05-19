import java.util.HashMap;

public class ProductHashTable {
    private HashMap<Integer, Products> productMap;

    public ProductHashTable() {
        productMap = new HashMap<>();
    }

    public void addProduct(Products product) {
        productMap.put(product.getId(), product);
    }

    public Products getProduct(int id) {
        if (productMap.containsKey(id)) {
            return productMap.get(id);
        }
        return null;
    }

    public void removeProduct(int id) {
        productMap.remove(id);
    }

    public void displayAll() {
        for (int id : productMap.keySet()) {
            Products p = productMap.get(id);
            System.out.println("ID: " + id + " - " + p.getName());
        }
    }
}

