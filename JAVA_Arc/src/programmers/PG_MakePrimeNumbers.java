/*
Programmers 소수 만들기
TIPS : 소수 판별할 때 루트값까지만 계산해줘도 판별 가능
 */
package programmers;

public class PG_MakePrimeNumbers {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (isPrimeNumber(nums[i] + nums[j] + nums[k]))
                        answer++;
                }
            }
        }
        return answer;
    }

    public boolean isPrimeNumber(int number) {
        int end = (int) Math.sqrt(number);
        for (int i = 2; i <= end; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

}
