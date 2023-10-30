package kk.oops.objectOverride;

// Except constructor and destructor, every overridden method of object returns a value.
public class ObjectDemo implements Comparable<ObjectDemo>{  // Inside <> there can be any class, provided there is some logic which uses that class' member in compareTo()
    int num;
    public ObjectDemo(int num) {
        super();
        this.num = num;
    }

    // random integer number representation of an object, not a memory address of object, formed using internal algo.
    // When 2 objects are compared, their hashCodes are [NOT] compared. eg., obj1 == obj2; Supports also != operator. These == & != uses memory location comparison, not their hashes.
    // obj1>obj2 (NO HASHCODE or Memory Location can be used to compare objects involving < or > operator. REQUIRES compareTo) are NOT implementing hashCode() to compare.
    // When 2 objects are compared, their Comparable interface's compareTo() method must be implemented and being called.
    @Override
    public int hashCode() {
//        return super.hashCode();  // Gives different value all the time for different object. Param value of hexString which make prints as default when passed to println
        return num; // this time if all the objects
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);   // By default, it does call (hashCode of obj1) == (hashCode of obj2), and not compares the memory location of objects, ie, internally calls == on has values.
        // Hence, String objects having same value expects true while calling this, due to String Pool concept in java.
        // While "==" compares the memory location.
        // equals internally calls toString values of the operands and compares the actual string value character by character to return the boolean value.
        // While '==' compares the memory location in case of objects, and values in case of primitives.
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public int compareTo(ObjectDemo o) {
        if ((this.num - o.num) == 0) { return 0; }
        else if ((this.num - o.num) < 0) { return -1; }
        return 1;
    }

    public static void main(String[] args) {
        ObjectDemo obj1 = new ObjectDemo(10);
        ObjectDemo obj2 = new ObjectDemo(20);
        ObjectDemo obj3 = new ObjectDemo(20);

        System.out.println(obj1);
        System.out.println(obj2);

        System.out.println(obj1 == obj2);
//        System.out.println(obj1 > obj2);  // Not supported if we are not implementing Comparable interface compareTo method

        // Ideal way to compare two objects of same or different type.
        System.out.println(obj1.compareTo(obj2));
        System.out.println(obj2.compareTo(obj1));
        System.out.println(obj2.compareTo(obj3));
    }
}
