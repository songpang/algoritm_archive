package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_18442 {
    static int V, P;
    static long L, min;
    static long[] village;
    static long[] resultArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력부
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        L = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());

        village = new long[V];
        for (int i = 0; i < V; i++) {
            village[i] = Long.parseLong(st.nextToken());
        }

        // 동작부
        min = Long.MAX_VALUE;
        combination(0, 0, new long[P]);

        // 출력부
        StringBuilder sb = new StringBuilder();
        for (long p : resultArr) {
            sb.append(p).append(" ");
        }

        System.out.println(min);
        System.out.println(sb);
    }

    // 문제에 제시된 대로 거리를 구하는 메서드
    public static long getDistance(long a, long b) {
        long abs = Math.abs(a - b);
        return Math.min(abs, L - abs);
    }

    public static void combination(int start, int count, long[] output) {
        if (count == P) {
            // V개 중 P개를 뽑았으면
            long result = 0;
            for (int i = 0; i < V; i++) {
                long localMin = Long.MAX_VALUE;
                for (int j = 0; j < P; j++) {
                    // 각 마을을 돌면서 comb로 뽑은 경찰서까지의 거리의 최소값을 저장
                    localMin = Math.min(localMin, getDistance(village[i], output[j]));
                }
                result += localMin;
                if (result >= min) {
                    return;
                }
            }
            if (result < min) {
                min = result;
                resultArr = output.clone();
            }
            return;
        }

        for (int i = start; i < V; i++) {
            output[count] = village[i];
            combination(i + 1, count + 1, output);
        }
    }
}
