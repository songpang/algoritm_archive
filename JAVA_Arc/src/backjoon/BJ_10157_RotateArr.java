package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 10157
// 자리배정
// 배열 돌리기 문제.
public class BJ_10157_RotateArr {
    static int C, R, K;
    static int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        int[][] concert = new int[R][C];

        if (K > C * R) {
            System.out.println(0);
        } else {
            for (int i : find(K, concert)) {
                System.out.print(i + " ");
            }
        }
    }

    // 가로 C 세로 R
    public static int[] find(int K, int[][] concert) {
        int x = R - 1;
        int y = 0;

        int count = 1;
        while (true) {
            for (int i = 0; i < 4; i++) {
                while (x >= 0 && y >= 0 && x < R && y < C && concert[x][y] == 0) {
                    concert[x][y] = count++;
                    if (count == K + 1) {
                        return new int[]{ y + 1, Math.abs(x - R)};
                    }
                    x += DIR[i][0];
                    y += DIR[i][1];
                }
                x -= DIR[i][0];
                y -= DIR[i][1];
                x += DIR[(i + 1) % 4][0];
                y += DIR[(i + 1) % 4][1];
            }
        }


    }
}
