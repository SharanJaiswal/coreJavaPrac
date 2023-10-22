package kk.lambdas;

import java.util.Arrays;
import java.util.Comparator;

public class Student implements Comparable<Student> {
    int rollno;
    float marks;

    public Student(int rollno, float marks) {
        this.rollno = rollno;
        this.marks = marks;
    }

    @Override
    public int compareTo(Student o) { // this method must return any among -1, 0, 1
        return this.rollno - o.rollno;  // THIS WILL SORT BY ROLLNO
//        return (int)(this.marks - o.marks);   // THIS WILL SORT BY MARKS
    }

    @Override
    public String toString() {
        return "rollno=" + rollno +
                ", marks=" + marks;
    }

    public static void main(String[] args) {
        Student stu1 = new Student(34, 57f);
        Student stu2 = new Student(67, 45f);
        Student stu3 = new Student(-3, 29f);
        Student stu4 = new Student(34, 99f);
        Student stu5 = new Student(734, -1f);

        Student[] stuArr = new Student[] {stu1, stu2, stu3, stu4, stu5};

        System.out.println(Arrays.toString(stuArr));
//        Arrays.sort(stuArr, (o1, o2) -> {
////                return o1.rollno - o2.rollno;  // THIS WILL SORT BY ROLLNO
//            return (int)(o1.marks - o2.marks);   // THIS WILL SORT BY MARKS
//        });
        Arrays.sort(stuArr, (o1, o2) -> { return (int)(o1.marks - o2.marks); });
        Arrays.sort(stuArr, (o1, o2) -> (int)(o1.marks - o2.marks));

        System.out.println(Arrays.toString(stuArr));

        /*
        Lambdas are required when we pass the function to some methods. It's a shorthand way to achieve the same task of passing function.
        If we expect something in return from passed functions and if there is just one return statement in function body ,then we write the return expression w/o "return" keyword.
        As anything right of "->" will be in 2 formats. Either inside {}, or just a single statement. If inside {}, then everything inside it will be written as normal body code.
        While, if there is no {}, then there will be just an expression giving an output. This output can be of any type, including void, but should match the type original func ret type.
        We box multiple statement in the braces, as function body, also use "return" keyword when we use multiple/single line inside {}.
        So, multiple lines in body of function are in braces, with "return" keyword if original function needs anything in return, each statement followed by semicolon.
        Else, single return expression w/o "return" keyword and semicolon if no braces is used; or any single statement like sout(...)
        Pass params to lambda are if original function can take arguments, placed in parentheses, followed by arrow operator followed by body/return expression value.
         */
    }

    // For Main class in same package
    public void print() {
        System.out.println("rollno=" + rollno + ", marks=" + marks);
    }
}
