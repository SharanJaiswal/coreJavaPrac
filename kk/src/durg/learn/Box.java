package durg.learn;

public class Box<T> {

    T conatainer;

    public Box(T conatainer) {
        this.conatainer = conatainer;
    }

    public T getConatainer() {
        return this.conatainer;
    }

    public String findByDataType(T container) {
        if (container instanceof String) {
            return "String";
        } else if (container instanceof Integer) {
            return "Integer";
        } else {
            return "Something Else.";
        }
    }
}
