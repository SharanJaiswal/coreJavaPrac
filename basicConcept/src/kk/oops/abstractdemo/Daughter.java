package kk.oops.abstractdemo;

public class Daughter extends Parent {
    public Daughter(int age) {
        super(age, 90);
//        this.age = age;
    }
    @Override
    void career(String job) {
        System.out.println("I am of " + this.age + ", going to be a " + job + ".");
    }

    @Override
    void partner(String name, int age) {
        System.out.println("I love " + name + ". He is of age " + age + ".");
    }

    @Override
    void normal() {
        System.out.println("Normal method from Daughter.");
    }
}
