import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {

    private class Node {
        Key key;
        Value value;
        Node left, right;
        int size;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.size = 1;
        }
    }

    private Node root;

    @Override
    public void put(Key key, Value value) {
        root = put(key, value, root);
    }

    private Node put(Key key, Value value, Node node) {
        if (node == null) return new Node(key, value);
        int cmp = node.key.compareTo(key);
        if (cmp > 0) node.left = put(key, value, node.left);
        else if (cmp < 0) node.right = put(key, value, node.right);
        else node.value = value;
        node.size = size(node.left) + size(node.right) + 1;
        return node;
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
        BST<Integer, String> bst = new BST<>();
        System.out.println(bst.isEmpty());
        bst.put(2, "2");
        bst.put(6, "6");
        bst.put(4, "4");
        bst.delete(3);
        System.out.println(bst.size() == 3);
        bst.put(3, "3");
        bst.put(5, "5");
        bst.delete(4);
        System.out.println(!bst.contains(4));
        System.out.println(Objects.equals(bst.get(5), "5"));
        System.out.println(bst.getKeys().stream().map(Object::toString).collect(Collectors.joining(",")).equals("2,6,5,3"));
    }

}
