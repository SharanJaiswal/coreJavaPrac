package kk.oops;

public class SwapInteger {
    public static void main(String[] args) {
        Integer num1 = 10;
        Integer num2 = 20;
        Integer c = Integer.MAX_VALUE;
        int d = Integer.MAX_VALUE;
        /*
        It won't work as 'a' & 'num1', and 'b' & 'num2' are just holding the object reference.
        In swap method, 'a' & 'b' are just interchanging the value of the referenced object, not manipulating the object content.
        While interchanging the reference internally, swap method is also not doing anything to interchange the reference of 'a' & 'b'
         */
        swap(num1, num2);
        System.out.println(num1 + " " + num2);
    }

    static void swap(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
    }
}
