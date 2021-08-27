package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2669 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxX = 0;
        int maxY = 0;

        int[][] rect = new int[4][];
        for (int i = 0; i < 4; i++) {
            rect[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            maxX = Math.max(maxX, rect[i][2]);
            maxY = Math.max(maxY, rect[i][3]);
        }

        int[][] colored = new int[maxX + 1][maxY + 1];

        for (int i = 0; i < 4; i++) {
            int[] temp = rect[i];
            for (int j = temp[0]; j < temp[2]; j++) {
                for (int k = temp[1]; k < temp[3]; k++) {
                    colored[j][k] = 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < maxX + 1; i++) {
            for (int j = 0; j < maxY + 1; j++) {
                if(colored[i][j] == 1) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }
}
