package kk.numberSystem;

/**
 * We need to divide 2 integers. Catch is we cannot use division or modulo operator.
 * Brute force approach: iteratively add divisor to some ZERO, until it exceeds dividend; and while doing this, on every iteration increase the counter. Answer will be counter where sum the max and <= dividend. TC:2^31 this might give TLE in most of the cases.
 * Better Approach: Any number can be expressed as the sum of unique powers of 2. We will define dividend as divisor*(sum of unique powers of 2). S, we'll find max power of 2 where divisor*(2^power) will be <= dividend.
 * We'll reduce that divisor*(2^power) from dividend, and in answer variable (initially as 0) we'll add this divisor*(2^power). We'll do this till we have dividend >= divisor.
 * Edge cases: A division can only be negative when either divisor is negative or dividend is negative, else non-negative in every case, if divisor is non-zero.
 * In case where dividend is Integer.MIN_VALUE(-2^31) and divisor is -1, then answer will be Integer.MAX_VALUE+1 (2^31); giving overflow condition. In such cases, return Integer.MAX_VALUE (Its wrong, but it is what it is)
 * Other edge case would be when dividend==divisor, then in such cases, we need to return 1;
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {

    }

    private static void division(int dividend, int divisor) {
        if (dividend == divisor) {
            System.out.println("1");
            return;
        }

        boolean isPositive = true;
        if ((dividend < 0 && divisor > 0) || (dividend >= 0 && divisor < 0)) {
            isPositive = false;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int count = 0;
        long answer = 0;
        while (dividend >= divisor) {
            count = 0;
            while (divisor << (count + 1) <= dividend) {
                count++;
            }
            answer += (1 << count);
            dividend -= (divisor * (1 << count));
        }
        if (answer > Integer.MAX_VALUE && isPositive == true) {
            System.out.println(Integer.MAX_VALUE);
            return;
        } else if (answer > Integer.MAX_VALUE && isPositive == false) {
            System.out.println(Integer.MIN_VALUE);
            return;
        }
        System.out.println(isPositive ? answer : "-" + answer);
/**
 * TIME COMPLEXITY: (log2(N))^2
 * Outer while loop has Log2(N). Reason: Divisor is getting reduced from dividend. Divisor is getting increased by double. So, vaguely, dividend is getting reduced by power of 2.
 * Inner while loop has log2(N). Reason: Divisor is getting increased by double.
 */
    }

    /**
     * Similarly, we can do the division also. My first approach was to get lsb from both a and b and add those 2 with a carry. If I consider only lab od a and b, there will be 3 case where:
     * 1. either lsb of 'a' or of 'b' will be set, then carry will be zero, and ans will be ans=(ans<<1)|1
     * 2. both will be zero, then carry will be zero, and answer will be ans=(ans<<1)
     * 3. both will be set, then carry will be 1, and answer will be ans=(ans<<1)
     * But this made me realize, I'm considering only lsb of 'a' and 'b', not the carry. So, all three case will have 2 more case each where carry will be 1 or it'll be making tot of 6. However, 3 and 4 case can be combined to one single case.
     * At every iteration, answer will be left shifted by 1, and both 'a' and 'b' will be right shifted by 1, unless both 'a' and 'b' will turn to zero.
     * Its TC is O(1)
     *
     *
     * Optimal approach with same TC, but with lesser iterations:
     * We know, if considering only 'a' and 'b', then on bit addition without carry in context, will be same as taking XOR. where both set bit will be 0, one set bit will be 1, both unset bit will be 0.
     * We know, carry will only be generated from index where both will be set and not in any other case. So, taking '&' of both 'a' and 'b' will be producing carry's partial info
     * where each set bit will be used to get added to next bit towards left. So, carry = carry << 1 , and then add this carry with XORed 'a' and 'b'.
     * We know, that while producing carry, it only gave information about which index bit will produce carry when only that particular index is considered, but it skipped the domino effect of carry that might come from right towards left.
     * So, we'll consider two numbers, that is, XORed 'a' and 'b' as 'a', and shifted carry as 'b', and will repeat this process until carry becomes 0. On that iteration, the XORed number will be the final answer.
     */
    private static void addition(int a, int b) {
        int ans = 0;
        while (b != 0) {
            ans = a ^ b;
            b = (a & b) << 1;
            a = ans;
        }
        System.out.println(a);
    }
}

