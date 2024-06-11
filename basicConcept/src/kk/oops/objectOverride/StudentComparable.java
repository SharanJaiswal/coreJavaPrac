package kk.oops.objectOverride;

import java.util.Arrays;
import java.util.Comparator;

public class StudentComparable implements Comparable<StudentComparable> {
    int rollno;
    float marks;

    public StudentComparable(int rollno, float marks) {
        this.rollno = rollno;
        this.marks = marks;
    }

    // This overridden abstract method from Comparable interface can be used on the go by objects, and can be internally used by Arrays.sort() method
    // Arrays.sort() method will use this as, -VE -> a<b ; 0 -> a==b ; +VE -> a>b [STRICTLY < > ==]
    // If this method is not overridden in the class where objects are being sorted in the Array of those objects using Arrays.sort() method, then sorting will throw an exception.
    // We can put below complex comparison logic as a body of below method, but ultimately it should return either -ve, 0, or +ve
    @Override
    public int compareTo(StudentComparable o) { // this method must return any among -ve, 0, +ve integer
        // THIS WILL SORT BY ROLLNO
//        return Integer.compare(this.rollno - o.rollno, 0);    // below is also correct
        return Integer.compare(this.rollno, o.rollno);
//        return (int)(this.marks - o.marks);   // THIS WILL SORT BY MARKS AS WE ARE NOT RETURNING -ve, OR 0 OR +ve integer
    }

    @Override
    public String toString() {
        return "rollno=" + rollno +
                ", marks=" + marks;
    }

    public static void main(String[] args) {
        StudentComparable stu1 = new StudentComparable(34, 57f);
        StudentComparable stu2 = new StudentComparable(67, 45f);
        StudentComparable stu3 = new StudentComparable(-3, 29f);
        StudentComparable stu4 = new StudentComparable(34, 99f);
        StudentComparable stu5 = new StudentComparable(734, -1f);

        StudentComparable[] stuArr = new StudentComparable[] {stu1, stu2, stu3, stu4, stu5};

        System.out.println(Arrays.toString(stuArr));

        Arrays.sort(stuArr);    // picks compareTo() by default

        System.out.println(Arrays.toString(stuArr));

        ///////////////////////////////ANOTHER WAY TO PASS COMPARATOR AS PARAM TO SORT///////////////////////////////

        stu1 = new StudentComparable(34, 57f);
        stu2 = new StudentComparable(67, 45f);
        stu3 = new StudentComparable(-3, 29f);
        stu4 = new StudentComparable(34, 99f);
        stu5 = new StudentComparable(734, -1f);
        stuArr = new StudentComparable[] {stu1, stu2, stu3, stu4, stu5};
        System.out.println(Arrays.toString(stuArr));
        Arrays.sort(stuArr, new Comparator<StudentComparable>() {
            @Override
            public int compare(StudentComparable o1, StudentComparable o2) {
//                return o1.rollno - o2.rollno;  // THIS WILL SORT BY ROLLNO
                return (int)(o1.marks - o2.marks);   // THIS WILL SORT BY MARKS
            }
        });
        System.out.println(Arrays.toString(stuArr));


        ///////////////////////////////ANOTHER WAY TO PASS COMPARATOR AS PARAM TO SORT///////////////////////////////

        stu1 = new StudentComparable(34, 57f);
        stu2 = new StudentComparable(67, 45f);
        stu3 = new StudentComparable(-3, 29f);
        stu4 = new StudentComparable(34, 99f);
        stu5 = new StudentComparable(734, -1f);
        stuArr = new StudentComparable[] {stu1, stu2, stu3, stu4, stu5};
        System.out.println(Arrays.toString(stuArr));
//        Arrays.sort(stuArr, (StudentComparable o1, StudentComparable o2) -> o1.rollno - o2.rollno); // pass comparator's compare lambda directly.
        Arrays.sort(stuArr, (o1, o2) -> o1.rollno - o2.rollno); //  by not specifying the type definitions, the compiler is capable of inferring these on its own.
        System.out.println(Arrays.toString(stuArr));


// We can pass the method reference also.
//        public static int compareByNameThenAge(Human lhs, Human rhs) {
//            if (lhs.name.equals(rhs.name)) {
//                return Integer.compare(lhs.age, rhs.age);
//            } else {
//                return lhs.name.compareTo(rhs.name);
//            }
//        }
//        humans.sort(Human::compareByNameThenAge);


//        ANOTHER way: We can also avoid defining even the comparison logic itself by using an instance method reference and the Comparator.comparing method,
//        which extracts and creates a Comparator based on that function.
//        Collections.sort(humans, Comparator.comparing(Human::getName));


//        ANOTHER BUT FOR REVERSE SORT:
//        Comparator<Human> comparator = (h1, h2) -> h1.getName().compareTo(h2.getName());
//        humans.sort(comparator.reversed());


//        For complex sorting with multiple conditions. Here, if names will be different then go for age comparison, else, name comparison.
//        humans.sort(Comparator.comparing(Human::getName).thenComparing(Human::getAge));

    }
}