package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PG_CarryGoldSilver {
    @Test
    public void test() {
        int[] g = {70, 70, 0};
        int[] s = {0, 0, 500};
        int[] w = {100, 100, 2};
        int[] t = {4, 8, 1};
        Assertions.assertEquals(499, solution(90, 500, g, s, w, t));
    }

    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = (long) (10e5 * 4 * 10e9);

        long start = 0;
        long end = (long) 10e5 * 4 * (long) 10e9;

        while (start <= end) {
            long mid = (start + end) / 2;
            long gold = 0;
            long silver = 0;
            long add = 0; // 특정 시간 t 동안 골드와 실버를 한번에 얻을 수 있는 최대 수

            for (int i = 0; i < s.length; i++) {
                long now_g = g[i];
                long now_s = s[i];
                long now_w = w[i];
                long now_t = t[i];

                long move_cnt = mid / (now_t * 2);
                if (mid % (now_t * 2) >= t[i]) move_cnt++; //편도로 1번더 갈 수 있다면 1회 추가

                gold += Math.min(now_g, move_cnt * now_w);
                silver += Math.min(now_s, move_cnt * now_w);
                add += Math.min(now_g + now_s, move_cnt * now_w);
            }

            if (gold >= a && silver >= b && add >= a + b) {
                end = mid - 1;
                answer = Math.min(mid, answer);
            } else {
                start = mid + 1;
            }
        }

        return answer;
    }
}
