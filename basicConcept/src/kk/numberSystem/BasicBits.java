package kk.numberSystem;

import java.util.Arrays;

public class BasicBits {
    public static void main(String[] args) {
        findOnceInTriplets1();
    }

    /**
     * 1's compliment : flipping all the bits.
     * 2's compliment : 1's compliment + 1
     */

    /**
     * In computers, numbers are stored in binary format.
     * An integer is 32-bit number, in which MSB(leftmost bit) is reserved for sign bit.
     * A positive number is stored with MSB as 0, while negative is stored with MSB as 1. However, the way MSB becomes 1 in negative numbers happens via a process; NOT like [1]-[31 bit representation od positive number.
     * Let's take example of 3 and -3. 3 is stored as [0]...011 in 32-bit format.
     * While to store -3; first 32-bit representation of 3 is gone through 1's compliment (flipping all 32 bits), then add 1 to flipped number (2's compliment). In the result, MSB will be 1.
     * So, to store -3, first 3's 1s compliment and then 2s compliment is taken.
     */

    /**
     * How, NOT(~) works:
     * first, it picks the bit representation of a number which is actually stored in the computer memory. Flips all the bits.
     * Now, if after flipping, MSB is 1, then take 2's compliment of the answer excluding MSB, ie, apply 2's compliment on right 31 bits and put MSB as 1.
     * But if after flipping bits, the MSB comes as 0, then the flipped bits combined is the answer.
     */

    /**
     * SWAP NUMBERS W/O USING 3RD VARIABLE:
     * a=a^b; b=a^b; a=a^b
     * a=a+b; b=a-b; a=a-b;
     */

    /**
     * Checking if ith(0-idx from right(lsb)) bit is set or not
     * Method-1:::: ( (N & (1 << i)) != 0 ) => set, else not-set
     * Method-2:::: ( ((N >> i) & 1) != 0 ) => set, else not-set
     * Method-3:::: ( ((1 << i) | N) == N ) => set, else not-set
     */

    /**
     * SET THE i-th BIT
     * ( (1 << i) | N )
     */

    /**
     * CLEAR THE i-th BIT
     * Approach: Make another operand in such a way that all bits are set except the i-th bit. Then take '&' with N
     * Making operand::: ( ~ ( 1 << i ))        First make an operand with only i-th bit set, and then flip all the bits of it to get the required operand
     * ANSWER: (N & ( ~ ( 1 << i )))
     */

    /**
     * TOGGLE THE i-th BIT
     * ( N ^ ( 1 << i) )
     * Because, bits right and left to 1 in (1<<i) will have zeros. Those zeros when XORed with 0 of N will 0, and when XORed with 1 will give 1. Set bit of new operand will work same.
     */

    /**
     * REMOVE THE LAST SET BIT, ie, UNSET THE RIGHTMOST SET BIT WITHOUT TOUCHING ANY OTHER BITS
     * FACT: Difference in bit representation of N and N-1 is that - in N-1, the bits left of the rightmost set bit of N will be same in N-1 at same index.
     * While all bits from right most set bit of N towards LSB(right) will be flipped, ie, rightmost set bit will be unset and all bits right of rightmost set bit will be set.
     * Example: 16=10000 and 15=01111; 40=101000 and 39=100111; 84=1010100 and 83=1010011
     * So, bits right of rightmost set bits are 0 in N, and 1 in N-1. But we want bits same as of N to the right of rightmost set bit. So we can put & operation.
     * Bits left of rightmost set bit are same in N and N-1. So '&' operation won't change the bits of the result either. Hence,
     * ( N & ( N - 1) )
     */

    /**
     * CHECK IF N IS THE POWER OF 2
     * Bit representation of power of 2 has only 1 set bit as MSB, rest all are unset.
     * Based on above principle, N-1 will flip that set bit to unset, and all unset bit to right of 1 as set.
     * So, taking '&' of both will give zero
     * (( N & ( N - 1 )) == 0 ) yes, else no
     */

    /**
     * GIVEN AN ARRAY OF NUMBERS WHERE EACH NUMBER OCCURS TWICE JUST ONE NUMBER OCCURS ONCE. FIND THE NUMBER THAT OCCURS JUST ONCE
     * Take XOR of all tha elements of the array. The answer is element that occurs just once.
     */

    /**
     * GIVEN AN ARRAY OF NUMBERS WHERE EACH NUMBER OCCURS ""THRICE"" JUST ONE NUMBER OCCURS ONCE. FIND THE NUMBER THAT OCCURS JUST ONCE
     * If we count occurrence of set bit at LSB and move towards MSB iteratively for all numbers, then the numbers which occurs just once instead of triplet,
     * it will create set bit count at idx moving from LSB to MSB, at each idx, not a multiple of 3. This will give an idea to us, bit by bit, for 32-bit number that at which idx total count bit at that idx is not multiple of 3.
     * Generating a number from that information will give the number that occurred just once.
     */
    // Here, it is not mandatory that elements that occur thrice, will be in continuity to form triplets
    private static void findOnceInTriplets1() {  // TC: O(32)*O(N)
        int[] nums = new int[]{1,4,7,3,1,4,7,1,4,7};
        int ans = 0;
        for (int i = 0; i < 31; i++) {  // For 32-bit number, checking for each bit
            int count = 0;  // For tracking total count of set bits at i-th idx for all numbers
            for (int num : nums) {
                if ((num & (1 << i)) != 0) {
                    count++;
                }
            }
            if (count % 3 == 1) {   // Dividing by 3 because other occur in triplets
                ans = ans | (1 << i);
            }
        }
        System.out.println(ans);
    }

    // Better optimized solution. We'll sort the elements. Start from the 1st idx. If it is triplet, then 0th idx element will be equal ti 1st idx element.
    // Similarly, i-th idx element will be (i-1)th idx element if they are in triplet. We'll iterate with jump of 3, jumping from one middle element of triplet to another middle element of triplet.
    // If in case it's not same, then the first iteration falsifying this fact will give the element that occur once, and it will be element at (i-1)th index.
    // This will satisfy even if element will be at 0th index that occurred once.
    // Edge Case: If element will be at last index, then when iteration gets over and no required element is found, then it is for sure at the last index, provided there is at least one element that occurs just once.
    private static void findOnceInTriplets2() {     // TC:: O(N*log2(N) + N/3)
        int[] nums = new int[]{1,4,7,3,1,4,7,1,4,7};
        Arrays.sort(nums);  // O(N*log2(N))
        for (int i = 0; i < nums.length; i = i + 3) {   // O(N/3) - Assuming there are at least one triplet and one element that occurred once.
            if (nums[i] != nums[i - 1]) {
                System.out.println(nums[i - 1]);
            }
        }
        System.out.println(nums[nums.length - 1]);
    }

    /**
     * USING BUCKETS: Count of buckets will be same as count in which arrays are repeating. Here, 3 buckets - ONES, TWOS, THREES.
     * Approach: Start iterating the elements, and pick one at a time. If it occurred once then put it in ONES. If it is occurred twice then put it TWOS and remove it from ONES. If thrice, remove from TWOS & put in THREES.
     * Every bucket will have initial value of 0. It'll be constraint in the question that elements will be POSITIVE ONLY, neither zero nor negative. An element can only be placed in bucket X-th only if:
     * ONES: If element is not in TWOS. We will not go to check in THREES for this bucket because if element is in threes then this means that triplet of element has already been found, and in current iteration there is a possibility of new triplet. If we add an element in ONES, we must make other buckets ZERO, in all those buckets which are into consideration.
     * TWOS: If element is in ONES  -   Remove element from ONES
     * THREES: If element is in TWOS    - Remove element from TWOS  -   It is given that an element either appear once or thrice. No in-between. So, we actually don't need THREES, because if it is in TWOS, itl will be in THREES.
     * ONES = (ONES ^ num[i]) & (~TWOS);        TWOS=(TWOS ^ nums[i]) & (~ONES)
     * Let's analyze for ONES: First we prepare a number that will go inside ONES based on half of the condition that if it is in ONES, it'll be deleted from ONES; Else, it'll be added to ONES. Hre it means the num[i] itself.
     * Also, when a number is deleted from a bucket, the bucket value for that number should be initial value, ie, ZERO. So, if in ONES, num[i] is already there, and we need to put zero, and for reverse condition, XOR is best suited.
     * Next, we need to check for if the number is in twos or not. Remember there might be condition that number could be in ONES and TWOS both, or in any onr at a time, But not in both.
     * So, till now, we are ready to what number to put in ONES using XOR; last decision is based on TWOS. One clear answer is, if XORed number is zero, then anyway the answer that'll be in ONES will be ZERO because of '&'.
     * If it Not in ONES (then XORed number giving the num[i]), then if its not in TWO then number should be in ONES, otherwise it should not be in ONES. Hence, we are taking '&' of negated value of TWOS.
     * Because, if XORed is num[i], then for ONES to be ZERO when num[i] is already in TWOS, can take '&' if the negated value, which will give ZERO.
     * Also, if XORed is num[i], then for ONES to be num[i] when TWOS is ZERO, we want to tae number as it is. We need '&' because of previous case, and only way possible to get a number itself while doing '&' with another number is by making another number ALL ONES.
     *
     * Same concept goes for feeding TWOS.
     *
     * One constraint is also given that elements are in sorted manner
     */
    private static void findOnceInTriplet3() {
        int[] nums = new int[]{1,2,2,2};
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = (num ^ ones) & (~twos);
            twos = (num ^ twos) & (~ones);
        }
        System.out.println(ones);
        /**
         * Explanation: In first iteration, XORed number for ONES will be the num itself, and taking '&' of it with 111...111 will set that num itself in ONES.
         * In second iteration, 2 and 1 will both coexists in ONES, and in TWOS there is process to decide what will be inside TWOS.
         * For TWOS, XORed number is num itself. Now, those bits which are set in XORed number for TWOS, if they ALL are NOT set in ONES as well, then I want them to be unset. SO, XORed has num itself and ONES might have that number.
         * We can
         */
    }

    /**
     * Find two distinct numbers in non-sorted arrays which are appearing once. It is guaranteed that given array has exactly 2 distinct elements. Arrays could be non-sorted, and there is possibility that there could not be any pairs.
     * Brute force approach: Make map of every number and store the occurrence of element. Now, iterate through the map, and find which two of them has count of 1.
     * Optimized approach: Take XOR of every number. This will NOT have paired elements info, but 2 distinct elements which are occurring once will be combined.
     * Now, This XORed number cannot be zero, because for it to be zero, there would not be two different distinct elements. Hence, for sure there will be AT LEAST one set bit in XORed number.
     * There could be more than set bits in XORed number. But finding which one is set will do the work. We'll make 2 buckets, one contains elements which have set bit at chosen idx, while other elements will go to another bucket.
     * We are sure that those 2 distinct elements will lie in different elements. We'll take xor of every element, bucket wise. At last, in 2 XORs, we'll have our required 2 elements.
     */
    private static void findTwoDistinctAmongPairs() {
        int[] arr = new int[]{1,2,3,4,5,2,5,3}; // 1 and 4 are distinct
        long xoredNum = 0;  // took long because below while doing xoredNum-1, if xoredNum happens to be -(2^31), then there will be integer underflow.
        for (int num : arr) {
            xoredNum ^= num;
        }
        int rightmostBit = (int)((xoredNum & (xoredNum - 1)) ^ xoredNum);
        int bucket1 = 0, bucket2 = 0;
        // Let's assume that first set bit from LSB goes to bucket 1
        for (int num : arr) {
            if ((rightmostBit & num) == 0) {
                bucket2 ^= num;
            } else {
                bucket1 ^= num;
            }
        }
        System.out.println(bucket1 + "  " + bucket2);
    }
}
