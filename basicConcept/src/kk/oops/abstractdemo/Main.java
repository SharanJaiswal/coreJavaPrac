package kk.oops.abstractdemo;

public class Main {
    public static void main(String[] args) {
        Son son1 = new Son(34);
        son1.career("Doctor");
        son1.partner("xx", 23);

        Daughter daughter1 = new Daughter(43);
        daughter1.career("Engineer");
        daughter1.partner("xy", 23);

        /*
        this will give error because it'll ask to implement the abstract methods while creating the object
        Because object needs method with body, they need some functionality when the method will be called using object reference.
        This can be useful when we want different functionality with different object created. But better approach would be to
        extend the abstract parent class to new classes, each having different method body, aligning the former requirement.
         */
//        Parent parent1 = new Parent(40, 69);
        Parent parent2 = new Parent(40, 69) {
            @Override
            void career(String job) {
                System.out.println("Parent Career");
            }

            @Override
            void partner(String name, int age) {
                System.out.println("Parent Partner");
            }
        };  // this end will need semicolon.   Observe, that static methods are not overridden in any case. They are just inherited.
        parent2.greeting(); // Preferred way is Parent.greeting();
        daughter1.greeting();   // Preferred way is Parent.greeting();
        Daughter.greeting();

        son1.normal();
        daughter1.normal();

        Parent parent3 = new Daughter(9);
        parent3.normal();   // Best example showing runtime polymorphism. parent3 can use only elements that are inherited into child,
                            // but the values and body of those elements will be picked which is defined in child class.

//        StepChild step = new StepChild(1, 2);   // Since StepChild is abstract, hence its object cannot be instantiated.
        StepChild step = new StepChild(1, 2) {
            @Override
            void partner(String name, int age) {

            }
        };

    }
}
