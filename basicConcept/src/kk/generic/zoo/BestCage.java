package kk.generic.zoo;

// While seeing method feedAnimal(), come here to read it.
// We could think that we can write <E [...] implements Eats> in the class definition, but java doesn't allow to use "implements" keyword inside <>.
// Instead, use "extends" even if its interface. That's the way generic syntax works.
// Moreover, if we write <E extends Animals, AnythingLikeFooBar>, java compiler interpret it as BestCage have generic type that accepts 2 variables;
// One of type which is extending Animals (could be class or interface), and another variable of type generic AnythingLikeFooBar, where AnythingLikeFooBar is mere symbol
// and coincidentally have name similar to one of the class or interface; just like "E" of "E extends Animals"
// It's like writing Map<K, V> where K and V are just symbols.
// To apply multiple upper bounds, use "&" symbol between types (could be class and/or interface),
// where first all Classes, if any, would appear; and then interfaces, if any, would appear. C1 & C2 ... & I1 & I2 ...

public class BestCage<E extends Animals & Eats & Runs> {
    private E animal1;
    private E animal2;

    public BestCage() {
    }

    public BestCage(E animal1, E animal2) {
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

    // Animals who could eat and run can have eats() and runs() method inherited, which is why we have mentioned in this class' signature that only accept those animals which can eats as well as run.
    public void feedAnimal() {
        animal1.eats();
        animal2.eats();
    }

    public void runAnimal() {
        animal1.run();
        animal2.run();
    }

//    public static boolean isCompatibleBest(E animal1, E animal2) {    // If this would be non-static, we are bound to mention generic type "E" which should be same as mentioned inside class signature.
    public static <T extends Animals> boolean isCompatibleBest(T animal1, T animal2) {  // Type inside <> must be between "static" keyword and before return type of the method.
        return animal1.getType().equals(animal2.getType()); // We expect E to be of type Animal or its extension, because it'll support "getType()" method.
//        says that E cannot be referenced from the static context because without specifying <E extends Animal>, E gets resolved in compile-time when using instantiating BestCage object {new BestCage<Animal>}
//        (in the commented method signature).

//        E will get replaced by the value inside <> when creating the instance of BestCage class. Since, it is a static method, therefore we'll not call this method using BestCage instance.
//        Therefore, in the commented method signature, there is error on "E" in argument parenthesis.
        /**
         * Also, even if we would write "E" instead of "T", then "E" inside the parenthesis of method signature, "E" is not same as the "E" which is mentioned inside <> of class signature.
         * Since, this is now a static method, therefore this method does not require "E" from the class signature, which eventually means, it does not require BestCage<Animal>(o1,o2) object to call this static method. So, this method's "E" will not get replaced when instance of this class gets created providing "Type" inside <>.
         * We could think that this method's "E" will get replaced when calling the method using class name, by providing "Type" inside <> at static invocation,
         * ie, BestCage<Monkey, Monkey>.isCompatibleBest(m1, m2); ; but type of "E" will still not get resolved, and this is a wrong way of calling static method expecting param of generic type.
         * In other way, we can mention bound on the generic type of the parameter between "static" and return type of this method signature.
         * In this way, we don't have to call the static method along with error.
         * Type check of "E" inside parenthesis will get checked by inferring <E extends Animals>
         */
    }
}
