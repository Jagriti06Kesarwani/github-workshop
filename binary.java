class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BinarySearchTree {
    Node root;

    // Constructor for an empty tree
    BinarySearchTree() { 
        root = null; 
    }

    // Insert a new key
    void insert(int key) { 
        root = insertRec(root, key); 
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    // Search for a specific key
    public Node search(Node root, int key) {
        if (root == null || root.key == key)
            return root;
        if (root.key < key)
            return search(root.right, key);
        return search(root.left, key);
    }

    // In-order traversal: Left -> Root -> Right (returns sorted order)
    void inorder() { 
        inorderRec(root); 
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("In-order traversal:");
        tree.inorder(); // Output: 20 30 40 50 60 70 80
    }
}

