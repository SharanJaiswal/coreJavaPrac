package kk.recursion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Basic {
    public static void main(String[] args) {
        printNTimes("Sharan", 5);
        System.out.println("========");
        printLinearly1toN(1, 5);
        System.out.println("========");
        printLinearly1toNBacktrack(5);
        System.out.println("========");
        parametrerizedSum1ToN(5, 0);
        System.out.println("========");
        functionalSum1ToN(5);
        System.out.println("========");
        int[] arr1 = {1,2,3};
        reverseAnArray(arr1, 0);
        System.out.println("========");
        printAllSubsequence(arr1, new ArrayList<>(), 0);
        System.out.println("========");
    }

    private static void printNTimes(String name, int times) {
        if (times == 0) {   // ANCHOR CONDITION: For this condition, function will not invoke further function, but for this anchor condition the function got invoked. Hence, Total invocation is valid times + anchor times.
            return;
        }
        System.out.println(name);
        times--;
        printNTimes(name, times);
    }

    private static void printLinearly1toN(int itr, int n) {
        if (itr > n) {
            return;
        }
        System.out.println(itr);
        printLinearly1toN(++itr, n);    // NEVER SEND itr++ because it'll itr first and then increase its value
    }

    private static void printLinearly1toNBacktrack(int n) {
        if (n == 0) {
            return;
        }
//        printLinearly1toNBacktrack(--n);
        printLinearly1toNBacktrack(n - 1);  // If we send --n then next line here will be using decreased value of n, but we want decreased value in next recursive call, not in this call stack. Hence, we sent n-1
        System.out.println(n);
    }


    private static void parametrerizedSum1ToN(int i, int sum) {
        if (i == 0) {
            System.out.println(sum);    //Here we are printing at the anchor condition
            return;
        }
//        sum += i--;
//        parametrerizedSum1ToN(i, sum);
        parametrerizedSum1ToN(i - 1, sum + i);
    }

    private static int functionalSum1ToN(int i) {
        if (i == 0) {
            return 0;
        }
        return i + functionalSum1ToN( i - 1); // Here we are printing at the first condition, used backtracking of sorts.
    }

    private static long factorial(int n) {
        if (n == 1) {
            return 1L;
        }
        return n * factorial(n - 1);
    }

    private static void reverseAnArray(int[] arr, int i) {
        if (i >= arr.length / 2) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[arr.length - 1 - i];
        arr[arr.length - 1 - i] = temp;
        reverseAnArray(arr, i + 1);
    }

    private static boolean palindrome(String str, int i) {
        if (i >= str.length() / 2) {
            return true;
        }
        if (str.charAt(i) == str.charAt(str.length() - 1 - i)) {
            return palindrome(str, i + 1);
        } else {
            return false;
        }
    }

    private static int fibonacci(int n) {
        if (n == 0 || n == 1) {
//            System.out.println(n);  // We can't print n because this will not print the required pattern, because of below recursive call. For n=4(let), f(2) and f(3) will be called. But f(2)'s call will reach till anchor condition, and then when it'll come back to f(2), then f(3) will be started getting called.
            return n;
        }
        int term = fibonacci(n - 2) + fibonacci(n - 1); // TC: O(2^n) (approximately, not exactly). But exact is 1.6^N
//        System.out.println(term);
        return term;
    }

    // SUBSEQUENCE: A subset that maintains the order but may or may not be composed of contiguous elements.
    private static void printAllSubsequence(int[] orgArr, ArrayList<Integer> arr, int i) {  // TC: O(2^orgArr.length)
        if (i == orgArr.length) {
            System.out.println(arr);
            return;
        }
        arr.add(orgArr[i]);
        printAllSubsequence(orgArr, arr, i + 1);
        arr.remove(Integer.valueOf(orgArr[i]));
        printAllSubsequence(orgArr, arr, i + 1);
    }

    // Printing ALL sub-sequence whose sum is K
    private static void printAllSubsequenceWithSumK(int[] orgArr, int idx, int sum, ArrayList<Integer> arr, int k) {
        // At anchor condition, I'll have one sub-sequence, with sum of elements in it. Hence, we will compare the sum condition at the very last.
        if (idx == orgArr.length) {
            if (sum == k) {
                System.out.println(arr);
            }
            return;
        }
        arr.add(Integer.valueOf(orgArr[idx]));
        sum += orgArr[idx];
        printAllSubsequenceWithSumK(orgArr, idx + 1, sum, arr, k);
        arr.remove(Integer.valueOf(orgArr[idx]));
        sum -= orgArr[idx];
        printAllSubsequenceWithSumK(orgArr, idx + 1, sum, arr, k);
    }

    // Print ANY ONE sub-sequence whose sum is k.
    private static boolean printAnySubSequenceWithSumK(int[] orgArr, int idx, int k, ArrayList<Integer> arr, int sum) {
        if (idx == orgArr.length) {
            if (sum == k) {
                System.out.println(arr);
                return true;
            }
            return false;
        }
        arr.add(Integer.valueOf(orgArr[idx]));
        sum += orgArr[idx];
        if (printAnySubSequenceWithSumK(orgArr, idx + 1, k, arr, sum)) {
            return true;
        }
        arr.remove(Integer.valueOf(orgArr[idx]));
        sum -= orgArr[idx];
        if (printAnySubSequenceWithSumK(orgArr, idx + 1, k, arr, sum)) {
            return true;
        }
        return false;
    }

    // Count the subsequences whose sum is K
    private static int countAllSubSequencesWithSumK(int[] orgArr, int idx, int k, int sum) {
        if (idx == orgArr.length) {
            if (sum == k) {
                return 1;
            }
            return 0;
        }
        sum += orgArr[idx];
        int left = countAllSubSequencesWithSumK(orgArr, idx + 1, k, sum);
        sum -= orgArr[idx];
        int right = countAllSubSequencesWithSumK(orgArr, idx + 1, k, sum);
        return left + right;
    }

    // Check if array is sorted or not
    private boolean isArraySorted(int[] arr, int idx) {
        if (idx == arr.length - 1) {
            return true;
        }
        if (arr[idx] <= arr[idx + 1]) {
            return isArraySorted(arr, ++idx);
        }
        return false;
    }

    // Linear search with recursion
    private int linearSearch1(int[] arr, int target, int idx) {
        if (idx == arr.length) {
            return -1;
        }
        return arr[idx] == target ? idx :  linearSearch1(arr, target, idx + 1);
    }

    // Check with Linear search with recursion
    private boolean linearSearch2(int[] arr, int target, int idx) {
        if (idx == arr.length) {
            return false;
        }
        return (arr[idx] == target) || linearSearch2(arr, target, idx + 1);
    }

    // All target indexes using recursive linear search
    private ArrayList<Integer> linearSearch3(int[] arr, int target, int idx, ArrayList<Integer> ans) {
        if (idx == arr.length) {
            return ans;
        }
        if (arr[idx] == target) {
            ans.add(idx);
        }
        return linearSearch3(arr, target, ++idx, ans);
    }

    // All target indexes using recursive linear search
    private ArrayList<Integer> linearSearch4(int[] arr, int target, int idx) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (idx == arr.length) {
            return ans;
        }
        if (arr[idx] == target) {
            ans.add(idx);
        }
        ans.addAll(linearSearch4(arr, target, ++idx));
        return ans;
    }

    // Pivot idx in rotated array using recursion. Original array will any case will NOT be sorted. Rotated array has at least 2 elements. We have explicitly added case array with 1 element count.
    private int findPivot(int[] arr, int start, int end) {  // start=0, end=arr.length-1
        if (arr.length == 0) {  // This is just a normal check
            return -1;
        }
        if (start == end) { // covers case where arr of 1 is in context. Also, an anchor condition to halt the search.
            return end; // not returning start because at the last recursive call where start>end the end will have the correct index answer.
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] > arr[mid + 1]) {
            return mid;
        } else if (arr[mid] < arr[mid - 1]) {
            return mid - 1;
        } else if (arr[mid] > arr[start]) {
            return findPivot(arr, mid + 1, end);
        } else {
            return findPivot(arr, start, mid - 1);
        }
    }

    // Find target in rotated array
    private int findTargetInRotated(int[] arr, int target, int start, int end) {
        // Assuming min size of original array is 2 and is rotated, ie, non sorted at all.
        int mid = start + (end - start);
        if (arr[mid] == target) {
            return mid;
        } else
// So the idea from here is we can think easily to locate target in the sorted half of the arr in context. For non-sorted part, next iteration/recursion-call will take care.
            if (arr[start] <= arr[mid]) {   // pick sorted half
            if (target >= arr[start] && target <= arr[mid]) {   // easy to check in sorted half
                findTargetInRotated(arr, target, start, mid);
            } else {    // leave difficult unsorted half for next iteration/recursion. In next iteration, array in context will be rotated only, guranteed.
                findTargetInRotated(arr, target, mid + 1, end);
            }
        } else {    // else if (arr[start] > arr[mid])
            if (arr[mid] <= target && target <= arr[end]) {
                findTargetInRotated(arr, target, mid, end);
            } else {
                findTargetInRotated(arr, target, start, mid - 1);
            }
        }
        return -1;
    }


}
