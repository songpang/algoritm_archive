// 언어 : JAVA , 메모리 : 17316 KB , 시간 : 212 ms

package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 1654 랜선자르기
// 이분탐색
/*
   해결하기 위해 필요했던 반례
5 5
1
1
1
1
1

left + 1 < right 에서 걸러졌기 때문에 올바른 정답을 도출하지 않았음.
-> 추가적인 조건문으로 해결
 */
public class BJ_1654_BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lanCable = new int[K];
        for (int i = 0; i < K; i++) {
            lanCable[i] = Integer.parseInt(br.readLine());
        }

        // 먼저 케이블 정렬
        Arrays.sort(lanCable);

        long left = 0;
        long mid = lanCable[0];
        long right = lanCable[K - 1];
        long sum;
        long max = 0;
        if(left + 1 == right) {
            sum = 0;
            for (int i : lanCable) {
                sum += i / mid;
            }
            if(sum >= N) {
                max = mid;
            }
        }

        // 이분탐색 실행.
        while(left + 1 < right) {
            sum = 0;
            for (int i : lanCable) {
                sum += i / mid;
            }
            if(sum >= N) {
                max = mid;
                left = mid;
            } else {
                right = mid;
            }
            mid = (left + right) / 2;
        }

        System.out.println(max);
    }
}
