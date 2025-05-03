package kk.twopointerslidingwin;

public class Basic {
    public static void main(String[] args) {

    }

    /**
     * Constant Window Problems.
     */
    private static void windowMaxSum() {
        // Given
        int[] arr = {1,2,3,4,5};
        int k = 2;

        // Solution
        int l = 0, r=k-1, sum = 0;  // currently r is withing window of size k.
        for (int i = 0; i < r; i++) {   // initial window sum
            sum += arr[i];
        }

        while(r < arr.length - 1) {
            sum = Math.max(sum, sum + arr[r]);
            sum -= arr[l];
            l++;
            r++;
            sum += arr[r];
        }
        System.out.println(sum);
    }

    /**
     * IMPORTANT
     * Longest subarray/subsequence/subarray/substring where <condition>. Here answer is non-discontinuous chunk of original answer
     */
    // find longest subarray LENGTH where sum <= K, k==14. EXACT SUBARRAY IS NOT ASKED.
    private static void longestSubArray1() {
        // Given
        int[] arr = {2,5,1,7,10};
        int k = 14;

        // Solution-1:: Brute force approach. TC: O(N^2). Here we are checking every possible subarray.
        int maxLength = 0;
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum = 0;
            for(int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum + arr[j] <= k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                } else {    // Not required but little optimization. Once the sum goes beyond K, then we don't need to check with further arr[j] for given i.
                    break;
                }
            }
        }
        System.out.println(maxLength);
    }

    // Solution-2:: Find valid window. Better approach. TC:O(n+n), because r is increasing and its not the case the for each r the l is getting increased. Its just that at max r increases to N, and l increases to N
    private static void longestSubArray2() {
        // Given
        int[] arr = {2,5,1,7,10};
        int k = 14;

        int l = 0, r = 0, sum = 0, maxLength = 0;
        while(r < arr.length) {
            sum += arr[r];
            while(sum > k) {
                sum -= arr[l];
                l--;
            }
            if(sum <= k) {
                maxLength = Math.max(maxLength, r - l + 1);
            }
            r++;
        }
    }

    // Solution-3:: Optimal Approach. In better approach(above), we are maintaining the valid window for satisfying (sum<=k). Its is good when we want the subarray also.
    // But here it is only asked the maxlength of subarray.
    // So, once we find certain subarray of length Li for valid condition (sum <=k), we only check if we could find subarray of length Lj where Lj>Li
    private static void longestSubarray3() {
        // Given
        int[] arr = {2,5,1,7,10};
        int k = 14;

        // Solution:
        int l = 0, r = 0, sum = 0, maxLength = 0;
        while (r < arr.length) {
            sum += arr[r];
            if (sum > k) {
                sum -= arr[l];
                l--;
            }
            if (sum <= k) {
                maxLength = Math.max(maxLength, r - l - 1);
            }
            r++;
        }
        System.out.println(maxLength);
    }

    /**
     * Find total count of subarray where sum(subarray)==k.
     * This can be achieved by (count subarray with sum<=k) - (count subarray with sum<=k-1)
     */


    /**
     * Finding the shortest window where <condition>
     *     APPROACH: Find any window which satisfies condition, and then try to shrink the window to thew point where it is not further to shink it.
     */
}
