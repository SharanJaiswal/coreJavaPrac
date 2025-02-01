package kk.oops.inheritance;

public class Main {
    public static void main(String[] args) {
        Box box = new Box();
        System.out.println(box.l + " " + box.w + " " + box.h);

        // Inheritance
        BoxWeight box1 = new BoxWeight();
        System.out.println(box1.h + " " + box1.l + " " + box1.weight);


        // Parent type referencing the child type
        Box box2 = new BoxWeight(1,2,3,4);
        System.out.println(box2.l + " " + box2.w + " " + box2.h);
//        System.out.println(box2.weight);    // Cannot be referenced because it is the type of reference variable ( not the type of object )
                                            // which determines what members can be accessed. Those member should have to be the part of reference var type
        // SubClass type reference variable cannot refer Super class. There are many extra member variables inside subClass.
        // If child class start referencing the parent class, then it would expect those extra variables, which are part of subclass, from parent class.
        // This cannot happen because Object is created of type parent, and only those member variables are initialized which are part of parent. NOT child.
        // So, members which are not initialized, cannot be referenced. Also, because child constructor is not called, parent constructor is called.
//        BoxWeight box3 = new Box(4,6,8);

        // because of above valid logic, we can pass the object of type child to the constructor of type Parent, which is expecting argument of type Parent
        // There is one construction like such, in the child class.


        /* ========================= */
        System.out.println((new Box()) instanceof Box);
        System.out.println(new Box() instanceof Object);
        System.out.println(new Box() instanceof BoxWeight);
        System.out.println(new BoxWeight() instanceof Box);
    }
}