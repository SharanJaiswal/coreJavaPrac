package kk.lambdas;


import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Student stu1 = new Student(34, 57f);
        Student stu2 = new Student(67, 45f);
        Student stu3 = new Student(-3, 29f);
        Student stu4 = new Student(34, 99f);
        Student stu5 = new Student(734, -1f);

        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(stu1);
        arrayList.add(stu2);
        arrayList.add(stu3);
        arrayList.add(stu4);
        arrayList.add(stu5);

        arrayList.forEach( item -> item.print());

        // METHOD REFERENCE: It is passed to forEach() functions, where they expect the FI Consumer taking one argument. So instead of passing the lambda,
        // we pass the function reference which in turn does not invoke the function, but passes it reference to be invoked later in the processing.
        arrayList.forEach(Student::print);  // The method passed as a reference does not necessarily to be a static method. It could be any type of method having body|implementation
        // By this way, we can also pass the constructor reference wherever required, eg, collectionItem.stream().map(UserDefinedClass::new).collect(Collector.toList()), where constructor takes one param and makes its makes object

//        double averagePrice = arrayList.stream().collect(Collectors.averagingInt(Product::getPrice));     // summingInt

        // If hover over ArrayList.forEach(), we see that it takes only one parameter as action of type Consumer.
        // Consumer takes only one input, ie, inside <> classname of obj present in () in lambda expr [LHS]
        // Also, Consumer is just an interface, which can take upto 1 generic classname type, hence, LHS of lambda which is no. of args of function, is also 1 in number.
        // Consumer returns nothing, its accept abstract method
        Consumer<Student> func = (item) -> item.print();
        /*
        lambdas expressions can be assigned to variables of type interfaces
         */
        Operation printDetail = (a, b) -> System.out.println("Rollno=" + a +", Marks=" + b);    // JVM resolves it at runtime which body to pick of type Operations, ie, RHS ( after = )
//         Operation<Integer, Float> printDetail = (a, b) -> System.out.println("rollno=" + a +", marks=" + b); // We can also restrict the type of param passed to lambda expression. Mentioning type after -> for 'a' & 'b' is not required.

        // We can define any lambda expression body and assign to this interface, but here it is restricted to take exactly 2 parameters, body return type is void.
        // and if parameter class is also mentioned in interface blueprint, then those parameters should also take care of matching corresponding param and their order.
        Operation anyRandomName = (a, b) -> {
            System.out.println("marks=" + b + " rollno=" + a);
            System.out.println("Sharan");
//            System.out.println(a*b);  // This line will only work if we have provided generics types of 'a', and 'b' in the <> operator which supports '*' operator
        };

        // Now we can pass this lambda variable to any function which needs action
        Main mainObj1 = new Main();
        mainObj1.lambdaUser1(stu1.rollno, stu1.marks, printDetail);
        mainObj1.lambdaUser1(stu1.rollno, stu1.marks, anyRandomName);

        // If this lambdaUser1 had been defined in Student class, then we had just passed the action to lambdaUser1|2, because we could have implemented lambdaUser1|2 as below:
        // action.operation(this.rollno, this.marks);   // and called stuObject.lambdaUser1|2(actionVariable);
    }

    private void lambdaUser1 (int a, float b, Operation action) {
        action.operation(a, b);
    }
}

// Functional Interface needs ONLY 1 abstract method of any name. We must concern with the count and type of params to that abstract methods, and abstract method return type.
// The return type of this abstract method major role when we assign lambda expression to variable of this interface type
// where RHS of lambda body return type is same as this abstract method return type.
// implementation to this abstract method can be provided using lambda expression only if interface is Functional Interface.
// Below commented can also be possible if we are not sure about input types of 2 params
interface Operation<P,Q> {   // interface Operation {
    void operation (P a, Q b);     // void operation (int a, float b);
}

/**
 * https://www.baeldung.com/java-lambda-effectively-final-local-variables
 */
