package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test = 1; test <= 10; test++) {
            br.readLine();
            String[] input = br.readLine().split(" ");
            int[] result = new int[8];

            for (int i = 0; i < 8; i++) {
                result[i] = Integer.parseInt(input[i]);
            }

            int count = 0;
            int pl = 1;

            while (result[(count + 7) % 8] > 0) {
                result[count++] -= pl++;
                if (pl == 6) {
                    pl = 1;
                }
                if (count == 8) {
                    count = 0;
                }
            }

            int[] lastArr = new int[8];
            count = count != 0 ? count - 1 : 7;
            result[count] = 0;

            int j = 0;
            for (int i = count + 1; i < result.length; i++) {
                lastArr[j++] = result[i];
            }

            for (int i = 0; i <= count; i++) {
                lastArr[j++] = result[i];
            }

            System.out.printf("#%d ", test);
            for (int i : lastArr) {
                System.out.print(i + " ");
            }
        }

    }
}
