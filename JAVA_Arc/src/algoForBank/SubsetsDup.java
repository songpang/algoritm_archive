package algoForBank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 중복을 허용하지 않는 Subset
// EX ) 1, 1, 1, 2, 3, 4 같은 경우
// 그냥 Subset은 3개의 1을 다르게 보고 subset 생성.
public class SubsetsDup {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
