package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 12014 주식
// 문제 잘못 이해해서 틀림 -> LIS 문제인 줄 몰랐음
// 100%에서 틀렸습니다가 나옴. ㅜㅜ

public class BJ_12014_LIS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String outputBase = "Case #%d\n%d\n";

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] stock = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                stock[i] = Integer.parseInt(st.nextToken());
            }

            int[] LIS = new int[N];
            LIS[0] = stock[0];
            int lLength = 0;

            for (int i = 0; i < N; i++) {
                if (LIS[lLength] > stock[i]) {
                    int temp = lLength;
                    while (temp > 0 && LIS[temp - 1] > stock[i]) {
                        temp--;
                    }
                    LIS[temp] = stock[i];
                } else if (LIS[lLength] < stock[i]) {
                    LIS[++lLength] = stock[i];
                }
            }

            if (lLength + 1 >= K) {
                System.out.printf(outputBase, t, 1);
            } else {
                System.out.printf(outputBase, t, 0);
            }
        }
    }
}
