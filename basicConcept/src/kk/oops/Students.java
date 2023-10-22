package kk.oops;

import java.util.Arrays;

public class Students {
    public static void main(String[] args) {
        Student[] stu1 = new Student[5];
        System.out.println(stu1);
        System.out.println(Arrays.toString(stu1));

        Student stu2;
//        System.out.println(stu2); // This line will give error because stu2 have not been initialized, just declared.
        stu2 = new Student();
        System.out.println(stu2.rollNo);
        System.out.println(stu2.name);
        System.out.println(stu2.marks);
        System.out.println(stu2.c + 0);
//        System.out.println(stu2.noexist);   // Cannot happen because java static typed language, unlike python
        // In above, this can be possible in Python, to inject an attribute to a specific object, limited to a scope of that object.


        /* Demo of this keyword */
        Student stu3 = new Student(3,"third");
        System.out.println("stu3.rollNo = " + stu3.rollNo + "stu3.name = " + stu3.name);

        Student stu4 = new Student();
        System.out.println("stu4.rollNo = " + stu4.rollNo + "stu4.name = " + stu4.name);

        // Two class reference variables can point to same class object.
        // Change in object can be seen by both reference variables, change can be done using any reference variables.
        Student stu5 = new Student();
        System.out.println("stu5 = " + stu5);
        Student stu6 = stu5;
        System.out.println("stu6 = " + stu6);
    }
}

class Student {
    int rollNo;
    String name;
    Float[] marks;
    char c;

    public Student() {
    }

    public Student(int rollNo, String naam) {
        this.rollNo = rollNo;
        name = naam;
    }
}