package kk.numberSystem;

/**
 * Time Complexity is Log2(power) as we are iteratively dividing power by 2 until it becomes zero.
 * Calculate the base^exponent value. BRUTE FORCE: for (2 -> exponent) multiply num to num and store it in num. TC O(N)
 * Optimized approach: reduce the iterations: base^exponent can be expressed as [(base^2)^(exponent/2)]. Find (base^2) and (exponent/2). This way, we now have exponent as (exponent/2), reduced by half. If exponent is odd, then interim answer is (ans*base) which will be multiplied by (base^2)^(exponent/2). Continue the process till exponent becomes 0
 */
public class Power {
    public static void main(String[] args) {
    }

    private static long findExponent(int base, int exp) {
        boolean negExp = exp < 0;
        if (exp < 0) {
            exp = -exp;
        }
        long ans = 1;
        while (exp >= 1) {
            if ((exp & 1) == 1) {
                ans *= base;
                exp -= 1;
            } else {
                base *= base;
                exp >>= 1;
            }
        }
        return exp == 0 ? 1 : negExp ? 1 / ans : ans;   // First check for 0 power, then for negative power, then for positive power.
    }
}
