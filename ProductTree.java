public class ProductTree {
    private TreeNode root;

    public void insert(Products product) {
        root = insertRec(root, product);
    }

    private TreeNode insertRec(TreeNode node, Products product) {
        if (node == null) return new TreeNode(product);

        if (product.getName().compareToIgnoreCase(node.product.getName()) < 0) {
            node.left = insertRec(node.left, product);
        } else {
            node.right = insertRec(node.right, product);
        }
        return node;
    }

    public Products search(String name) {
        return searchRec(root, name);
    }

    private Products searchRec(TreeNode node, String name) {
        if (node == null) return null;

        if (node.product.getName().equalsIgnoreCase(name)) {
            return node.product;
        } else if (name.compareToIgnoreCase(node.product.getName()) < 0) {
            return searchRec(node.left, name);
        } else {
            return searchRec(node.right, name);
        }
    }
}
