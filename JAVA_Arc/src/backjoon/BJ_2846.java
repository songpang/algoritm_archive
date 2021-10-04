package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 2846 오르막길
// 간단한 구현문제, 아이디에이션은 쉬웠으나 실수로 인해 시간 좀 먹음

public class BJ_2846 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] road = new int[N];

        for (int i = 0; i < N; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }

        int last = -1;
        int result = 0;
        int max = 0;

        int first = road[0];
        for (int i = 1; i < N; i++) {
            if (first < last) {
                result = last - first;
                max = Math.max(max, result);
            }
            if (last >= road[i]) {
                first = road[i];
            }
            last = road[i];
        }

        // 앞이 더 커지는 상황 나오면
        // 그 전까지 구했던 last - first 해주고
        // 현재 값으로 초기화
        max = Math.max(max, last - first);
        System.out.println(max);
    }
}
