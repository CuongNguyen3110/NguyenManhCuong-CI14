public class Animal {
    // thuoc tinh
    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // phuong thuc
    void run() {
        System.out.println(this.name + " running..");
    }

    void eat() {
        System.out.println("eating..");
    }

    void sleep() {
        System.out.println("sleeping..");
    }
}
