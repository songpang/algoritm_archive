package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        int modC = C;
        int modN = N;
        while (modN % modC != 0) {
            int temp = modN % modC;
            modN = modC;
            modC = temp;
        }

        int count = 1;
        while(N * count % C != 0) {
            count++;
        }

        System.out.println(modC);
        System.out.println(N * count);
    }
}
