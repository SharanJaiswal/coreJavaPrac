package kk.generic.zoo;

public class Cage {
    // Since we don't have common parent class of Lion and Monkey, and our requirement is to have animals of any type inside of given cage.
    // Therefore, we will use Object class
    private Object animal1;
    private Object animal2;

    public Object getAnimal1() {
        return animal1;
    }

    public void setAnimal1(Object animal1) {
        this.animal1 = animal1;
    }

    public Object getAnimal2() {
        return animal2;
    }

    public void setAnimal2(Object animal2) {
        this.animal2 = animal2;
    }
}
