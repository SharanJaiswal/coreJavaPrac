package kk.numberSystem;

public class BasicMaths {
    public static void main (String[] args) {
        int x = -123;
        while (x > 0) {
            System.out.println(x % 10);
            x /= 10;
        }
    }

    // Works for non-negative numbers
    private static int countAndSumAndReverseOfDigits(int num) {
        int count = 0, sum = 0, digit, reversedNumber = 0;
        while (num > 0) {
            digit = num % 10;
            count++;
//            count = (int)Math.log10(num) + 1; // base 10 because it is decimal system. If base 2 number are into context, then log2(num). If we are iteratively|recursively dividing it by 5, it'll be log5(num).
            sum += digit;
            reversedNumber = reversedNumber * 10 + digit;
            num /= 10;  // Since we are iteratively diving num by 10 until it becomes 0, hence time complexity is ~= LOG10(num)
        }
        return count;
    }

    // Valid and originally supposed to work only for non-negative numbers.
    private boolean armstrongNumber(int num) {
        int digits = 0, orgNum = num;
        while (num > 0) {
            digits++;
            num /= 10;
        }
        num = orgNum;
        long calculatedNum = 0L;
        while (num > 0) {
//            calculatedNum = calculatedNum * 10 + (long) Math.pow(num % 10, digits);   // works well if everything works within favorable cases.
            long power = (long) Math.pow(num % 10, digits);
            if (power > Integer.MAX_VALUE || (Integer.MAX_VALUE - power) / 10 < calculatedNum) {    // To avoid integer overflow, and to break loop from where its not required to calculate further.
                return false;
            }
            calculatedNum = calculatedNum * 10 + power;
            num /= 10;
        }
        return (long) orgNum == calculatedNum;
    }

    // Find all divisors - Prints in non-ordered form. O(sqrt(N)). If sorting is involved ==> O(sqrt(N)) + O(n* log(N))
    private static void printAllDivisors1(int num) {
        for (int i = 1; i <= (int)Math.sqrt(num); i++) {
            if (num % i == 0) {
                System.out.println(i);
                if (num / i != i) {
                    System.out.println(num / i);
                }
            }
        }
    }

    private static boolean isPrime1(int num) {
        int count = 1;
        for (int i = 2; i < (int)Math.sqrt(num); i++) {
            if (num % i == 0) {
                count++;
                if (num / i != i) {
                    count++;
                }
                if (count > 2) {
                    return false;
                }
            }
        }
        return count == 2;
    }

    // GCD or HCF ::: assuming num1 and num2 are non-negative numbers.
    private static int gcd1(int num1, int num2) {
        if (num2 > num1) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        int gcd = 0;
        // Consider case of 10 and 20. In first iteration, in first if gcd = 1; while in nested if gcd = 10, ie the smaller number itself
//        for (int i = 1; i < Math.sqrt(num1); i++) {
        for (int i = 1; i < Math.sqrt(num1) && gcd != num1; i++) {  // gcd!=num1 check is done because num1 is smallest among num1 and num2. And if we found the max divisor that could divide completely num1, there is no point in checking further if remaining i's could divide num1 and num2 completely or not.
            if (num1 % i == 0 && num2 % i == 0) {
                gcd = Math.max(gcd, i);
                if (num1 / i != i && num2 % (num1 / i) == 0) {  // First, find the largest(second) operand which completely divides num1 (it'll be num1/i); then check if this second operand completely divides the second number. If yes, that means num1/i completely divides num1 and num2 as well.
                    gcd = Math.max(gcd, num1 / i);
                }
            }
        }
        return gcd;
    }

    /**
     * Minimum positive value of Ax+By is the gcd(A,B), where x and y are integers. So, for given eq Ax+By=k is only possible when k%gcd(A,B)==0, where gcd(A,B)(Px+Qy)=k
     * Euclidean Algorithm for GCD of 2 numbers: gcd(a,b) == gcd(a-b, b); a>=b. That means, If we iteratively|recursively reduce the numbers by subtracting one from another, we will end up with one number having 0, and another x. This remaining number 'x' is the gcd of (a,b). Linear approach O(N)
     * Above steps can be minimized by, instead of chained reduction using subtraction, we can see that gcd(a,b)==gcd(a%b, b); where a>=b. Logarithmic approach O(log phi (min(a,b)))
     */
    private static int gcd2(int num1, int num2) {
        while (num1 != 0 || num2 != 0) {    // ~= O(N)
            if (num1 >= num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
        }
        return num1 == 0 ? num2 : num1;
    }

    private static int gcd3(int num1, int num2) {
        while (num1 != 0 || num2 != 0) {    // ~= O(Log phi (min(num1, num2))) ::: log because we are reducing the search space by division. phi because that divisor as a factor is changing, it is not a fixed factor.
            if (num1 >= num2) {
                num1 = num1 % num2;
            } else {
                num2 = num2 % num1;
            }
        }
        return num1 == 0 ? num2 : num1;
    }

    // recursive approach : gcd(a,b) {while (num1!=0 {or num2!=0}) { gcd(b%a,a) }}

    // Find prime divisors of a number ::: Not exactly but TC is O(sqrt(N) * 2 * sqrt(N)), where first sqrt(N) will belong to first loop in which it is exact iteration. While prime checks are done with sqrt(N) iterations. Prime checks are done twice, but NOT for all the numbers. Checks are happening only for those which are factor of num provided.
    private static void allPrimeDivisors1(int num) {
        int i = 1;
        while (i <= Math.sqrt(num)) {
            if (num % i == 0) {
                if (isPrime1(i)) {
                    System.out.println(i);
                }
                if (num / i != i) {
                    if (isPrime1(num / i)) {    // After sqrt(N), factor of N other than i could be prime, or product of primes. So, if op2 is prime, then this should also be included. Example, where N=21, 21=3*7; sqrt(21)=4. So, 3 <= 4 & 7 > 4, where 3 and 7 are primes.
                        System.out.println(num / i);
                    }
                }
            }
            i++;
        }
    }

    // School method ::: Continue dividing the number by i unless num%i!=0. Then find next i. So, all the i's starting from 2, which will produce num%i==0 will happen to be prime. TC O(sqrt(N) * log(N))
    private static void allPrimeDivisors2(int num) {
        int i = 2;  // We are not starting from 1. So, during the first iteration, inside nested if condition, if num is not prime, then also 1 and the number itself will be considered as prime. But, if it's starting from 2, and if the number itself is prime, then in that case the number itself is prime divisor of itself but it'll not be included in the solution. So, we'll add it explicitly.
        while (i <= Math.sqrt(num)) {
            if (num % i == 0) {
                System.out.println(i);
                while (num % i == 0) {
                    num /= i;
                }
            }
            i++;
        }
        // If the number itself is not prime, then last divisor which divides completely the num will not be itself, it'll be some divisor<num which will be prime. In the above logic, there is no provision to check if number itself will be divided by itself as iteration starts from 2. But if the number is itself prime, in that case also, there is no provision to check if num can divide itself completely to add to answer.
        // So, we will explicitly check it
        if (num != 1) {
            System.out.println(num);
        }
    }

    /**
     * This is based on sieve of eratosthenes concept where we prepare sieve of N+1, where value at each idx will be holding the smallest prime factor of that idx.
     * So that, if sieve is already given, then we find the prime factors in log2(N) in worse complexity.
     * We choose base 2 because it's a worse complexity, which means, if a num is an exponentiation of 2 only, then it'll be reduced iteratively by half only, the slowest, taking most time.
     * Similarly, if the num is exp of 5, then it would have been log5(num). For seven, it would have been log7,(num). However num could be combined prod of many different primes.
     * So, largest time will be taken by smallest prime, to reduce it iteratively; which is worse case. So, worse case TC: O(log2(N)); if sieve is already served.
     * If sieve is also taken into consideration, then, TC: [O(n*log(logN)) + O(log2(N))]
     */
    private static void allPrimeDivisors3(int num) {    // Assuming num < Integer.MAX_VALUE
        int[] sieve = spfSieve(num);
        while (num != 1) {
            System.out.println(sieve[num]);
            num /= sieve[num];
        }
    }
    private static int[] spfSieve(int num) {    //
        int[] spfSieve = new int[num + 1];
        for (int i = 0; i < spfSieve.length; i++) {
            spfSieve[i] = i;
        }
        for (int i = 2; i <= Math.sqrt(spfSieve.length); i++) {
            if (spfSieve[i] == i) {
                for (int j = i * i; j < spfSieve.length; j = j + i) {
                    spfSieve[j] = i;
                }
            }
        }
        return spfSieve;
    }
}

/**
 * LCM: least common multiple of numbers, here 2 numbers. A smallest non-negative number which can be completely divisible by both the numbers A and B.
 * A=Px and B=Qy. So, gcd(A,B) is the largest common factor of A and B. Hence, A=gcd(A,B)*P and B=gcd(A,B)*Q
 * A*B=gcd*gcd*P*Q  => (A*B)/gcd = gcd*P*Q where gcd*P*Q is LCM.
 * Visualize, for given A and B, LCM of A and B will be taking out maximum possible common part (as their factor) and multiply that HCF with the product of remaining factor P and Q.
 * Interestingly, P and Q will be co-primes as the common part as factors are being taken out and remaining respective factors are P and Q.
 */