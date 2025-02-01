package kk.exceptionhandling;

/**
 * We cannot place <T> generic placeholder after the custom exception class name in the custom exception class signature. Because exceptions are thrown at runtime and placeholders are not present at runtime.
 */
public class MyException extends Exception {    // They are of type checked exception, needs catch block
    public MyException(String message) {
        super(message); // It's like the message variable that has been inherited, will have new value of error message string through this constructor of super
        // We can directly also set the error message to message string that has been inherited form parent class Exception
    }
}

class MyException1 extends Exception {
    public <T> MyException1(T message) {    // In above custom exception, we cannot add <T> in class signature. So, we tried adding it in the constructor.
        super(message.toString());  // We needed to add toString() method here because parent constructor takes String type,
        // and since "T" is still not guaranteeing that it will have message as String object, hence we added .toString() method. During type-erasure, T will be rendered as Object, which has toString().
        // Now while calling the constructor of this custom exception, we can pass arguments to this constructors as "some string" or 123.
    }
}

class CustomException2 extends Exception {
    public <T extends String> CustomException2(T message) {
        super(message); // Here, we didn't have to provide toString() method, as T's upper bound is of type String, which guarantees that message will be, at worse, will be of String type.
    }
}
