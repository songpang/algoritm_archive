package programmers;

public class PG_TriSnail {
    public static void main(String[] args) {
        solution(6);
    }

    public static int[] solution(int n) {
        int maxNumber = n * (n + 1) / 2;
        int[] answer = new int[maxNumber];
        int[][] snail = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                snail[i][j] = -1;
            }
        }

        int K = 1;
        int i = 0, j = 0;

        while( K < maxNumber) {
            while(i < n-1 && snail[i+1][j] < 0) {
                snail[i][j] = K;
                i++; K++;
            }
            while(j<n-1 && snail[i][j+1] < 0) {
                snail[i][j] = K;
                j++; K++;
            }
            while(i > 0 && j > 0 && snail[i-1][j-1] < 0) {
                snail[i][j] = K;
                i--; j--; K++;
            }
        }
        snail[i][j] = K;
        int count = 0;
        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                if(snail[k][l] != -1) {
                    answer[count] = snail[k][l];
                    System.out.println(answer[count]);
                    count++;
                }
            }
        }

        return answer;
    }


}
