public class CustomLinkedList {
    private class Node {
        Products data;
        Node next;

        Node(Products p) {
            data = p;
            next = null;
        }
    }

    private Node head;

    public CustomLinkedList() {
        head = null;
    }

    public void add(Products p) {
        Node newNode = new Node(p);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null)
                current = current.next;
            current.next = newNode;
        }
    }

    public void remove(int id) {
        if (head == null) return;

        if (head.data.id == id) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data.id != id) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public Products find(int id) {
        Node current = head;
        while (current != null) {
            if (current.data.id == id) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public void traverse() {
        Node current = head;
        while (current != null) {
            current.data.showInfo();
            System.out.println("-----");
            current = current.next;
        }
    }
}
