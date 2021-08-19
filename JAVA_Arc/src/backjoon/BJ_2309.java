package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2309 {
    static int[] height;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        height = new int[9];
        for (int i = 0; i < 9; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }

        combination(0, 0, 0, new int[7]);
        Arrays.sort(result);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static void combination(int count, int start, int sum, int[] output) {
        if(count == 7) {
            if(sum == 100) {
                result = output.clone();
            }
            return;
        }

        if(sum > 100) {
            return;
        }

        for (int i = start; i < height.length; i++) {
            output[count] = height[i];
            combination(count + 1, i + 1, sum + height[i], output);
        }
    }
}
