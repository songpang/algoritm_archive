package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC_1_TwoSum {

    // O(n) 솔루션
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < numbers.length; map.put(numbers[i], ++i)) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]) - 1, i};
            }
        }

        return new int[]{0, 0};
    }

    // 내 풀이 O(n^2)
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length-1; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                if(nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return new int[]{0, 0};
//    }
}
