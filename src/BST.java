import java.util.Iterator;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> implements Iterable<K>{
    private Node root;
    private int size;

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    public BST(){
        root = null;
        size = 0;
    }

    public void put(K key, V value){
        root = put(root, key, value);
    }
    private Node put(Node currentNode, K key, V value){
        if(currentNode == null){
            size++;
            return new Node(key, value);
        }
        int cmp = key.compareTo(currentNode.key);
        if(cmp < 0){
            currentNode.left = put(currentNode.left, key, value);
        } else if(cmp > 0){
            currentNode.right = put(currentNode.right, key, value);
        } else {
            currentNode.value = value;
        }
        return currentNode;
    }
    public V get(K key){
        Node currentNode = root;
        while(currentNode != null){
            int cmp = key.compareTo(currentNode.key);
            if(cmp < 0){
                currentNode = currentNode.left;
            } else if(cmp > 0){
                currentNode = currentNode.right;
            } else {
                return currentNode.value;
            }
        }
        return null;
    }
    public void delete(K key){root = delete(root, key);}
    private Node delete(Node currentNode, K key) {
        if (currentNode == null) return null;

        int cmp = key.compareTo(currentNode.key);
        if (cmp < 0) {
            currentNode.left = delete(currentNode.left, key);
        } else if (cmp > 0) {
            currentNode.right = delete(currentNode.right, key);
        } else {
            size--;
            if (currentNode.left == null) return currentNode.right;
            if (currentNode.right == null) return currentNode.left;

            Node temp = currentNode;
            currentNode = minNode(temp.right);
            currentNode.right = deleteMin(temp.right);
            currentNode.left = temp.left;
        }
        return currentNode;
    }
    private Node minNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        return node;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<K> iterator() {
        return new InOrderIterator();
    }

    private class InOrderIterator implements Iterator<K> {
        private Stack<Node> stack = new Stack<>();

        public InOrderIterator() {
            pushLeft(root);
        }

        private void pushLeft(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public K next() {
            Node current = stack.pop();
            pushLeft(current.right);
            return current.key;
        }
    }

    // Bonus: In-order traversal printing key-value pairs
    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print("[" + node.key + "=" + node.value + "] ");
            inOrder(node.right);
        }
    }
}
