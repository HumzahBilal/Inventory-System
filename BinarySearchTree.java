public class BinarySearchTree {

    private class BSTNode {
        Products data;
        BSTNode left, right;

        BSTNode(Products p) {
            data = p;
            left = right = null;
        }
    }

    private BSTNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(Products p) {
        root = insertRec(root, p);
    }

    private BSTNode insertRec(BSTNode root, Products p) {
        if (root == null) {
            return new BSTNode(p);
        }
        if (p.getId() < root.data.getId()) {
            root.left = insertRec(root.left, p);
        } else if (p.getId() > root.data.getId()) {
            root.right = insertRec(root.right, p);
        }
        return root;
    }

    public Products search(int id) {
        BSTNode res = searchRec(root, id);
        if (res == null) return null;
        return res.data;
    }

    private BSTNode searchRec(BSTNode root, int id) {
        if (root == null || root.data.getId() == id) return root;
        if (id < root.data.getId())
            return searchRec(root.left, id);
        else
            return searchRec(root.right, id);
    }

    public void inOrderTraversal() {
        inOrderRec(root);
    }

    private void inOrderRec(BSTNode root) {
        if (root != null) {
            inOrderRec(root.left);
            root.data.showInfo();
            System.out.println("-----");
            inOrderRec(root.right);
        }
    }

    public void delete(int id) {
        root = deleteRec(root, id);
    }

    private BSTNode deleteRec(BSTNode root, int id) {
        if (root == null) return root;

        if (id < root.data.getId()) {
            root.left = deleteRec(root.left, id);
        } else if (id > root.data.getId()) {
            root.right = deleteRec(root.right, id);
        } else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data.getId());
        }

        return root;
    }

    private Products minValue(BSTNode node) {
        Products minv = node.data;
        while (node.left != null) {
            minv = node.left.data;
            node = node.left;
        }
        return minv;
    }
}
