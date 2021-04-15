package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LC_1775 {

    public static void main(String[] args) {
//        System.out.println(minOperations(new int[]{6, 6}, new int[]{1}));
    }

//    public static int minOperations(int[] nums1, int[] nums2) {
//        if (nums1.length * 6 < nums2.length || nums1.length > 6 * nums2.length) {
//            return -1;
//        }
//        int sum1 = IntStream.of(nums1).sum();
//        int sum2 = IntStream.of(nums2).sum();
//        if (sum1 > sum2) {
//            return minOperations(nums2, nums1); // make sure the sum of 1st array <= sum of 2nd one.
//        }
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        int i = 0, j = nums2.length - 1, operations = 0;
//        while (sum2 > sum1) {
//            if (j < 0 || i < nums1.length && 6 - nums1[i] > nums2[j] - 1) {
//                sum1 += 6 - nums1[i++];
//            }else {
//                sum2 -= nums2[j--] - 1;
//            }
//            ++operations;
//        }
//        return operations;
//    }

    //Second way
    public int minOperations(int[] nums1, int[] nums2) {
        if (nums1.length * 6 < nums2.length || nums1.length > nums2.length * 6) {
            return -1;
        }
        int sum1 = IntStream.of(nums1).sum();
        int sum2 = IntStream.of(nums2).sum();
        if (sum1 > sum2) {
            return minOperations(nums2, nums1); // make sure the sum of 1st array <= sum of 2nd one.
        }
        int[] cnt = new int[6]; // array used to count the increases in nums1 and the decreases in nums2.
        IntStream.of(nums1).forEach(n -> ++cnt[6 - n]);
        IntStream.of(nums2).forEach(n -> ++cnt[n - 1]);
        int i = 5, operations = 0;
        while (sum2 > sum1) {
            while (cnt[i] == 0) { // skip 0 count of increases or decreases.
                --i;
            }
            sum1 += i; // located current biggest increase or decrease.
            --cnt[i]; // deduct the count.
            ++operations; // increase the operation counter.
        }
        return operations;
    }
}
