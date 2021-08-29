package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 10163 색종이
// 단순 구현
// 배열 인덱스로 활용하면 더 빠르다.
public class BJ_10163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] board = new int[1001][1001];

        int number = 1;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            for (int j = 0; j < height; j++) {
                for (int k = 0; k < width; k++) {
                    board[y + j][x + k] = number;
                }
            }
            number++;
        }

        int checkNumber = 1;
        while(checkNumber != number) {
            int count = 0;
            for (int i = 0; i < 1001; i++) {
                for (int j = 0; j < 1001; j++) {
                    if (board[i][j] == checkNumber) count++;
                }
            }
            checkNumber++;
            System.out.println(count);
        }
    }
}
