package kk.oops;


/* outermost class cannot be static */
//static class A {
//
//}

class OuterTest {
    static String name;
    String naam;

    public OuterTest(String name) {
        OuterTest.name = name;
        this.naam = name;
    }
}

/*
Outermost class cannot be static, while the inner class can and cannot be static, because to access the static entity,
it must be dependent on any class. If outermost class is allowed to be static, then it means outermost class is dependent
on any other class, which is not possible. Outermost class is ultimately independent, while subsequent inner class are
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
        Below works because this inner class whose object is created is static class, and static candidate does not
        need any object of their enclosing class to access them
         */
        StaticTest statObj1 = new OuterClass.StaticTest("Sharan");  // Preferred way of accessing the static candidate
        StaticTest statObj2 = new StaticTest("Jaiswal");
        System.out.println("Non Static attr : " + statObj1.name + ". ====> Static Value : " + OuterClass.StaticTest.naam);
        // Above is the preferred way of accessing the static candidate is using [Outerclassname.]Innerstaticclassname.staticcandidate
        System.out.println("Non Static attr : " + statObj2.name + ". ====> Static Value : " + statObj2.naam);
        // It is an example where static content if once changed, is changed for all of its occurrences in all the objects.
        /*
        We can observe that although inner class being the static, have 2 different objects. It can be possible because
        class template is static, not the instances of the class. It is hence preferred to used "outerClass.InnerStaticClass"
        whenever we are referencing the "InnerStaticClass" anywhere. Otherwise, it's not an error, but a preferred way.
         */


        /*
        Below cannot be created because we are accessing NonStatic class which is dependent on Static class, ie,
        we'll be needing an object of outer class to access this inner non-static class
        */
//        NonStaticTest nonStatObj1 = new NonStaticTest("Sharan");
//        NonStaticTest nonStatObj2 = new NonStaticTest("Jaiswal");

        /*
        checkout links in the README.md file
         */
    }
}
