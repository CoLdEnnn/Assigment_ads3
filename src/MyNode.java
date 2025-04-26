public class MyNode<T extends Comparable<T>> {
    T value;
    MyNode<T> left;
    MyNode<T> right;

    public MyNode(T value) {
        this.value = value;
        left = right = null;
    }
}