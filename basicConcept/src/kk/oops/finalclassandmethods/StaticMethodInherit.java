package kk.oops.finalclassandmethods;

public class StaticMethodInherit extends Container {

    // Below is correct, and can be used. Just checking if we can assign value.
//    static String staticVar = "Overridden static variable value";

    /**
     * If we want to override any variable's value which has type "final" as a keyword in it, then we have to redeclare it in child class.
     * That redeclaration may or may not have "final" as a keyword. So, same name variable which was of final [static] type, can be overridden,
     * Also, same goes with variables that have "static" in their type. Parent's static variable of any type can be shadowed in child class variable of type static or non-static, but with same name and if referenced via child object or class type.
     */

//    final String finalVar = "StaticMethodInherit Final Variable";
    // Above final variable requires initialization, which can be achieved at place where it is declared, or inside constructor.
    // If it is initialized inside constructor, then we may skip assigning the value to this final reference variable at place where it is declared.
    final static String finalStaticVar = "StaticMethodInherit Final Static Variable";

    String anotherStaticVar;    // unlike static methods of parent class, static variables of parent class can be redeclared and redefined, even without static keyword; instance variable of child can shadow static variables of parent.
    // Of course, when we won't use "static" keyword, that overriding instance variable won't be referred via child class name directly, but by child class' object only.
    // On the other hand, static method of parent, needs "static" keyword in their signature in child class, when they are being overridden in child class.

    public StaticMethodInherit(int size, String material) {
        super(size, material);
        this.size = 100;
        this.staticVar = "Overridden static variable value";
//        this.finalVar = "StaticMethodInherit Final Variable";
//        this.finalStaticVar = "StaticMethodInherit Final Static Variable";
    }

    // Cannot put this @Override annotation because this class cannot override the static method greetings here, without specifying static in its method declaration. Without "static" keyword, this will be instance method,
    // which doesn't shadow body of static parent method. We specifically need "static" keyword if we want to override it, without @override keyword, referenced by child-object-type(not preferred) or class type.
    // But with the static here in the method declaration, we can use the method.
//    @Override //  cannot put this annotation in any case where we want to override a static method, because this annotation is related with instances, and static methods are not related instances.
//    void greetings() {    // We cannot simply define instance method which has same method signature as static method in parent. It must put "static" keyword while trying to shadow the body of original static method body.
    static void greetings() {
        System.out.println("Hi I am in StaticMethodInherit method. Greetings!!");
    }
    // Hence variables can be overridden as instance variable, but static methods cannot be overridden as instance method because it leads to ambiguity.
    // Static methods needs "static" keyword while trying overriding it in child class, but actually, the overridden body is not shadowed. Instead, parent's body is picked.

    static void childOnlyStaticMethod() {
        System.out.println("In child only static method");
    }

    // If below method was not overridden, then parents body would have been picked
    @Override
    void getSizeAndMaterial() {
        System.out.println("In Child : " + this.size + " " + this.material);
    }

    public static void main(String[] args) {
    /*
    We know that reference vars will decide what set of attrs and methods can be called, but the version of those methods and attrs are dependent upon the referenced child object
     */
        Container cont1 = new StaticMethodInherit(23, "PVC");
        cont1.greetings();  // On contrary, here static method in child class with same name without override annotation, is calling the body of parent static method with same name
        Container.greetings();

        // Until specifically asked, static method of child class is not called
        StaticMethodInherit staticMethodInheritObject = new StaticMethodInherit(23, "PVC");
        staticMethodInheritObject.greetings();
        StaticMethodInherit.greetings();
        // Hence,it is one of the reason to access static members using the class name as a reference.
/**
 * We can conclude that although ref var decides the set of candidates to be accessed, and object decides the version of those candidates;
 * but using reference variable if we are calling any static member, the static member of that reference variable class gets called.
 * Its giving preference to static member of reference variables over static member of child or instance variables of child class.
 * If static method in child class of same signature as parents but with different body is called via reference variable of child type (class or obj), then child body will get picked via preference, shadowing parent's static method body.
 * But if there is not **overriding** of the body of static method of parent class in child class, then reference object of child class when calls static method of same name parent's static method body gets picked.
 * See it by toggling as comment the override static method greeting at start of this class
 */
        cont1.getCostPrice();
        //Below 3 can be called using classname Container also, preferred way to access static members.
        cont1.anotherStaticMethod();
        System.out.println(cont1.staticVar);
        System.out.println(cont1.finalStaticVar);
        System.out.println(cont1.finalVar);
        cont1.getSizeAndMaterial();
        System.out.println(Container.staticVar);
        System.out.println(Container.finalStaticVar);


        staticMethodInheritObject.getCostPrice();
        staticMethodInheritObject.greetings();
        //Below 3 can be called using classname StaticMethodInherit also, preferred way to access static members.
        // All variables of any type, including variables of type final, static, final static, normal, etc. except private, are inherited.
        // Since they are already part of child class on extending/implementing, we have an option to change their value with or without even declaring again in child class, based on type of variable,
        // ie, if it final or final static, then to change its value, we need to redeclare it before shadowing its parent value in child class. Else, rest can be shadowed without redeclaration.
        // except any variable that has type final. We can only override the final variable value by declaring again in child class.
        // If they are all redeclared in child class with same signature,
        // all type of variables can be overridden including variables of type final, static, final static, normal, etc.
        staticMethodInheritObject.anotherStaticMethod();
        System.out.println(staticMethodInheritObject.staticVar);
        System.out.println(staticMethodInheritObject.finalStaticVar);
        System.out.println(staticMethodInheritObject.finalVar);
        staticMethodInheritObject.getSizeAndMaterial();
        StaticMethodInherit.greetings();
        StaticMethodInherit.anotherStaticMethod();
        System.out.println(StaticMethodInherit.staticVar);
        System.out.println(StaticMethodInherit.finalStaticVar);


        Container cont2 = new Container();
        cont2.greetings();

    /* For CASE - 1:
    STATIC ENTITIES REFERENCED DOES NOT DEPEND ON THE TYPE OBJECT OF PARENTS OR EXTENDED CHILD[REN] ( ie RHS). IT DEPENDS ON THE REFERENCE CLASS|OBJECT USING WHICH IT IS CALLED. [NOT RHS, BUT LHS]
    Static methods are inherited, and if called even using child class reference variable or by child class itself, parent body will be executed. But if we shadow the body of static method, which doesn't take @Override annotation
     while overriding its body and must take "static" keyword in its signature in child class, and if we call this shadowing static method from child class or child class reference, then shadowing body will get executed.
    It is, by convention and by rule, can be referred with the class name. So, even if we inherit the method, ie, provide method signature same as parent,
    and change the body of it, it will still run the parent's version of it, if we are accessing it using object of any (parent/child) type but referenced by variable or class of parent type.
    So, custom inheriting the parent static method is accessed from object which is being referenced by var of parent type, independent of fact of the type of object(parent/child) to which it is referencing.
    */

        StaticMethodInherit obj2 = new StaticMethodInherit(23, "PVC");
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