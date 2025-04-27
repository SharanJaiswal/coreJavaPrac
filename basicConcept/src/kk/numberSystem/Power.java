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

    /**
     * Another approach could be of time complexity log2(exp). We know, a number can be expressed as the sum of unique powers of 2.
     * Only those 2^power will be included where in binary representation of a number the bits are set. Also, we know that BASE^(a+b) == (BASE^a)*(BASE^b)
     * We'll be taking iteratively the bits from LSB of exp. In each iteration, we'll multiply the base by base itself, and will only multiply that product to ans(initially 1)  when bit is set.
     */
    private static void findExponenet2(int base, int exp) {
        boolean isNegative = false;
        if (exp < 0) {
            isNegative = true;
            exp = -exp;
        }

        long ans = 1;
        while (exp != 0) {
            if ((exp & 1) == 1) {
                ans = ans * base;
            }
            exp = exp >> 1;
            base = base * base; // making it ready for next iteration
        }
        System.out.println(isNegative ? (1 / ans) : ans);
    }
}
