package kk.generic;

public class GenericInterfaceClass implements GenericInterface<Integer> {   // Here we provided Integer for T
    @Override
    public void display(Integer num) {  // Since we provide Integer for T, hence overridden/implemented methods param with T also becomes of type Integer
    }
}

