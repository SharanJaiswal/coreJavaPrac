package kk.generic;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MultipleParamGeneric {
    public static void main(String[] args) {
        Map m1 = new HashMap();
        m1.put(new Date(), "Sharan");
        m1.put(new Integer(23), new Character('A'));
        // We can see above that key and value are not type restricted.

        // Corrected, type-restricted way
        Map<Date, String> m2 = new HashMap<>();
        m2.put(new Date(), "Sharan");
        m2.put(new Date(), "Jaiswal");
//        m2.put(new String(), new Integer(69));  // Since it is type restricted, hence it throws error.
    }
}
