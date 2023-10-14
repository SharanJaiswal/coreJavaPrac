package kk.oops.objectOverride;

import java.util.Arrays;
import java.util.Comparator;

public class StudentComaprable implements Comparable<StudentComaprable> {
    int rollno;
    float marks;

    public StudentComaprable(int rollno, float marks) {
        this.rollno = rollno;
        this.marks = marks;
    }

    // This overridden abstract method from Comparable interface can be used on the go by objects, and can be internally used by Arrays.sort() method
    // Arrays.sort() method will use this as, -1 -> a<b ; 0 -> a==b ; 1 -> a>b [STRICTLY < > ==]
    // If this method is not overridden in the class whose objects are sorted in the Array, then sorting will throw an exception.
    // We can below ut complex comparison logic as a body of below method, but ultimately it should return either -1, 0, or 1
    @Override
    public int compareTo(StudentComaprable o) { // this method must return any among -1, 0, 1
        return this.rollno - o.rollno;  // THIS WILL SORT BY ROLLNO
//        return (int)(this.marks - o.marks);   // THIS WILL SORT BY MARKS
    }

    @Override
    public String toString() {
        return "rollno=" + rollno +
                ", marks=" + marks;
    }

    public static void main(String[] args) {
        StudentComaprable stu1 = new StudentComaprable(34, 57f);
        StudentComaprable stu2 = new StudentComaprable(67, 45f);
        StudentComaprable stu3 = new StudentComaprable(-3, 29f);
        StudentComaprable stu4 = new StudentComaprable(34, 99f);
        StudentComaprable stu5 = new StudentComaprable(734, -1f);

        StudentComaprable[] stuArr = new StudentComaprable[] {stu1, stu2, stu3, stu4, stu5};

        System.out.println(Arrays.toString(stuArr));

        Arrays.sort(stuArr);

        System.out.println(Arrays.toString(stuArr));

        ///////////////////////////////ANOTHER WAY TO PASS COMPARATOR AS PARAM TO SORT///////////////////////////////

        stu1 = new StudentComaprable(34, 57f);
        stu2 = new StudentComaprable(67, 45f);
        stu3 = new StudentComaprable(-3, 29f);
        stu4 = new StudentComaprable(34, 99f);
        stu5 = new StudentComaprable(734, -1f);
        stuArr = new StudentComaprable[] {stu1, stu2, stu3, stu4, stu5};
        System.out.println(Arrays.toString(stuArr));
        Arrays.sort(stuArr, new Comparator<StudentComaprable>() {
            @Override
            public int compare(StudentComaprable o1, StudentComaprable o2) {
//                return o1.rollno - o2.rollno;  // THIS WILL SORT BY ROLLNO
                return (int)(o1.marks - o2.marks);   // THIS WILL SORT BY MARKS
            }
        });
        System.out.println(Arrays.toString(stuArr));
    }

}
