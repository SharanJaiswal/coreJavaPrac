package kk.oops.finalclassandmethods;

/**
 * LOCAL VARIABLES ARE IN STACK. INSTANCE VARIABLES ARE IN HEAP. LAMBDAS WORK IN HEAP PRIMARILY.
 */

/* outermost class cannot be static */
//static class A {
//
//}

class OuterTest {
    static String name;
    String naam;

    public OuterTest(String name) {
        OuterTest.name = name;  // good when we want to update this static variable value in all previously created object. But if that's not the case, then initialize it in static block.
        this.naam = name;
    }
}

/*
Outermost class cannot be static, while the inner class can and cannot be static, because to access the static entity,
it must be dependent on any class. If outermost class is allowed to be static, then it means outermost class is dependent
on any other enclosing class, which is not possible. Outermost class is ultimately independent, while subsequent inner class are
wrapped around by their outer class, ie, inner class are dependent on outer classes.
 */
public class OuterClass {
    static class StaticTest {
        String name;
        static String naam;

        public StaticTest(String name) {
            this.name = name;
            StaticTest.naam = name;
        }
    }
// Static class is in the scope of the OuterClass, ie, static class can be accessed by using outerclass or its objects(non-preferred way) as reference,
// while non-static class is in the scope of all the objects of OuterClass, ie, it will only be accessed by the objects of outer class & not by outer class itself.
    class NonStaticTest {
        String name;

        public NonStaticTest(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        /*
        Below works because this inner class whose object is created is of static class, and static candidate does not
        need any object of their enclosing class to access them
         */
        StaticTest statObj1 = new OuterClass.StaticTest("Sharan");  // Preferred way of accessing the static candidate is OutermostClass.2ndLevelClass. ... .StaticTest
        StaticTest statObj2 = new StaticTest("Jaiswal");
        System.out.println("Non Static attr : " + statObj1.name + ". ====> Static Value : " + OuterClass.StaticTest.naam);
        // Above is the preferred way of accessing the static candidate is using [Outerclassname.]Innerstaticclassname.staticcandidate
        System.out.println("Non Static attr : " + statObj2.name + ". ====> Static Value : " + statObj2.naam);
        // It is an example where static content if once changed, is changed for all of its occurrences in all the objects.
        /*
        We can observe that although inner class being the static, have 2 different objects. It can be possible because
        class template is static, not the instances of the class. It is hence preferred to use "OuterClass.InnerStaticClass"
        whenever we are referencing the "InnerStaticClass" anywhere. Otherwise, it's not an error, but a preferred way.
         */

        /**
         * Here, since we are in class named OuterClass, therefore while creating the object of StaticTest class we are not using OuterClass.StaticTest in RHS as well as LHS.
         * Although we can use it as OuterClass.StaticTest.....
         * But, if we have to access StaticTest from outside OuterClass, then we must use format OuterClass.StaticTest.....
         */

        /*
        Below cannot be created because we are accessing NonStatic class which is dependent on Static class, ie,
        we'll be needing an object of outer class to access this inner non-static class
        */

//        NonStaticTest nonStatObj1 = new NonStaticTest("Sharan");
//        NonStaticTest nonStatObj2 = new NonStaticTest("Jaiswal");
        OuterClass outerClassObj1 = new OuterClass();
        NonStaticTest nonStaticTest1 = outerClassObj1.new NonStaticTest("Inside non-static classobject 1");
        OuterClass.NonStaticTest nonStaticTest2 = outerClassObj1.new NonStaticTest("Inside non-static class object 2");
        /*
        checkout links in the README.md file
         */


        // Third type of class is LOCAL CLASS, which is defined inside a block, and is scoped inside a block.
        // Here, below class is defined inside "main" method block.

        int i = 10; // Variables global to local classes can be accessed for READ-WRITE from inside the local class.
        // As long as the variables global to local class are not changing its value outside of local class block, READ-WRITE operation can be used on them.
        // Otherwise, if this variable is changed somewhere "in the enclosing scope where class FOO is defined, ie, here in this main method", then READ-WRITE will throw an error inside class Foo.
        // It is because, in cases where we change the value of "i" (assuming it is referencing an object) inside the object of inner class, then 2 things will be observed:
        // 1. when update happens of value of "i" in inner class, it might not be sequential(happens before or after) of the update happens outside of this inner class, which could be updated again against our will in enclosing scope. Thus, not retaining the updated value of "i" from inner class.
        // 2. If "i" holds primitive value, whatever happens in the object of inner class stays in the object of inner class, and might not reflect in the outer class.
        // To access those variables, either those variables must be final or effectively final.
        final int j = 20;
        class Foo {
            int x = i;  // If "i" gets updated in outer|inner scope, then due to asynchronous nature, it'll create problem for "i" itself in inner|outer scope.
            // Java compiler makes a copy of "i" form outside of this class and passes that copy to this class for its use. Now, in case where we make the object of Foo,
            // and then passes that object to some method, then this will move the scope of var "i". In that new additional scope, we can change the value of "i". Since, this was the
            // copy of "i", that will make original "i" outdated|out-of-sync. So, java devs decided to use only final or effectively final variables inside class, in scope enclosing
            // that class.
            int y = j;
            public void tellMyName() {
//                i++;  // Updating this asynchronously will make "i" in enclosing scope out-of-sync.
            }
        }
//        i=40; // This line will create compilation error inside class Foo. Because, anything that has been captured from local scope to inside the block which can be accessed independently w/o depending on the enclosing local scope, that should not be changed from inside or outside of block to avoid synchronization issues. In cases where mutation does not give error, but avoid these practices because in parallel processing mutation will give error.
//        j=30;   // we cannot change the value of this final variable.

        Foo f = new Foo();
        f.x=1;
        System.out.println(f.x);
        System.out.println(i);    // Even this potentially could change the value of "i" (absurd, but in cases where "i" hold non-primitive data reference), hence it is giving error in inner class.

        // Fourth type is Anonymous Classes, where existing class object is made at a place where the class is override.
        Foo f2 = new Foo() {
            // We can override existing methods of this existing class.
            public void tellMyName() {
                System.out.println("Sharan Jaiswal. From the Anonymous class");
            }
        };
        f2.tellMyName();
    }

    /**
     * https://www.baeldung.com/java-lambda-effectively-final-local-variables
     * https://www.youtube.com/watch?v=k7ryJslpmdM&ab_channel=CodeEdx
     */
}
