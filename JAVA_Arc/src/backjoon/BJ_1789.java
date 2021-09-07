package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        int i = 1;
        long sum = 0;
        while(n >= sum) {
            sum += i;
            i++;
        }

        System.out.println(i - 2);
    }

}
