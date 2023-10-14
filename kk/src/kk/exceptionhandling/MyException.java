package kk.exceptionhandling;

public class MyException extends Exception {
    public MyException(String message) {
        super(message); // Its like the message variable that has been inherited, will have new value of error message string through this constructor of super
        // We can directly also set the error message to message string that has been inherited form parent class Exception
    }
}
