package kk.numberSystem;

public class RangeXOR {
    public static void main(String[] args) {
        int a = 3, b = 9;

        int ans = xor(a-1) ^ xor(b);
        System.out.println(ans);
    }

    private static int xor(int n) {
        if (n % 4 == 0){
            return n;
        }
        if (n % 4 == 1){
            return 1;
        }
        if (n % 4 == 2){
            return n + 1;
        }
        return 0;   // for n%4==3
    }
}
