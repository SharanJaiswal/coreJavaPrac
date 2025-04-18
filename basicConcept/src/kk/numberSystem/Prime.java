package kk.numberSystem;

public class Prime {
    public static void main(String[] args) {

        // O(N * sqrt(N))
        for (int i = 2; i <= 101; i++) {
            if (primeEnhancedBrute(i)) {
                System.out.print(i + " ");
            } else {
                System.out.print("");
            }
        }
        System.out.println();

        findNumbersFromEratosthenesSieve(101);
    }

    private static boolean primeEnhancedBrute(int num) {
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

    /**
     * Requirement is to find all primes till number N.
     * Enhanced Brute force: Loop will run for all N numbers, where for each number till sqrt(n) it will be checked if its prime or not. So, time complexity will be N*sqrt(N)
     * Sieve of Eratosthenes: From above TC of N*sqrt(N), we will try to change sqrt(N) to constant 1. For that, we'll need an array of N numbers which will be storing the information if the number is prime or not. So, for our requirement, we'll find all primes from 1 to N in O(N) time.
     *
     *
     * Initial Approach to make that array::: First we make an array of N+1 with initial value of 1, which assumes that all are primes. Later we make those numbers as 0 which are not prime. We'll start picking numbers from idx 2, whose value is 1.
     * We agree on the fact that all multiples of 2 except the 2 itself will NOT be prime. So, we'll mark all multiples of 2 except 2 itself as 0.
     * Next, we move to next idx of array whose value is 1. It'll be 3. Thereby, marking all multiples of 3 except 3 , as 0. Next idx will NOT be 4 as its value is 0. Next will be 5, and so on...
     *
     * Optimization-1::::
     * 2*1; | 2*2, 2*3, 2*4, 2*5, 2*6, 2*7, 2*8, 2*9, ......  We'll mark 2 all multiples of 2 except 2 itself
     * 3*1; 3*2, | 3*3, 3*4, 3*5, 3*6, 3*7, 3*8, 3*9, ......  We see that till 2nd multiple of 2 would already have been marked as 0. So, we'll start from 3rd multiple to mark as 0
     * 4*1; 4*2, 4*3, | 4*4, 4*5, 4*6, 4*7, 4*8, 4*9, ......  We see that 4 is already 0. So no need to apply logic here.
     * 5*1; 5*2, 5*3, 5*4, | 5*5, 5*6, 5*7, 5*8, 5*9, ......  We see that till 4th multiple of 5 would already have been marked as 0. So, we'll start from 5th multiple to mark as 0
     * 6*1; 6*2, 6*3, 6*4, 6*5, | 6*6, 6*7, 6*8, 6*9, ......  We see that 6 is already 0. So no need to apply logic here.
     * 7*1; 7*2, 7*3, 7*4, 7*5, 7*6, | 7*7, 7*8, 7*9, ......  We see that till 6th multiple of 7 would already have been marked as 0. So, we'll start from 7th multiple to mark as 0
     *
     * This came from the fact that a number can be expressed as product of primes. So, in (op1 * op2) to express number as a product of prime(op1) and a number(op2). Now, the op2 itself can be expressed as product of primes but the primes included in prime-factor set of op2 will be < op1, till the point where op1 becomes equal to op2 itself, a prime.
     * This let us agree on the fact that till op2<op1, prime factors of op2 are already being treated before, where they have been marked as non-prime. EG, 7*6 => 7*(2*3). Since it is a multiple of 2 or 3, hence it would have been marked as non-prime (marked as 0 in array).
     * So, for idx in context, here 7, its multiples with 1<op2<7 must have already been marked as non-prime. Thereby, we need to mark multiple of 7 with op2>=7 as non-primes, where op1*op2 <=N
     *
     * Optimization-2::::
     * Let's say we are at idx 'i'. Once we choose 'i', our next task is to mark all the multiples of 'i' as 0, where op2 starts from 'i'. So, i's use starts from i*i.
     * What if i*i itself is beyond N. So, any i which is greater than N will be of no use in the iterations. So, why not we iterate from 1 to sqrt(N) instead of 1 to N, in outer loop. This will reduce the complexity of creating the sieve from the factor of N to sqrt(N).
     *
     * TC: O(N) + O(N*log(logN)) + O(N)
     */

    private static boolean[] findNumbersFromEratosthenesSieve(int n) {
        boolean[] eratosthenesSieve = new boolean[n + 1];
        for ( int i = 2; i < eratosthenesSieve.length; i++) {   // TC : O(N)
            eratosthenesSieve[i] = true;    // assuming all numbers are prime, and further eliminating non-primes by making them as false.
        }
//        for (int i = 2; i < eratosthenesSieve.length; i++) {
        for (int i = 2; i * i < eratosthenesSieve.length; i++) {    // eratosthenes.length will be N+1. Hence < and NOT <=.     TC : O(N*log(logN))
//            if (eratosthenesSieve[i] && primeEnhancedBrute(i)) {    // if it is true, then for sure it is prime. No need to check explicitly if its prime.
            if (eratosthenesSieve[i]) {
//                eratosthenesSieve[i] = true;  // its already true
//                int j = i + i;  // setting 'j'th element as the next multiple of 'i', ie, for here only j=i*2, which is NOT optimized. We will start from j=i*i
                int j = i * i;
                while(j <= n) {
                    eratosthenesSieve[j] = false;
                    j += i; // setting 'j'th element as next multiple of 'i'.
                }
            }
        }
        return eratosthenesSieve;

//        for( int i = 0; i < eratosthenesSieve.length; i++) {    // TC: O(N)
//            if (eratosthenesSieve[i]) {
//                System.out.print(i + " ");
//            }
//        }
    }

    // SEGMENTED SEIVE : Find all primes from [l,r]
    // Approach: calling eratosthenes sieve array. Make new array of size N==r. Using prefix sum, value at idx 'i' will be count of all true(1).
    // So, that when asked prime between [l,r], we simply subtract value of (l-1) from value of r, in the new array of prefix sum.
//    TC: O(N) + O(N*log(logN)) + O(N)  ::: later O(N) is for making a new array of prefix sum
    private static void segmentedSieve(int l, int r) {
        boolean[] eratosthenesSieve = findNumbersFromEratosthenesSieve(Integer.MAX_VALUE - 1);  // Although we need till 'r', but sending max-1 because array of (max-1)+1 will be created, otherwise int overflow can happen.
        int[] prefixSum = new int[r];    // Initialized all values at 0
        int count = 0;
        for(int i = 2; i <= r; i++) {
            prefixSum[i] = eratosthenesSieve[i] ? ++count : count;
        }
        System.out.println(prefixSum[r] - prefixSum[l - 1]);
    }
}
