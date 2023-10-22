package kk.oops.objectCloning;

public class Human implements Cloneable {
    int age;
    String name;

    int[] arr = new int[] {1,2,3,4,5};;

    public Human (Human human) {    // This can be used to make deep copy but it'll be slow. So, we'll modify the clone method of Object class (It's not from Cloneable interface)
        this.name = human.name;
        this.age = human.age;
        this.arr = human.arr;
    }

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    // Faster way of cloning the objects, faster than 1st constructor where we pass object of this class type itself.
    // This method does shallow copy.
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    public Object deepClone() throws CloneNotSupportedException {
        Human cloned = (Human) this.clone();
        cloned.name = new String(this.name);
        cloned.arr = new int[this.arr.length];
        for (int i = 0; i < this.arr.length; i++) {
            cloned.arr[i] = this.arr[i];
        }
        return cloned;
    }
}
