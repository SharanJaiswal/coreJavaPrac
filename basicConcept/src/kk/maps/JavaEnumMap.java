package kk.maps;

import java.util.EnumMap;

public class JavaEnumMap {
    // Enum maps are faster than HashMap, memory efficient
    public static void main(String[] args) {
        EnumMap<DAY, String> enumMap = new EnumMap<>(DAY.class);    // Internally, it created an array of fixed size whose length is same as number of enum entries.
        enumMap.put(DAY.TUESDAY, "Cardio");
        enumMap.put(DAY.THURSDAY, "Walking");
        System.out.println(enumMap);    // does not maintain insertion order, but actually maintains the order based on the enum ordinal
    }
}

enum DAY {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
        }