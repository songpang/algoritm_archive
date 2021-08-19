package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1978 {
    public static void main(String[] args) throws IOException {
        int[] primeNumbers = new int[1001];
        primeNumbers[1] = 1;
        for (int i = 2; i <= 500; i++) {
            if (primeNumbers[i] == 0) {
                for (int j = i * 2; j <= 1000; j += i) {
                    primeNumbers[j] = 1;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count = 0;

        for (int i : input) {
            if(primeNumbers[i] != 1) count++;
        }

        System.out.println(count);
    }
}
