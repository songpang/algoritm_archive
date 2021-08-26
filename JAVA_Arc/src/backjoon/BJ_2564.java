package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 참외밭
// 2564 일반 구현 문제.
public class BJ_2564 {
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        K = Integer.parseInt(br.readLine());
        int[][] dirDistance = new int[6][2];

        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            dirDistance[i][0] = Integer.parseInt(st.nextToken());
            dirDistance[i][1] = Integer.parseInt(st.nextToken());
        }

        // 1 2 3 4
        // 동서남북
        int rowMax = 0;
        int rowIdx = 0;
        int colMax = 0;
        int colIdx = 0;
        for (int i = 0; i < dirDistance.length; i++) {
            if (dirDistance[i][0] <= 2) {
                if (rowMax < dirDistance[i][1]) {
                    rowMax = dirDistance[i][1];
                    rowIdx = i;
                }
            } else {
                if (colMax < dirDistance[i][1]) {
                    colMax = dirDistance[i][1];
                    colIdx = i;
                }
            }
        }

        int whole = rowMax * colMax;
        rowMax = dirDistance[(rowIdx + 3) % 6][1];
        colMax = dirDistance[(colIdx + 3) % 6][1];
        int smallBox = rowMax * colMax;
        System.out.println((whole - smallBox) * K);
    }
}
