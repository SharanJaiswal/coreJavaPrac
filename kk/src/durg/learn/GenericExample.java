package durg.learn;

public class GenericExample {

    public static void main(String[] args) {
        Box box1 = new Box("this is working");
        box1.conatainer = 214;
        System.out.println(box1.getConatainer());
        System.out.println(box1.findByDataType(box1.conatainer));

        Box<String> box2 = new Box<>("only strings is supported");
        System.out.println(box2.getConatainer());
        System.out.println(box2.findByDataType(box2.conatainer));

    }

}
