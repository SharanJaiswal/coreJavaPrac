package kk.arraylistAndGenerics;

import java.util.Arrays;
import java.util.List;

// Generic strict type "checks" happen at compile time, replaces with their bounds or Object (if type param is unbounded).
// Hence, bytecodes produces for runtime has ordinary classes, interface, methods.
// Now, we know that object creation happens generally at runtime, in heap memory, where code like these gets executed: "new T[]" or "new T()"
// These object creation is not happen at compile time. In other words, lets assume that "T" doesn't get replaced in these statements at compile time.
// Therefore, at runtime, JVM has statements like "new T[]" or "new T()" which doesn't make clear the type of the objects. Hence, it gives error.
// If no error is there, generics hence don't create runtime overhead. Because replacement happens at compile time itself.
// Its highly complicated working with generics. Hence, we will be using Object. Also, T cannot be replaced with primitive data types.
// Interfaces can also have generic types.
public class CustomArrayListGeneric<T> {    // public class CustomArrayListGeneric<T extends ClassName> // Ensures T can only be of ClassName or ClassName's child class.
    private Object[] data;
    final private static int DEFAULT_SIZE = 10;
    private int size = 0;   // will work as an index iterator

    public CustomArrayListGeneric() {
//        this.data = new T[CustomArrayListGeneric.DEFAULT_SIZE]; // Error because Type param T cannot be instantiated directly
        this.data = new Object[CustomArrayListGeneric.DEFAULT_SIZE];
    }

    public void add (T element) {
        if (this.isFull()) {
            this.resize();
        }
        this.data[this.size++] = element;
    }

    public T remove() {
        return (T)(this.data[this.size--]); // Casting is required because we are accommodating bigger type (Object) into smaller type (T)
    }

    public T get(int idx) {
        return (T)(this.data[idx]);
    }

    public int size() {
        return this.size;
    }

    public void set(int idx, int ele) {
        this.data[idx] = ele;
    }

    private void resize() {
        int idx = 0;
        Object[] temp = new Object[this.data.length * 2];
        for (Object ele : this.data) {
            temp[idx++] = ele;
        }
        this.data = temp;
    }

    private boolean isFull() {
        return size == data.length;
    }

    // Use of wildcard: Apart from restricting the value of T in general, it can also be used to accept the params to methods, of type ClassName or their child classes.
    // Below is a general example, not related to this class.
    public void getList1 (List<Number> list) { /* We can only receive param of Number type */ }
    // Below, If we are not using generic type T passed to the class, we can use wildcard '?'
    public void getList2 (List<? extends Number> list) { /* We can receive List containing elements of type Number and its subclasses */ }

    @Override
    public String toString() {
        return "CustomArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        CustomArrayListGeneric<Integer> arrayList1 = new CustomArrayListGeneric<>();
        arrayList1.add(45);
        arrayList1.add(90);
        System.out.println(arrayList1);


        // If we dont provide the generic value
        CustomArrayListGeneric arrayList2 = new CustomArrayListGeneric();  // Not providing value of T is also allowed, but raises security issue & concerns because any type can be filled
        arrayList2.add("Sharan");
        arrayList2.add(45);
        System.out.println(arrayList2);

    }
}
