package kk.twopointerslidingwin;

import java.util.HashMap;
import java.util.Map;

public class Examples {
    public static void main(String[] args) {
        pickCards();
        maxSubstrLen();
        maxSubstrLen2();
    }

    /**
     * We have been given an array of N cards each having number, might be unsorted, from where we have to pick 4 cards. Combination of these 4 cards can only be made from cards on extremes.
     * That is, 4 from left and 0 from right, OR 3 from left and 1 from right, OR 2 from left and 2 from right, OR .....; where direction ar at the ends of the deck.
     * Deck will have at least k cards.
     */
    private static void pickCards() {// tc: O(2*K), One 'K' from for loop, another from while loop. SC: O(1)
        // Given
        int[] deck = {6,2,3,4,7,2,1,7,1};
        int k = 4;

        // Solution:
        int maxFromLeft = k - 1, maxFromRight = deck.length, windowSum = 0, maxSum = 0;

        for (int i = 0; i <= maxFromLeft; i++) {
            windowSum += deck[i];
        }
        maxSum = windowSum;
        // Above for loop already calculated the sum for case where we take all k cards from the left. So, next case will be k-1 cards from left.

        while (maxFromLeft >= 0) {
            windowSum -= deck[maxFromLeft];
            maxFromLeft--;
            maxFromRight--;
            windowSum += deck[maxFromRight];
            maxSum = Math.max(maxSum, windowSum);
        }
        System.out.println(maxSum);
    }

    /**
     * maximum length of substring having all unique characters
     * TC: If we don't consider making the substring which is itself a O(N) TC, then this algo has O(N^2) complexity. Not a good approach. We can do it better.
     */
    private static void maxSubstrLen() {
        // Given:
        String str = "cadbzabcd";

        // Solution:
        Map<Character, Integer> charFreq = new HashMap<>();
        int l = 0, r = 0, maxLen = 0;
        String substr = "";

        while (r < str.length()) {
            if (charFreq.getOrDefault(str.charAt(r), 0) == 0) {
                charFreq.put(str.charAt(r), 1);
//                maxLen = Math.max(maxLen, r - l +1);
                if(maxLen < r - l + 1) {
                    maxLen = r - l + 1;
                    substr = str.substring(l, r+1);   // (r+1)th char is not included.
                }
                r++;
            } else {    // So, if we are here, means we have a repeating char in str at index r, but it has not been the part of substring in context, ie substr[l,r)
                // Hence, to find another iteration, we'll start again, by moving l forward by 1, and then checking from the l to end of string again, for possibility of maxLength.
                charFreq.put(str.charAt(l), 0);
                l++;
                r = l;
            }
        }
        System.out.println(maxLen);
        System.out.println(substr);
        // Above could have been achieved by 2 nested for loop, where outer loop is of l[0,last char of str], and inner loop r[l, last str, char],
        // but breaking inner when duplicate char occurs, and starting again.
    }

    /**
     * Better approach: Since, we have seen above that when r-th is repeated, we have simply moved l forward by 1.
     * Ideally, we should have moved l to 1 right of that place where char at r-th idx char has already been occurred in the substring in context.
     * So, we need to maintain the indexes in hasMap.
     * TC: O(2N) == O(N), because r is moving just once across str length. While l can maximum move till r. Here, we have not considered finding the substring which is O(N) as well at max.
     * SC: O(N) at worse, making hashmap, where each character is unique in the given string.
     */
    private static void maxSubstrLen2() {
        // Given:
        String str = "cadbzabcd";

        // Solution:
        Map<Character, Integer> charIdxMap = new HashMap<>();
//        for(Map.Entry<Character, Integer> entry : charIdxMap.entrySet()) {
//            entry
//        }

        int l = 0, r = 0, maxLength = 0;
        String substr = "";

        while (r < str.length()) {
            if (charIdxMap.getOrDefault(str.charAt(r), -1) != -1) {
                if (charIdxMap.get(str.charAt(r)) >= l) {
                    l = charIdxMap.get(str.charAt(r)) + 1;
//                    charIdxMap.put(str.charAt(r), r);
//                    if (maxLength < r - l + 1) {
//                        maxLength = r - l + 1;
//                        substr = str.substring(l, r + 1);
//                    }
//                } else {
//                    charIdxMap.put(str.charAt(r), r);
//                    if (maxLength < r - l + 1) {
//                        maxLength = r - l + 1;
//                        substr = str.substring(l, r + 1);
//                    }
                }
            }
            charIdxMap.put(str.charAt(r), r);
            if (maxLength < r - l + 1) {
                maxLength = r - l + 1;
                substr = str.substring(l, r + 1);
            }
            r++;
        }
        System.out.println(maxLength);
        System.out.println(substr);
    }

    // Given an array of 1's and 0's. We need to find subarray size of maximum length which contains 1's, or at max can be made to subarray of 1's by flipping at max 2 0's
    // BRUTE FORCE: TC: O(N^2); SC: O(1)
    private static void maxOnes1() {
        // GIVEN:
        int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;  // max count of 0's allowed to flip.

        // SOLUTION:
        int zeroCount = 0, maxLength = 0;
        for (int i = 0; i <= arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[j] == 0) {
                    zeroCount++;
                }
                if (zeroCount <= k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                } else {
                    zeroCount = 0;
                    break;
                }
            }
        }
    }

    // BETTER APPROACH: TC: O(N) + O(N); SC: O(1)
    private static void maxOnes2() {
        // GIVEN:
        int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        // SOLUTION:
        int l = 0, r = 0, zerosCount = 0, maxLength = 0;
        while (r < arr.length) {
            if (arr[r] == 0) {
                zerosCount++;
            }
            while (zerosCount <= k) {
                if (arr[l] == 0) {
                    zerosCount--;
                }
                l++;
            }
            if (zerosCount <= k) {
                maxLength = Math.max(maxLength, r - l + 1);
            }
            r++;
        }
        System.out.println(maxLength);
    }

    // BET APPROACH: by removing the inner while loop. In this, once we find length of sub-array is max till that iteration, we will not reduce sub-arr length less than max.
    // We'll only increase length when zerosCount<=k
    private static void maxOnes3() {    // TC: O(N); SC: O(1)
        // Given:
        int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        // SOLUTION:
        int l = 0, r = 0, zerosCount = 0, maxLength = 0;
        while(r < arr.length) {
            if (arr[r] == 0) {
                zerosCount++;
            }
            if (zerosCount > k) {
                if (arr[l] == 0) {
                    zerosCount--;
                }
                l++;
            }
            if (zerosCount <= k) {
                maxLength = Math.max(maxLength, r - l + 1);
            }
        }
        System.out.println(maxLength);
    }

    /**
     * Similar question: Given a string of length N made up of characters. Find the length of max substring where all the elements are same. Also, if needed, we can toggle at most 2 characters to get maximum same character substring.
     */
    // Brute force: make freq array of 26 characters, initialize with 0; initialize most frequent character count variable with 0; also the maxlength. Using nested loops, maxFreq=max(maxFreq, freq[j]).
    // changes req to make substring of maxFreq character = j-i+1-maxFreq, and if this change<=k, then update the maxLength. TC:O(N^2)
    // Below approach: TC O(N), SC O(26)
    private static void maxSameCharSubstrWithMax2CharToggles() {
        // GIVEN:
        String str = "AABABBAC";
        int k = 2;

        // Solution:
        int[] charFreq = new int[26];
        int l = 0, r = 0, maxFreq = 0, maxLength = 0;
        while(r < str.length()) {
            charFreq[str.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, charFreq[str.charAt(r)]);
            if (r - l + 1 - maxFreq > k) {  // If this had been while loop, then total TC: O(2N)*O(26). Also, if we remove while loop, we should also remove the for loop of 26 iterations, because
                // Trick is we don't want to minimize our max freq variable to get better result, ie. if we get result for max freq 3 we will continue to look for max freq greater than 3 if it exists and
                // ignore freq less than equal 3. This will eliminate need of freq map scan and also remove while loop if we want to look for better max length.
                charFreq[str.charAt(l)]--;
//                maxFreq = 0;
//                for (int i = 0; i < charFreq.length; i++) {
//                    maxFreq = Math.max(maxFreq, charFreq[i]);
//                }
                l++;
            }
            if (r - l + 1 - maxFreq <= k) {
                maxLength = Math.max(maxLength, r - l + 1);
            }
        }
        System.out.println(maxLength);
    }
    /**
     * FRUITS IN BASKETS: Given an array of N fruits of type 1,2,3,4. And, given only 2 baskets. We need to fill the baskets with maximum fruits, based on below conditions.
     * 1 basket can only have one type of fruit, and cannot have more than one type.
     * Once we start picking fruits for a given basket, we cannot skip few fruits, to jump to another range of fruits. Picking should be continuos.
     * A basket can have any type of fruit, but only one type of fruit is allowed in one basket.
     * This problem boils down to finding maximum length sub array where sum of count of any 2 fruits type is maximum, and in-between those fruits,
     * there shouldn't be any fruit of other two types.
     *
     * Another type of question that can be formed: given a string of characters, we have to find size of largest substring in which there will be atmost k distinct characters.
     */
    // BRUTE FORCE: Maintain a set DS. Find all the sub arrays, and while finding each sub array put that fruit in set only if set has < two types of fruits, such that set will have at max only two types of fruits.
    // Maintain maxLength on every put. Once the third type of fruit encounters, break out of the inner loop, and then start outer loop from next element.
    // BETTER SOLUTION: using 2-pointers and sliding window
    private static void pickFruits() {
        // Given:
        int[] arr = {3,3,3,1,2,1,1,2,3,3,4};
        int k = 2;  // basket count

        // Solution:
        int l = 0, r = 0, maxLength = 0;
        Map<Integer, Integer> fruitSet = new HashMap<>();
        while (r < arr.length) {
            fruitSet.put(arr[r], fruitSet.getOrDefault(arr[r], 0) + 1);
            if (fruitSet.size() > k) {
                fruitSet.put(arr[l], fruitSet.get(arr[r]) - 1);
                if(fruitSet.get(arr[r]) == 0) {
                    fruitSet.remove(arr[r]);
                }
                l++;
            }
            if (fruitSet.size() <= k) {
                fruitSet.put(arr[r], fruitSet.getOrDefault(arr[r], 0) + 1);
                maxLength = Math.max(maxLength, r - l + 1);
            }
            r++;
        }
        System.out.println(maxLength);
    }

    // Number of substring containing all 3 characters. No other characters are included in the main given string apart from 'a', 'b', 'c'

    // BRUTE FORCE: VERY EXPENSIVE with TC:O(N^2) and SC:O(1)
    private static void maxSubstrLenWithMax3DistinctChars1() {
        // Given:
        String str = "bbacba";
//        int k = 3;  // number of distinct characters.

        // Solution:
        int[] charFreq = {0, 0, 0};
        int count = 0;

        for(int i = 0; i < str.length(); i++) {
            charFreq = new int[] {0, 0, 0};
            for (int j = i; j < str.length(); j++) {
                charFreq[str.charAt(j) - 'a'] = 1;
                if (charFreq[0] + charFreq[1] + charFreq[2] == 3) {
//                    count++;  // This will start increasing from place where j first satisfies condition, till when j goes to an end, for a given i.
                    count = count + 1 + (str.length() - 1 - j); // once all 3 chars are found in the substr, then appending characters further in the found string will also contribute to the answers, till all characters to the last are added.
                    break;  // This statement is to stop redundant j's iteration, only written when above line is included.
                }
            }
        }
        System.out.println(count);
    }

    // **************       THIS IS WRONG APPROACH      ****************
    private static void maxSubstrLenWithMax3DistinctChars2() {
        // Given:
        String str = "bbacba";
        int k = 3;  // number of distinct characters.

        // Solution:
        int l = 0, r = 0, maxCount = 0;

        Map<Character, Integer> charFreq = new HashMap<>();
        while (r < str.length()) {
            charFreq.put(str.charAt(r), charFreq.getOrDefault(str.charAt(r), 0) + 1);
            if (charFreq.size() > k) {
                charFreq.put(str.charAt(l), charFreq.get(str.charAt(l)) - 1);
                if (charFreq.get(str.charAt(l)) == 0) {
                    charFreq.remove(str.charAt(l));
                }
                l++;
            }
            if (charFreq.size() <= k) {
                charFreq.put(str.charAt(r), charFreq.getOrDefault(str.charAt(r), 0) + 1);
                if (charFreq.size() == k) {
                    maxCount++;
                }
            }
            r++;
        }
        System.out.println(maxCount);
    }

    // This is variation to brute force but less expensive and optimized. Here we look for min sub-str that satisfies condition as well as that sub-str ends at idx i.
    // So all chars before the start of this valid substring will also contribute to the valid case. In brute fore, we were looking to the right.
    private static void maxSubstrLenWithMax3DistinctChar3() {
        // GIVEN
        String str = "bbacba";
        int k = 3;  // number of distinct characters

        // Solution:
        int[] charLastFoundIdx = {-1, -1, -1};
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            charLastFoundIdx[str.charAt(i) - 'a'] = i;
            if (charLastFoundIdx[0] > -1 && charLastFoundIdx[1] > -1 && charLastFoundIdx[2] > -1) {
                // We can omit this check because, when count is increasing, we are finding MIN. Even if there is at least one -1 value, so count = count + 1 - 1 == count itself.
                // If this satisfies, this means we have found a sub-string with all 3 characters. This could not be smallest.
                // At this point, the least value among of the element in the charIdx array can be considered as the start of IDX smallest sub-string to IDX 'i' if we had been given str till idx 'i' only.
                // Every character before this least idx if prepended with this min-sized sub-string will add 1unit to the total count. So,
                count = count + 1 + Math.min(charLastFoundIdx[0], Math.min(charLastFoundIdx[1], charLastFoundIdx[2]));
            }
        }
        System.out.println(count);
    }

    // count number of Binary subarrays with sum == k, for given binary array
    private static void binarySubarraySumEqualsGoal() {
        // Given
        int[] arr = {1,0,0,1,1,0};
        int goal = 2;

        // Solution: We need to find the count of subarrays for a given condition. So, sliding window will be used. Second, in sliding window, the goal is defined as range, but not as exact goal.
        // So, required answer where count of subarrays with sum of element as K, is equal to (count of sub array with elements sum <=k) - (count of subarrays with element sum <= k-1)
        System.out.println(binarySubarraySumEqualsGoalCalc(arr, goal) - binarySubarraySumEqualsGoalCalc(arr, goal - 1));
    }
    private static int binarySubarraySumEqualsGoalCalc(int[] arr, int goal) {
        if (goal < 0 ) {    // Edge case where we call this method with goal as originalGoal-1, where original goal could be 0.
            return 0;
        }

        int l = 0, r = 0, sum = 0, count = 0;
        while (r < arr.length) {
            sum += arr[r];

            while (sum > goal) {    // We used while instead of if because we have to check for every possible case, not just when it's better than last better case.
                sum -= arr[l];
                l++;
            }

//            if (sum <= goal) {
                count = count + (r - l + 1);
//            }
            r++;
        }
        return count;
    }

    // Count number of subarrays where count of odd numbers in the subarray is exactly equal to goal == k
    private static void oddCountsEqualsKinSubarray() {
        // Given
        int[] arr = {1,1,2,1,1};
        int goal = 3;

        // Solution: Same as above case. Only difference is we need to consider the odd as 1 and even as 0; then sum of elements in subarray will be count of odds in that sub array.
        System.out.println(oddCountsEqualsKinSubarrayCalc(arr, goal) - oddCountsEqualsKinSubarrayCalc(arr, goal - 1));
    }
    private static int oddCountsEqualsKinSubarrayCalc (int[] arr, int goal) {
        if (goal < 0 ) {    // Edge case where we call this method with goal as originalGoal-1, where original goal could be 0.
            return 0;
        }

        int l = 0, r = 0, sum = 0, count = 0;
        while (r < arr.length) {
            sum += arr[r] % 2;

            while (sum > goal) {    // We used while instead of if because we have to check for every possible case, not just when it's better than last better case.
                sum -= arr[l] % 2;
                l++;
            }

//            if (sum <= goal) {
            count = count + (r - l + 1);
//            }
            r++;
        }
        return count;
    }

    // Find the count of sub arrays in which count of distinct elements in sub array is equals to K.
    private static void distinctDigitsCountInSubarrayEqualsK() {
        // Given
        int[] arr = {2,1,1,1,3,4,3,2};
        int k = 3;

        // Solution: Fins count where condition <= k-1, and subtract it from count of subarrays where condition <= k
        System.out.println(distinctDigitsCountInSubarrayEqualsKCalc(arr, k) - distinctDigitsCountInSubarrayEqualsKCalc(arr, k - 1));
    }
    private static int distinctDigitsCountInSubarrayEqualsKCalc(int[] arr, int k) {
        if (k <= 0) {
            return 0;
        }

        int l = 0, r = 0, count = 0;
        Map<Integer, Integer> digitFreq = new HashMap<>();
        while (r < arr.length) {
            digitFreq.put(arr[r], digitFreq.getOrDefault(arr[r], 0) + 1);

            while (digitFreq.size() > k) {
                digitFreq.put(arr[l], digitFreq.get(arr[l]) - 1);
                if (digitFreq.get(arr[l]) == 0) {
                    digitFreq.remove(arr[l]);
                }
                l++;
            }

            count = count + (r - l + 1);
            r++;
        }
        return count;
    }

    // Return A SUBSTRING from the given string 'str' which is of minimum length, having all the characters which are present in another give string 't'. It might be possible that a characters appear more than once in 't'.
    // In that case, we have to return substring from 'str' which at least matches the count of every character in the string 't'. All characters from 't' should be present in the substring of 'str'.

    // Better than brute (where we start by finding all the substrings and then compare the cardinality of each character from substring and string 't', such that such cardinality of all characters from substring is >= cardinality of all characters from str 't'
    private static void minimumWindowSubstring1() { // TC: O(N^2); SC: O(256)
        // Given:
        String str = "ddaaabbca", t = "abcb";

        // Solution:
        int minLen = Integer.MAX_VALUE, startIdx = -1;

        for (int i = 0; i < str.length(); i++) {
            int count = 0;
            int[] charFreq = new int[256];
            for (int j = 0; j < t.length(); j++) {
                charFreq[t.charAt(j) - 'a']++;
            }

            for (int j = i; j < str.length(); j++) {
                if (charFreq[str.charAt(j) - 'a'] > 0) {
                    count++;
                }
                charFreq[str.charAt(j) - 'a']--;

                if (count == t.length()) {
                    if (j - i + 1 < minLen) {
                        minLen = j - i + 1;
                        startIdx = i;
                        break;
                    }
                }
            }
        }
        System.out.println(str.substring(startIdx, startIdx+minLen));
    }

    private static void minimumWindowSubstring2() { // TC: O(2*str.length())+O(t.length()); SC: O(256)
        // Given:
        String str = "ddaaabbca", t = "abcb";

        // Solution:
        int[] charFreq = new int[256];
        int l = 0, r = 0, minLen = Integer.MAX_VALUE, startIdx = -1, count = 0;

        for (int i = 0; i < t.length(); i++) {
            charFreq[t.charAt(i) - 'a']++;
        }

        while (r < str.length()) {
            if (charFreq[str.charAt(r) - 'a'] > 0) {
                count++;
            }
            charFreq[str.charAt(r) - 'a']--;

            while (count == t.length()) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    startIdx = l;
                }
                charFreq[str.charAt(l) - 'a']++;

                if (charFreq[str.charAt(l) - 'a'] > 0) {
                    count--;
                }
                l++;
            }
            r++;
        }
        if (startIdx != -1) {
            System.out.println(str.substring(startIdx, startIdx + minLen));
        } else {
            System.out.println("");
        }
    }
}
