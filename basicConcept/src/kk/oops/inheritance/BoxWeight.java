package kk.oops.inheritance;

public class BoxWeight extends Box {
    double weight;
    int commonName; // This reference variable name is same as reference variable name in the super class.
    // So, if we'll just use "commonName" variable anywhere in this class, then this class's "commonName" reference variable will be used.
    // We can also call this class "commonName" in this class's objects as "this.commonName" (preferred way)
    // Although, we have shadowed the "commonName" from super class if we use variable by not prepending anything before it. But, "commonName"
    // from super class is also inherited. To use|access super class "commonName" variable for get and set, use "super.commonName"
    // Similar behavior is observed with the method overriding, when parent method also has body, which is getting overriden in child class.
    // For both of the above case, access modifier of shadowing members in the child class will be either same or less restrictive.
    /*
    If no constructor of parent is called, then by default super() is called, hence Parent() must be defined in parent class.
    In any case of child's constructor, first line of it should call any defined parent's constructor; and parent class must have defined that constructor,
    even if the body of parents constructor is empty.
    If any constructor is defined in any class, then objects of that class are created using those constructors only.
    eg, if Constructor(arg1, arg2) is defined in any class, then we cannot call Constructor() ie, any other constructor of different signature.
     */
    public BoxWeight() {
        this.weight = -1;
    }

    public BoxWeight(double length, double width, double height, double weight) {
        super(length, weight, height);  // used to initialize values in parent class
        this.weight = weight;
    }

//    Although method signature consist of method's name, type and order of params but still if return type is changed while overriding parent method, then this will throw an error while overriding.
//    @Override
//    public int information() {
//        super.information();
//        return 0;
//    }

}
