package leetcode;

import java.util.*;

public class LC_Permutations2 {
    static int[] result;
    static List<List<Integer>> answer;
    static Set<List<Integer>> intSet;

    public static void main(String[] args) {
    }

    /*
       중복 Permutation 제거 !!!
    Set은 같은 배열일 경우 같은 값이라고 인지.
    ex ) result = {1,2,3} 이후 set에 add
         result[1] = 0 으로 변경 이후 set에 add
         이 때 set의 size는 1임. result 안의 값만 바뀌었지 result 자체는 바뀌지 않았기
         때문!! 새로운 배열을 {1, 2, 3}생성해서 넣으면 같은 배열이 2개가 들어감
         중복제거 안됨!
         But List는 위 사항에 제약받지 않음. 중복제거 잘됨.

     */
    // 70ms 코드
//    public static List<List<Integer>> permuteUnique(int[] nums) {
//        intSet = new HashSet<>();
//        boolean[] visited = new boolean[nums.length];
//        result = new int[nums.length];
//
//        permutation(visited, nums, 0);
//        return new ArrayList<>(intSet);
//    }
//
//    public static void permutation(boolean[] visited, int[] arr, int count) {
//        if (count == arr.length) {
//            intSet.add(new ArrayList<>(Arrays.asList(Arrays
//                    .stream(result).boxed()
//                    .toArray(Integer[]::new))));
//            return;
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            if (!visited[i]) {
//                visited[i] = true;
//                result[i] = arr[count];
//                permutation(visited, arr, count + 1);
//                visited[i] = false;
//            }
//        }
//    }

    // 4ms 코드
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        if (nums == null || nums.length == 0)
//            return new ArrayList<>();
//        Arrays.sort(nums);
//        List<List<Integer>> finalResult = new ArrayList<>();
//        permuteUniqueRecur(nums, finalResult, new ArrayList<>(), new boolean[nums.length]);
//        return finalResult;
//    }
//
//    private void permuteUniqueRecur(int[] nums, List<List<Integer>> finalResult, List<Integer> currResult, boolean[] used) {
//
//        if (currResult.size() == nums.length) {
//            finalResult.add(new ArrayList<>(currResult));
//            return;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (used[i] || (i > 0 && !used[i - 1] && nums[i] == nums[i - 1])) {
//                continue;
//            }
//            currResult.add(nums[i]);
//            used[i] = true;
//            permuteUniqueRecur(nums, finalResult, currResult, used);
//            used[i] = false;
//            currResult.remove(currResult.size() - 1);
//        }
//    }
}
