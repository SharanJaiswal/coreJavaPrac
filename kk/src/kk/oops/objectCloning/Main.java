package kk.oops.objectCloning;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {  // We added "throws ExceptionName" because we are using clone() method.
        // Exception will be thrown if Human had not cloned Cloneable interface.
        Human human1 = new Human(26, "Sharan");
        Human twin = new Human(human1); // This is taking too much of processing time
        /*
        We can use object cloning. clone() is a method of Object class which makes the exact copy of the object.
        Cloneable interface in java.lang package we have to implement to class, of which the clone objects are being made. Here, it is Human class.
         */
        Human twinNew = (Human) human1.clone();
        System.out.println(human1.equals(twinNew)); // Object cloned will not be same. It'll be in new memory location. Example of shallow copy.
        /*
        In shallow copy, the new object will be created. Inside that new object, primitive data types reference variable will have their value at separate location for obvious reason
        that primitives variables do not refer to memory location in heap. They itself store value of variable.
        While, non-primitives reference variables of new object will point to same memory location where object of non-primitive of that data type is located.
        Hence, in shallow copy, change in one non-primitive will reflect in the cloned object's version of that non-primitive reference variable to which it is pointing to.
        We have seen above that cloned object itself is different, but their String datatype will be pointing to same. Even if they would have Arrays, then both will be pointing to same.
         */
        System.out.println(human1.name.equals(twinNew.name));   // true

        System.out.println(Arrays.toString(human1.arr));
        human1.arr[2] = 46;
        System.out.println(Arrays.toString(twinNew.arr));
        System.out.println(Arrays.equals(human1.arr, twinNew.arr));


        // Deep Copy example
        Human deepHuman = (Human) human1.deepClone();
        System.out.println(human1.equals(deepHuman));
        System.out.println(Arrays.equals(human1.arr, deepHuman.arr));   // still true
        System.out.println(human1.name.equals(deepHuman.name)); // Still true
        human1.arr[3] = 100;
        System.out.println(Arrays.toString(human1.arr));
        System.out.println(Arrays.toString(deepHuman.arr));
        System.out.println(Arrays.equals(human1.arr, deepHuman.arr));   // Now false, because internally java knows that until elements are same lets point to same object in heap
        // But when any element of the gets changed, a total new memory will be pointed. So, it is safe.
    }
}
