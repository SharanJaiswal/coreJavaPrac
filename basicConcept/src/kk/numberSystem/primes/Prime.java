package kk.numberSystem.primes;

public class Prime {
    public static void main(String[] args) {

        // O(N * sqrt(N))
        for (int i = -2; i <= 101; i++) {
            if (primeEnhancedBrute(i)) {
                System.out.print(i + " ");
            } else {
                System.out.print("");
            }
        }
        System.out.println();

        findNumbersFromEratosthenesSieve(101);

        // Sieve of Eratosthenes : When we need to find primes within range [a, b]. First we start picking all the natural numbers starting from 'a', and check if its prime or not
        // using primeEnhancedBrute where we'll check the divisibility of picked number for al the numbers [2, sqrt(n)]. Now, when we move from 'a' to 'b' covering all the numbers
        // in between, at 'b' we will also check its factors till sqrt(b) only. Of course, sqrt(a)<=sqrt(b). So, in this problem context where we are finding primes between 'a'&'b'
        // for all the numbers in [a,b], maximum number for which it will be checked if it is a factor or not, will be sqrt(b).
        // We must also agree that if a prime number is found, its multiple inside [a,b] will not be prime. Hence, while picking numbers one by one from [a,b], we can eliminate
        // those numbers which are multiple of prime, so that our time can be saved by not checking non-prime number, if it is prime or not.
    }

    private static boolean primeEnhancedBrute(int i) {
        if (i > 1) {
            int factor = 2;

            while (factor * factor <= i) {
                if (i % factor == 0) {
                    return false;
                }
                factor++;
            }
            return true;
        }
        return false;
    }

    private static void findNumbersFromEratosthenesSieve(int n) {
        boolean[] eratosthenesSieve = new boolean[n + 1];
        for ( int i = 2; i < eratosthenesSieve.length; i++) {
            eratosthenesSieve[i] = true;    // assuming all numbers are prime, and further eliminating non-primes by making them as false.
        }
        for (int i = 2; i < eratosthenesSieve.length; i++) {
            if (eratosthenesSieve[i] && primeEnhancedBrute(i)) {
                eratosthenesSieve[i] = true;
                int j = i + i;  // setting 'j'th element as the next multiple of 'i', ie, for here only j=i*2
                while(j <= n) {
                    eratosthenesSieve[j] = false;
                    j += i; // setting 'j'th element as next multiple of 'i'.
                }
            }
        }

        for( int i = 0; i < eratosthenesSieve.length; i++) {
            if (eratosthenesSieve[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
