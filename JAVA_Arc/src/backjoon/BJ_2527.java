package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2527 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] coordinate;
        for (int i = 0; i < 4; i++) {
            coordinate = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
