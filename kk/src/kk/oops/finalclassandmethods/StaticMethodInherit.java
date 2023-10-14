package kk.oops.finalclassandmethods;

public class StaticMethodInherit extends Container{

    // Cannot put this annotation because this class cannot override the static method greetings here, without specifying static in its method declaration.
    // But with the static here in the method declaration, we can use the method.
//    @Override
//    static void greetings() {
//        System.out.println("Hi I am in StaticMethodInherit method. Greetings!!");
//    }

    public static void main(String[] args) {
    /*
    We know that reference vars will decide what set of attrs and methods can be called, but the version of those methods and attrs are dependent upon the referenced child object
     */
        Container cont1 = new StaticMethodInherit();
        cont1.greetings();  // On contrary, here static method in child class with same name without override annotation, is calling the body of parent static method with same name
        Container.greetings();
        Container cont2 = new Container();
        cont2.greetings();
    /* For CASE - 1:
    STATIC ENTITIES REFERENCED DOES NOT DEPEND ON THE TYPE OBJECT, PARENTS OR EXTENDED CHILD[REN]. IT DEPENDS ON THE REFERENCE CLASS|OBJECT USING WHICH IT IS CALLED. [NOT RHS, BUT LHS]
    Its like the method is although inherited, but not overridden at all in child. Not even the method with the same name in the child object scope gets picked.
    It is because, a static method from parent, is implicitly inherited and is not dependent on the object, neither of parent or child; will always run the parent's version.
    It is, by convention and by rule, can be referred with the Parent class name. So, even if we inherit the method, ie, provide method signature same as parent,
    and change the body of it, it will still run the parent's version of it. So, custom inheriting the parent static method is of no use, neither it'll give error, nor get picked.
    We can delete the custom body inherited static method in child class, and we'll still be able to call implicitly inherited static method through object/class of parent.
    */

        StaticMethodInherit obj2 = new StaticMethodInherit();
        obj2.greetings();
        StaticMethodInherit.greetings();
    /*
    For CASE - 2:
    To call the custom body inherited static method, we need to call it explicitly using child class object, or by child class itself.
    But if in case, custom body is not provided to the inherited class, then, parent's body will gets executed.
     */
    }
}