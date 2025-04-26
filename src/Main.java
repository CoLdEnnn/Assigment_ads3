import java.util.Random;
class MyTestingClass {
    private int id;
    private String name;

    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Custom hashCode implementation
    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + id;
        hash = 31 * hash + (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTestingClass that = (MyTestingClass) o;
        return id == that.id && name.equals(that.name);
    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
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


        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(11);
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int id = random.nextInt(1000);
            String name = "Name" + random.nextInt(100);
            MyTestingClass key = new MyTestingClass(id, name);
            Student value = new Student("Student" + i, random.nextInt(20) + 18);
            table.put(key, value);
        }
    }
}