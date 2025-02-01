package kk.oops;

public class First {
    // Classes can be empty and valid.
    // If constructors are not explicitly defined, a default constructor is present ClassName(){ [super();] }
    // A concrete class is such class whose object can be created using "new", all methods will have its implementation in that class, could be a child class from any interface, abstract class, normal class.
    // Concrete class should have access specifier as default or public.

    public static void main(String[] args) {
        for (EnumSample1 enums : EnumSample1.values()) {    // EnumSample1.values() gives an array of enum entries, EnumSample1[] enumValues
            System.out.print(enums.ordinal() + " ---- " + enums.toLowerCase());
        }

        EnumSample1 enumValue = EnumSample1.valueOf("FRIDAY");  // it is returning enum constant. If String value doesn't match with any of the enum value, then exception will be thrown
        System.out.println(enumValue);  // FRIDAY - because, value of enums are their constants name.
        System.out.println(enumValue.name());   // FRIDAY

        EnumSample1 monday = EnumSample1.MONDAY;
        System.out.println(monday.name());  // Gives string value of the enum, the actual visible name of the enum entries
        System.out.println(monday.ordinal());   // Gives its enum order value. Its integer by nature.



        System.out.println(EnumSample2.getEnumFromValue(101).name());   // MONDAY - Since custom method returns first case satisfies
//        System.out.println(EnumSample2.getEnumFromValue(104).name());   // Error because custom method returned NULL, and are doing null.name(), throwing NPE.

        for (EnumSample2 enums : EnumSample2.values()) {
            if(enums.getVal() == 101) {
                System.out.println("Enum for 101: " + EnumSample2.valueOf(enums.name()));
                System.out.println("Its comment: " + enums.getComment());
            }
        }
    }
}

interface Inter {
    // Interfaces can be empty and valid

    public String toLowerCase();
}


/**
 * POJO: Plain Old Java Object: public class, public default constructor, no annotation above it like @Id, @Entity, @Table, etc., should neither any class nor implement interface. eg beans
 */

/** ENUMS : Used over final static variables because during comparison Enums has a set of values to compare with another enums, rather comparing with any out of range values.
 * Collection of constants (variables which values cannot be changes, final static implicitly).
 * Cannot extend any class as implicitly extends java.lang.Enum class, since also because only 1 class can be extended. But can implement multiple interfaces.
 * Can have variable, constructor (private implicitly including all user defined, hence cannot be instantiated outside of class but inside) and methods.
 * Cannot be extended. (sort of final).
 * Can have abstract method, if having any abstract method, then all constants should implement that abstract method.
 * Default values start from 0,1,2,....
 */
enum EnumSample1 implements Inter {  //Normal Enum - CAN BE PUBLIC IF A DEDICATED FILE IS FOR ENUM
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    @Override
    public String toLowerCase() {
        return this.name().toLowerCase();
    }
}

enum EnumSample2 {  // Enums with custom values. Needs constructor. Even user defined constructors are private implicitly. Whatever member variable, constructor method is present, it is for each constant.
    // Think enum constants as different instantiated final objects. It is wrong technically, but only for the purpose of understanding.
    // Observe that constructors are called for every constant. Also, the value is not sequential and repetitive.
    MONDAY(101, "1st day of week") {
        @Override   // Method overriding by constants
        public String getComment() {
//            return super.getComment();
            return "Overridden Comment for a particular constant. Hence, constants have individual method copies which can be overridden.";
        }

        @Override
        public void absMet() {
        }
    },
    TUESDAY(101, "1st day of week") {
        @Override
        public void absMet() {
        }
    },
    WEDNESDAY(102, "1st day of week") {
        @Override
        public void absMet() {
        }
    },
    THURSDAY(103, "1st day of week") {
        @Override
        public void absMet() {
        }
    },
    FRIDAY(105, "1st day of week") {
        @Override
        public void absMet() {
        }
    },
    SATURDAY(107, "1st day of week") {
        @Override
        public void absMet() {
        }
    },
    SUNDAY(106, "1st day of week") {
        @Override
        public void absMet() {
        }
    };

    public int val;
    private String comment;

    EnumSample2(int val, String comment) {
        this.val = val;
        this.comment = comment;
    }

    public int getVal() {
        return val;
    }

// purposely making setters as private because enum values are constant objects, but the attributes inside them are not constant.
    private void setVal(int val) {
        this.val = val;
    }

    public String getComment() {
        return comment;
    }

    private void setComment(String comment) {
        this.comment = comment;
    }
//    Since, independent copies of method and variables are assigned for every constant, so to make method available to enum level itself but not to constant level:
    public static EnumSample2 getEnumFromValue(int value) {
        for(EnumSample2 enums : EnumSample2.values()) {
            if(enums.val == value) {
                return enums;
            }
        }
        return null;
    }

    public abstract void absMet();    // If enums have abstract method, then it need to be overridden by every constant because it will be part of every constant.
}

