package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5604 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        long A = Long.parseLong(st.nextToken());
//        long B = Long.parseLong(st.nextToken());

        String A = st.nextToken();
        String B = st.nextToken();

        long[] dp = new long[20];
        dp[0] = 45;

        for (int i = 1; i < 15; i++) {
            dp[i] = dp[i - 1] * 10 + 45 * (long) Math.pow(10, i);
        }

        int bSize = B.length();
        int aSize = A.length();

        long result = 0;
        int idx = 0;

        while(bSize > 1) {
            int temp = B.charAt(idx) - '0';
            long mid = 0;
            for (int i = 1; i < temp; i++) {
                mid += i * (long) Math.pow(10, bSize - 1);
            }
            if(mid == 0) mid = 1;
            result += dp[bSize - 2] * temp;

            bSize--;
        }


        System.out.println(result);


        // 각 자리수를
    }
}
