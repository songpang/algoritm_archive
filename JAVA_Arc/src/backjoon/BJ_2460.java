package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int totalPP = 0;
        String[] input;

        for (int i = 0; i < 10; i++) {
            input = br.readLine().split(" ");
            totalPP -= Integer.parseInt(input[0]);
            totalPP += Integer.parseInt(input[1]);
            max = Math.max(max, totalPP);
        }

        if(max >= 10000) {
            System.out.println(10000);
        } else {
            System.out.println(max);
        }
    }
}
