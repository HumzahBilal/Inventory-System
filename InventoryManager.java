import java.util.ArrayList;

public class InventoryManager {
    ArrayList<Products> productList = new ArrayList<>();

    public void addProduct(Products p) {
        productList.add(p);
    }

    public void removeProduct(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).id == id) {
                productList.remove(i);
                break;
            }
        }
    }

    public void searchProduct(String name) {
        for (Products p : productList) {
            if (p.getName().equalsIgnoreCase(name)) {
                p.showInfo();
            }
        }
    }

    public void sortInventory() {
        for (int i = 0; i < productList.size() - 1; i++) {
            for (int j = 0; j < productList.size() - i - 1; j++) {
                String name1 = productList.get(j).getName();
                String name2 = productList.get(j + 1).getName();
                if (name1.compareTo(name2) > 0) {
                    Products temp = productList.get(j);
                    productList.set(j, productList.get(j + 1));
                    productList.set(j + 1, temp);
                }
            }
        }
    }

    public ArrayList<Products> getInventory() {
        return productList;
    }
}
