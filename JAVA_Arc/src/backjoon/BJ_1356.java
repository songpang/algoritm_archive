package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 유진수 1356
// 스트링 단순 구현

public class BJ_1356 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String n = br.readLine();
        char[] numbers = n.toCharArray();

        int size = n.length();
        for (int i = 1; i < size; i++) {
            int mul1 = 1;
            int mul2 = 1;

            for (int j = 0; j < i; j++) {
                mul1 *= numbers[j] - '0';
            }

            for (int j = i; j < size; j++) {
                mul2 *= numbers[j] - '0';
            }

            if(mul1 == mul2) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}
