package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PG_Delivery {
//    public static void main(String[] args) {
////        solution(6, new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}, 4);
//        test();
//    }

    // Test코드는 static 일 경우 실행이 안된다?!
    @Test
    public void test() {
//        Assertions.assertEquals(4, solution(6, new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}, 4));
        Assertions.assertEquals(2, solution(2, new int[][]{{1, 2, 2}, {1, 2, 1}}, 1));
    }

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        // 1번에서 시작해서
        // N개의 정점까지 갈 수 있는 최단거리를 구한 후에
        // 그 최단거리가 K이하이면 된다.

        int[] distance = new int[N];
        for (int i = 0; i < N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[0] = 0;

        int[][] adjacent = new int[N][N];
        for (int[] ints : road) {
            int r = ints[0] - 1;
            int c = ints[1] - 1;
            int weight = ints[2];

            adjacent[r][c] = adjacent[r][c] != 0 ? Math.min(adjacent[r][c], weight) : weight;
            adjacent[c][r] = adjacent[c][r] != 0 ? Math.min(adjacent[c][r], weight) : weight;
        }

        // 이렇게 하면 만약 3이라는 정점이
        // 아주 멀리 떨어져있을 때 3의 거리를 구하지 못한다....
        // 다시 하자.. ㅠㅠ
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (adjacent[i][j] != 0 && distance[j] > distance[i] + adjacent[i][j]) {
                    distance[j] = distance[i] + adjacent[i][j];
                }
            }
        }

        for (int i : distance) {
            if (i <= K) {
                answer++;
            }
        }
        System.out.println(answer);
        return answer;
    }


}
