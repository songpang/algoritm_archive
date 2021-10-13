package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17281 {
    static int MAX_ORDER_COUNT = 8;
    static int N, max;
    static int[][] innings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        innings = new int[N][9];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                innings[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = 0;
        permutation(0, new int[8], new boolean[8]);
        System.out.println(max);

    }

    static int scount = 0;

    public static void permutation(int count, int[] output, boolean[] visited) {
        if (count == MAX_ORDER_COUNT) {
            Queue<Integer> orderQ = new LinkedList<>();
            int idx = 0;
            while (orderQ.size() != 9) {
                for (int i = 0; i < MAX_ORDER_COUNT; i++) {
                    if (idx == output[i]) {
                        orderQ.add(i + 1);
                        idx++;
                        break;
                    }
                }
                if (idx == 3) {
                    orderQ.add(0);
                }
            }

            int score = 0;
            for (int i = 0; i < N; i++) { // N개 이닝
                int out = 0;
                int[] curBase = new int[3];

                while (out != 3) {
                    int hitter = orderQ.poll();
                    int hit = innings[i][hitter];

                    if (hit == 0) {
                        out++;
                    } else {
                        for (int j = 2; j >= 0; j--) {
                            if (curBase[j] != 0) {
                                if (j + hit >= 3) { // 2 1 0
                                    score++;
                                } else {
                                    curBase[j + hit] = 1;
                                }
                                curBase[j] = 0;
                            }
                        }
                        if (hit != 4) {
                            curBase[hit - 1] = 1;
                        } else {
                            score++;
                        }
                    }
                    orderQ.offer(hitter);
                }
            }
            max = Math.max(max, score);
            return;
        }

        for (int i = 0; i < MAX_ORDER_COUNT; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[count] = i;
                permutation(count + 1, output, visited);
                visited[i] = false;
            }
        }
    }
}












