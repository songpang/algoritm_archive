package ssafy;

public class FindData {
    public static void main(String[] args) {
        String[] day = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
        int[] date = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        // a 에 월 b에 13 넣어서
        // 금요일인지 확인.
    }

    static long power(int a, int b) {
        long res = 1L;

        while(b > 0) {
            if(a % 2 == 1) {
                res *= a;
            }
            a = a * a;
            b >>= 1;
        }

        return res;
    }

    static int N, R;
    static long[][] dp = new long[N][R];

    static long comb(int n, int r) {
        if(dp[n][r] > 0) {
            return dp[n][r];
        }

        if(r == 0 || n == r) {
            return dp[n][r] = 1;
        }

        return dp[n][r] = comb(n-1, r) + comb(n-1, r-1);
    }

}
