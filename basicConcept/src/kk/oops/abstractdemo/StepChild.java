package kk.oops.abstractdemo;
// Example of inheritance where parent is abstract and child didn't override all abstract methods of parent
public abstract class StepChild extends Parent {
    int random; // Since this is still an abstract class, hence this class cannot have objects, unless methods are override while creating the objects.
                // Therefore, variables & methods are not bound to be final static. They can be final, static, final static, or without any of them.
    public StepChild(int age, int value) {
        super(age, value);
    }

    @Override
    void career(String job) {

    }
}
