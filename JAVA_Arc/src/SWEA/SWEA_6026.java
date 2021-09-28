package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_6026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

//        int M = Integer.parseInt(st.nextToken());
//        int N = Integer.parseInt(st.nextToken());

        int M = 7, N = 11;
        // 중복 순열 전체 개수
        long result = (long) Math.pow(M, N);
        System.out.println(result);
        System.out.println(result / 1000000007);
        for (int i = 1; i <= M - 1; i++) {
            result -= (long) Math.pow(i, N) / 1000000007 * combination(M, i);
            System.out.println(result);
        }

        System.out.println(result);
    }

    public static long combination(int n, int r) {
        if (r == 1) return n;
        if (n == r) return 1;
        return combination(n - 1, r - 1) + combination(n - 1, r);
    }
}
