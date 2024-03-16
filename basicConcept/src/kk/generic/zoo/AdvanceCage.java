package kk.generic.zoo;

public class AdvanceCage<E extends Animals> {
    private E animal1;
    private E animal2;

    public AdvanceCage() {
    }

    public AdvanceCage(E animal1, E animal2) {
        this.animal1 = animal1;
        this.animal2 = animal2;
    }

    public E getAnimal1() {
        return animal1;
    }

    public void setAnimal1(E animal1) {
        this.animal1 = animal1;
    }

    public E getAnimal2() {
        return animal2;
    }

    public void setAnimal2(E animal2) {
        this.animal2 = animal2;
    }

    public boolean isCompatible() {
        return this.getAnimal1().getType().equals(this.animal2.getType());
    }

    public void feedAnimal() {
//        animal1.eats();  // Doesn't work because animal1|2 's type are yet not known at compile time in java. All it knows and restricts that those type are extending Animal class
        // Java does not yet that some selected child classes are extending the Eats and Runs interface, whose information is not in Animal.
        // See BestCage class
    }
}
