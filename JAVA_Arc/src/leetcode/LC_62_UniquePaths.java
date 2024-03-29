package leetcode;

public class LC_62_UniquePaths {
    static int[][] DIR = {{0, 1}, {1, 0}};
    static int count;

    public static void main(String[] args) {
        count = uniquePaths(3, 7);
        System.out.println(count);
    }

    public static int uniquePaths(int m, int n) {
        int[][] DP = new int[m][n];
        for (int i = 0; i < m; i++) {
            DP[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            DP[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                DP[i][j] = DP[i-1][j] + DP[i][j-1];
            }
        }

        return DP[m-1][n-1];
    }
}
