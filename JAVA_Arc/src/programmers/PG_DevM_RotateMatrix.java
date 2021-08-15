package programmers;

import java.util.Arrays;

public class PG_DevM_RotateMatrix {
    public static void main(String[] args) {
        solution(6, 6, new int[][]{});
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[][] plate = new int[rows][columns];

        int count = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                plate[i][j] = count++;
            }
        }

        int[] answer = new int[20];
        count = 0;
        for (int[] query : queries) {
            answer[count++] = rotate(plate, query[0] - 1, query[1] - 1, query[2] - 1, query[3] - 1);
        }

        return answer;
    }

    public static int rotate(int[][] plate, int rs, int cs, int re, int ce) {
        int temp = plate[rs][cs];
        int min = Math.min(temp, Integer.MAX_VALUE);

        for (int i = rs; i < re; i++) {
            min = Math.min(plate[i + 1][cs], min);
            plate[i][cs] = plate[i + 1][cs];
        }
        for (int i = cs; i < ce; i++) {
            min = Math.min(plate[re][i + 1], min);
            plate[re][i] = plate[re][i + 1];
        }

        for (int i = re; i > rs; i--) {
            min = Math.min(plate[i - 1][ce], min);
            plate[i][ce] = plate[i - 1][ce];
        }

        for (int i = ce; i > cs; i--) {
            min = Math.min(plate[rs][i - 1], min);
            plate[rs][i] = plate[rs][i - 1];
        }

        plate[rs][cs + 1] = temp;
        return min;
    }

}
