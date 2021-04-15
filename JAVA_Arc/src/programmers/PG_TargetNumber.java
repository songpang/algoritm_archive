package programmers;

import java.util.Arrays;

public class PG_TargetNumber {
    static int COUNT = 0;
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public static int solution(int[] numbers, int target) {

        dfs(0, numbers, 0, target);
        return COUNT;
    }

    public static void dfs(int index, int[] numbers, int result, int target) {
        if(index == numbers.length) {
            if(result == target) {
                COUNT++;
            }
            return;
        }
        dfs(index+1, numbers, result + numbers[index], target);
        dfs(index+1, numbers, result - numbers[index], target);
    }
}
