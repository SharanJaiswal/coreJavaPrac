package kk.oops.finalclassandmethods;

public class StaticMethodInherit extends Container{

    // Cannot put this annotation because this class cannot override the static method greetings here, without specifying static in its method declaration.
    // But with the static here in the method declaration, we can use the method.
//    @Override //  cannot put this annotation in any case where we want to override a static method
//    void greetings() {    // Must put "static" keyword while trying to shadow the body of original static method body
    static void greetings() {
        System.out.println("Hi I am in StaticMethodInherit method. Greetings!!");
    }
    // Hence variables can be overridden as instance variable, but static methods cannot be overridden as instance variable.
    // Static methods needs "static" keyword while trying overriding it in child class, but actually, the overridden body is not shadowed. Instead, parent's body is picked.

    public static void main(String[] args) {
    /*
    We know that reference vars will decide what set of attrs and methods can be called, but the version of those methods and attrs are dependent upon the referenced child object
     */
        Container cont1 = new StaticMethodInherit();
        cont1.greetings();  // On contrary, here static method in child class with same name without override annotation, is calling the body of parent static method with same name
        Container.greetings();

        // Until specifically asked, static method of child class is not called
        StaticMethodInherit staticMethodInheritObject = new StaticMethodInherit();
        staticMethodInheritObject.greetings();
        StaticMethodInherit.greetings();
        // Hence,it is one of the reason to access static members using the class name as a reference.

        Container cont2 = new Container();
        cont2.greetings();

    /* For CASE - 1:
    STATIC ENTITIES REFERENCED DOES NOT DEPEND ON THE TYPE OBJECT OF PARENTS OR EXTENDED CHILD[REN] ( ie RHS). IT DEPENDS ON THE REFERENCE CLASS|OBJECT USING WHICH IT IS CALLED. [NOT RHS, BUT LHS]
    Its like the method is although inherited, but not overridden at all in child. Not even the method with the same name in the child object scope gets picked. Parent body is not shadowed.
    It is, by convention and by rule, can be referred with the class name. So, even if we inherit the method, ie, provide method signature same as parent,
    and change the body of it, it will still run the parent's version of it, if we are accessing it using object of any (parent/child) type but referenced by variable of parent type.
    So, custom inheriting the parent static method is of no use, neither it'll give error, nor get picked, if it is accessed from object which is being referenced by var of parent type.
    We can delete the custom body inherited static method in child class, and we'll still be able to call implicitly inherited static method through object/class of parent.
    */

        StaticMethodInherit obj2 = new StaticMethodInherit();
        obj2.greetings();
        StaticMethodInherit.greetings();
    /*
    For CASE - 2:
    To call the custom body inherited static method, we need to call it explicitly using child class object referenced by variable of child class type, or by child class itself.

    NOTE:   But if in case, custom body is not provided, ie, if method with same signature is not defined into the inherited class, then, parent's body will gets executed.
            Try testing it by commenting the greeting method. It will pick the inherited parent's greetings method.
     */
    }
}