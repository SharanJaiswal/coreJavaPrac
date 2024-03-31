package kk.exceptionhandling;
// Exceptions are used to handle mostly runtime errors, but less compile time errors.
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
            // Inside try block, or any block, we can have nested try-catch-finally block.

            // If we had called any method from this try block and that method jad thrown an exception, then if that exception had been handled there in downstream, then here, this catch
            // block will not get invoked. Otherwise, any of the below catch block would have been invoked. In that case where exception is not handled inside the downstrem method,
            // the method signature will append "throws {ExceptionClassName}" after parenthesis containing parameters of the method. If exception is handled in method, then no need to append.
        } catch (MyException | ArithmeticException e) {
            System.out.println(e.getMessage());
            // We can also use return statement form any of the block.
        } catch (Exception e) {
            System.out.println("normal exception");
        } finally {
            System.out.println("this will always execute");
        }
    }

    // If any method is expected to throw an exception, even in their downstream, we have to mention "throws ExceptionName" at method signature, even in their interface.
    // Where there is "throws ExceptionName" is mentioned, in that method this exception can be caught. Not methods below in the stack track, allowed methods above in stack trace.
    // If there is instance method which has "throws ExceptionName" in its definition, then from any type of methods from where it is called, should also have "throws ExceptionName"
    static int divide (int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Please do not divide by zero");  // this constructor takes custom error message will override the existing error message
        }
        return a / b;
    }
}
