package kk.exceptionhandling;
// Exceptions are used to handle mostly runtime errors, but less compile time errors. They are expensive if not handled cuz they look to get caught unless they get caught in upstacks.
// catch block are optional, there could be try{ [t-[...c]-[f] }-[... catch]-[finally]. If not catch, then that method should mention "throws Exception..."
// finally doesn't get executed on Error, but executed on exceptions.
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

            // If we had called any method from this try block and that method had thrown an exception, then if that exception had been handled there in downstream, then here, this catch
            // block will not get invoked. Otherwise, any of the below catch block would have been invoked. In that case where exception is not handled inside the downstream method,
            // the method signature will append "throws {ExceptionClassName}" after parenthesis containing parameters of the method. If exception is handled in method, then no need to append.
        } catch (MyException | ArithmeticException e) {
//            throw e;    // we can again throw
            System.out.println(e.getMessage());
            // We can also use return statement from any of the block.
        } catch (Exception e) {
            System.out.println("normal exception");
        } finally {
            System.out.println("this will always execute");
        }
    }

    // checked exception caused by methods which has "throw new Exception...." or "throws Exception..." mentioned which forces us to either mention "throws ..." in method signature, or to catch it there or at any upstream call stacks.
    // unchecked exception doesn't force us to put try catch block, could potentially throw exception at runtime. We can add try-catch block as preventive measure.
    // only methods can mention "throws Exception...", not class.
    // runtime exceptions erupted via manual or by machine scenarios, gives an option to not catch(optional catch block) it as they are unchecked exceptions. But will certainly break code when erupted.

    // If any method is expected to throw an exception, even in their downstream, we have to mention "throws ExceptionName" at method signature, even in their interface.
    // Where there is "throws ExceptionName" is mentioned, in that method this exception can be caught. Not methods below in the call-stack track, allowed methods above in call-stack trace.
    // If there is instance method which has "throws ExceptionName" in its definition, then from any upstream methods in call stack from where it is called, should also have "throws ExceptionName" unless it is caught.
    static int divide (int a, int b) throws ArithmeticException, InterruptedException {   // mentions that even if this method doesn't throw exception, still we've to handle it, cuz it might throw it at runtime.
        if (b == 0) {
            throw new ArithmeticException("Please do not divide by zero");  // this constructor takes custom error message will override the existing error message
        }
        return a / b;
    }
}
