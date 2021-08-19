package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2693 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[][] input = new int[T][10];
        for (int i = 0; i < T; i++) {
            input[i] = Arrays.stream(br.readLine()
                    .split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(input[i]);
            System.out.println(input[i][7]);
        }
    }
}
