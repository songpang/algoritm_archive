package programmers;

import java.util.Arrays;

public class PG_Immigration {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        return binarySearch(n, times);
    }

    public long binarySearch(int n, int[] times) {
        long left = 1, mid = 0;
        long right = (long) times[times.length - 1] * n;
        long answer = Long.MAX_VALUE;

        while (left <= right) {
            mid = (left + right) / 2;

            if(check(n, mid, times)) {
                answer = answer > mid ? mid : answer;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    private boolean check(int n, long mid, int[] times) {
        long amount = 0;
        //이 값을 int로 설정하면 통과할 수 없음.

        for (int i = 0; i < times.length; i++) {
            amount += mid/times[i];
        }

        if (amount>=n) return true;
        else return false;
    }
}
