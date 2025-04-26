public class MyBST<T extends Comparable<T>> {
    private MyNode<T>  root;

    public MyBST() {
        root = null;
    }

    public void insert(T data) {
        root = insert(root, data);
    }

    private MyNode<T> insert(MyNode<T> currentNode, T data) {
        if (currentNode == null) {
            return new MyNode<>(data);
        }
        if (data.compareTo(currentNode.value) < 0) {
            currentNode.left = insert(currentNode.left, data);
        }
        else if (data.compareTo(currentNode.value) > 0) {
            currentNode.right = insert(currentNode.right, data);
        }
        return currentNode;
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(MyNode<T> currentNode) {
        if (currentNode != null) {
            inOrder(currentNode.left);
            System.out.print(currentNode.value+" ");
            inOrder(currentNode.right);
        }
    }

    public void delete(T data) {
        root = delete(root, data);
    }
    private MyNode<T> delete(MyNode<T> currentNode, T data) {
        if (currentNode == null) {
            return null;
        }
        if (data.compareTo(currentNode.value) < 0) {
            currentNode.left = delete(currentNode.left, data);
        }
        else if (data.compareTo(currentNode.value) > 0) {
            currentNode.right = delete(currentNode.right, data);
        }
        else {
            if(currentNode.left == null){
                return currentNode.right;
            }
            else if(currentNode.right == null){
                return currentNode.left;
            }

            currentNode.value = minValue(currentNode.right);
            currentNode.right = delete(currentNode.right, currentNode.value);

        }
        return currentNode;
    }
    private T minValue(MyNode<T> currentNode) {
        T min = currentNode.value;
        while (currentNode.left != null) {
            min = currentNode.value;
            currentNode = currentNode.left;
        }
        return min;
    }
}