import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class InventoryManager {
    ArrayList<Products> productList = new ArrayList<>();
    Queue<Products> restockQueue = new LinkedList<>();
    MyLinkedList productLog = new MyLinkedList();

    public void addProduct(Products p) {
        productList.add(p);
        productLog.add(p.name + " added");
        if (p.quantity < 5) {
            restockQueue.add(p);
        }
    }

    public void printProducts() {
        for (Products p : productList) {
            System.out.println(p.getInfo());
        }
    }

    public void printRestockQueue() {
        System.out.println("Products to Restock:");
        for (Products p : restockQueue) {
            System.out.println(p.getInfo());
        }
    }

    public void printLog() {
        System.out.println("Product Log:");
        productLog.display();
    }
}
