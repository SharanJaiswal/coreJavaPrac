package kk.oops.inheritance;

public class BoxWeight extends Box {
    double weight;
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

    public BoxWeight(BoxWeight other) {
        super(other);   // This will not give error because the expression will be like: Parent parentObj = new Child();
        this.weight = other.weight;
    }
}
