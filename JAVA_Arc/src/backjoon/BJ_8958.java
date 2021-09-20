package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int sum = 0;
            String temp = br.readLine();
            int size = temp.length();
            for (int j = 0; j < size; j++) {
                int idx = 1;
                while(j < size && temp.charAt(j) == 'O') {
                    sum += idx;
                    idx++;
                    j++;
                }
            }
            System.out.println(sum);
        }

    }
}
