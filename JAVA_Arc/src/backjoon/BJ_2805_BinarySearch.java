package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 2805 나무 자르기
// 전형적인 이분탐색 문제.
public class BJ_2805_BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] trees = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        long left = 0;
        long right = max;
        long mid = (left + right) / 2;
        long sum;

        long height = 0;
        if(left + 1 == right) {
            System.out.println(0);
            return;
        }

        while(left + 1 < right) {
            sum = 0;
            for (int tree : trees) {
                if(tree > mid) {
                    sum += tree - mid;
                }
            }

            if(sum >= M) {
                height = mid;
                left = mid;
            } else {
                right = mid;
            }
            mid = (left + right) / 2;
        }

        System.out.println(height);
    }
}
