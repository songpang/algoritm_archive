package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[100][100];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            int left = Integer.parseInt(temp[0]);
            int bottom = Integer.parseInt(temp[1]);

            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    paper[bottom + j][left + k] = 1;
                }
            }
        }

        int count = 0;
        for (int[] ints : paper) {
            for (int anInt : ints) {
                if(anInt == 1) count++;
            }
        }

        System.out.println(count);
    }
}
