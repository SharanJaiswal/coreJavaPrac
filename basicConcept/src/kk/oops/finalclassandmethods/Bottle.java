package kk.oops.finalclassandmethods;

public final class Bottle extends Container {   // final classes cannot be inherited. So, if we want our classes to NOT be inherited, we put final keyword.

    final String type;  // final class variables are not final but methods are inherently final.
    public Bottle() {
        super(3, "Glass");
        type = null;
    }

    // Parent method gets overridden as that parent method is not final method
    @Override
    final void getSizeAndMaterial() {   // final class variables are not final but methods are inherently final.
        super.getSizeAndMaterial();
    }

    // parent method getCostPrice() cannot be get overridden as that parent method is declared as final in Parent class.
}


// This class cannot extend class Bottle, as that Bottle class is declared as final

//class GlassBottle extends Bottle{
class GlassBottle{
}