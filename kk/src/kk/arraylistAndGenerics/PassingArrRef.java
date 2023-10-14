package kk.arraylistAndGenerics;

import java.util.Arrays;

public class PassingArrRef {
    public static void main(String[] args) {
        int[] numArr = new int[] {1,2,3,4};

        PassingArrRef obj1 = new PassingArrRef();
        obj1.change(numArr);
        System.out.println(Arrays.toString(numArr));
    }

    private void change (int[] arrRef) {
        for (int i = 0; i < arrRef.length; i++) {
            arrRef[i] = 45;
        }
    }
}
