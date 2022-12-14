import java.util.ArrayList;
import java.util.List;

public class RedBlackBST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {

    private enum Color {
        RED, BLACK
    }

    private class Node {
        Key key;
        Value value;
        Node left, right;
        int size;
        Color color;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.size = 1;
            this.color = Color.RED;
        }
    }

    private Node root;

    @Override
    public void put(Key key, Value value) {
        root = put(key, value, root);
        root.color = Color.BLACK;
    }

    private Node put(Key key, Value value, Node node) {
        if (node == null) return new Node(key, value);
        int cmp = node.key.compareTo(key);
        if (cmp > 0) node.left = put(key, value, node.left);
        else if (cmp < 0) node.right = put(key, value, node.right);
        else node.value = value;
        if (!isRed(node.left) && isRed(node.right)) node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right)) flipColors(node);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    private boolean isRed(Node node) {
        return node != null && Color.RED.equals(node.color);
    }

    private void flipColors(Node node) {
        node.left.color = Color.BLACK;
        node.right.color = Color.BLACK;
        node.color = Color.RED;
    }

    private Node rotateLeft(Node node) {
        Node right = node.left;
        node.right = right.left;
        right.left = node;
        right.color = node.color;
        node.color = Color.RED;
        right.size = node.size;
        node.size = 1 + size(node.left) + size(node.right);
        return right;
    }

    private Node rotateRight(Node node) {
        Node left = node.left;
        node.left = left.right;
        left.right = node;
        left.color = node.color;
        node.color = Color.RED;
        left.size = node.size;
        node.size = 1 + size(node.left) + size(node.right);
        return left;
    }

    @Override
    public Value get(Key key) {
        return get(key, root);
    }

    private Value get(Key key, Node node) {
        if (node == null) return null;
        int cmp = node.key.compareTo(key);
        if (cmp > 0) return get(key, node.left);
        else if (cmp < 0) return get(key, node.right);
        else return node.value;
    }

    @Override
    public void delete(Key key) {
        root = delete(key, root);
    }

    private Node delete(Key key, Node node) {
        if (node == null) return null;
        int cmp = node.key.compareTo(key);
        if (cmp > 0) node.left = delete(key, node.left);
        else if (cmp < 0) node.right = delete(key, node.right);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node min = getMin(node.right);
            node.right = deleteMin(node.right);
            node.key = min.key;
            node.value = min.value;
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    private Node getMin(Node node) {
        if (node.left == null) return node;
        else return getMin(node.left);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public boolean contains(Key key) {
        Node pointer = root;
        while (pointer != null) {
            if (pointer.key.equals(key)) return true;
            else pointer = (pointer.key.compareTo(key) > 0) ? pointer.left : pointer.right;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        return node == null ? 0 : node.size;
    }

    @Override
    public List<Key> getKeys() {
        List<Key> keys = new ArrayList<>();
        putKeys(root, keys);
        return keys;
    }

    private void putKeys(Node node, List<Key> keys) {
        if (node == null) return;
        keys.add(node.key);
        putKeys(node.left, keys);
        putKeys(node.right, keys);
    }

    public static void main(String[] args) {
        // delete not implemented
    }

}
