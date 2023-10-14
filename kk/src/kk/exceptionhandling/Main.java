package kk.exceptionhandling;

public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try {
//            int c = a / b;
            divide(a, b);

            String name = "Sharan";
            if (name.equals("Sharan")) {
                throw new MyException("My message from my custom exception class");
            }
        } catch (MyException | ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("normal exception");
        } finally {
            System.out.println("this will always execute");
        }
    }

    // If any method is expected to throw an exception, even in their downstream, we have to mention "throws ExceptionName" at method signature, even in their interface.
    // Where there is "throws ExceptionName" is mentioned, in that method this exception can be catched. Not methods below in the stack track, allowed methods above in stack trace.
    // If there is instance method which has "throws ExceptionName" in its definition, then from any type of methods from where it is called, should also have "throws ExceptionName"
    static int divide (int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Please do not divide by zero");  // this constructor takes custom error message will override the existing error message
        }
        return a / b;
    }
}
