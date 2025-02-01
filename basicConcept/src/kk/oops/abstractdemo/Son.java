package kk.oops.abstractdemo;

public class Son extends Parent{
    public Son(int age) {
        super(age, 90);
//        this.age = age;
    }

    @Override
    void career(String job) {
        System.out.println("I am going " + this.age + ", to be a " + job + ".");
    }

    @Override
    void partner(String name, int age) {
        System.out.println("I like " + name + ". She is of age " + age + ".");
    }
}
