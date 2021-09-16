package algoForBank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 숫자열이 주어졌을 때 증가하는 수열을 찾는 문제
// 숫자가 따로 떨어져 있어도 됨 (부분집합으로 생각)
// ex 1 7 4 2 6
// LIS는 1 4 6 // 1 2 6 이 될 수 있음.
public class LongestIncreasingSubsequence_LIS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 숫자의 개수
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] lis = new int[N];
        int size = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = nums[0];
        // 루프를 돌면서 LIS배열의 값이 크면 그 자리에 넣는다
        // 1 2 7 9 10 일 경우
        // target 값이 6이면
        // 1 2 6 9 10 이렇게 7에 들어간다
        // 사실 이렇게 해도 앞에서 구해놨던 최대값은 0이아닌 수의 길이로 유지된다.
        // 즉, 최대길이는 마지막에 0이 아닌 값들의 길이.
        // 그러나 이 방법으로는 최대 LIS의 구성 값들을 구할 수는 없다.
        loop:
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < size; j++) {
                if (lis[j] > nums[i]) {
                    lis[j] = nums[i];
                    continue loop;
                }
            }
            lis[size++] = nums[i];
        }

        System.out.printf("%d\n", size);
    }
}
