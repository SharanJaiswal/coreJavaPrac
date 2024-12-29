package kk.generic.zoo;

public class Zoo {
    public static void main(String[] args) {
        Cage cage = new Cage();
        cage.setAnimal1(new Lion());
        cage.setAnimal2(new Monkey());

        // Suppose a situation where cage is dedicated to specific type of animal. But we have put a Monkey with a Lion. Moreover, we can even literally put a Car inside cage
        // because setAnimal can accept instance of Object.

//        So, we want to make certain cage specific to animal species.
        BetterCage<Lion> betterCage1 = new BetterCage<>();
        betterCage1.setAnimal1(new Lion());
//        betterCage1.setAnimal2(new Monkey());  // this will give error
        betterCage1.setAnimal2(new Lion());

        Lion lion1 = betterCage1.getAnimal1();
//        Monkey monkey = betterCage1.getAnimal2();    // This will give error
        Lion lion2 = betterCage1.getAnimal2();


// Let's suppose we want to add 2 animals together to a cage
        BetterCage<Monkey> monkeyBetterCage1 = new BetterCage(new Monkey(), new Lion());
        // We can see that a Lion got also added to a monkey's cage. This could potentially add anything, and cannot add Monkey at all.
        // This happened because at RHS we are not instantiating generic BetterCage<>, but a BetterCage w/o <>
        // which is equivalent to assigning non-generic type to generic type for backward compatibility.
        // below is the correct way
        BetterCage<Monkey> monkeyBetterCage2 = new BetterCage<>(new Monkey(), new Monkey());
//        BetterCage<Monkey> monkeyBetterCage3 = new BetterCage<>(new Monkey(), new Lion());    // gives error as it requires only of Monkey type species.


        // Till now, we can restrict the cage with specific type of element that could be part of it.
        // But We still can make cage of Cars. We didn't restrict yet with type of animals only inside cage. This could be achieved by restricting the type of generic.
        BetterCage<String> monkeyBetterCage4 = new BetterCage<>(new String(), new String());    // potentially can add anything of same type
        // More sensible option is below:
        AdvanceCage<Monkey> monkeyAdvanceCage1 = new AdvanceCage<>(new Monkey(), new Monkey());
//        AdvanceCage<String> monkeyAdvanceCage2 = new AdvanceCage<>(new String(), new String()); // Only allowed type of entities in cage is Animal or its derivatives.

        // If we want to check the compatibility of two animal in the cage, we are first putting them together in cage and then deciding if they are compatible, ie,
//        we are first making BestCage object, and then we are checking the compatibility of 2 animals.
//        But, we can do one thing, is that, we'll check compatibility without making the BestCage object, ie, without putting the animals first in the cage.
        Monkey monkey1 = new Monkey();
        Monkey monkey2 = new Monkey();
        BestCage.isCompatibleBest(monkey1, monkey2);

        // Testing if BestCage can accept any animals of type which doesn't implement Eats and|or Runs
//        BestCage<Snail> snailBestCage = new BestCage<Snail>();  // Gives error. Hence, animals that will go inside BestCage must implement interfaces Runs and Eats also, along with Animals class itself.
    }
}
