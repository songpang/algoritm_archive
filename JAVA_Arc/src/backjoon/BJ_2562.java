package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = 0, max = 0;
        for (int i = 1; i <= 9; i++) {
            int input = Integer.parseInt(br.readLine());
            if(input > max) {
                max = input;
                idx = i;
            }
        }

        System.out.println(max);
        System.out.println(idx);
    }
}
