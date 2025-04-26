public class Main {
    public static void main(String[] args) {
        MyBST<Integer> myBST = new MyBST<>();
        myBST.insert(5);
        myBST.insert(6);
        myBST.insert(4);
        myBST.insert(3);
        myBST.insert(2);
        myBST.insert(1);
        System.out.println("Size: " + myBST.size());
        myBST.inOrder();

        myBST.delete(2);

        myBST.inOrder();

    }
}