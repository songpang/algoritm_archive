package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        System.out.println(getSum(input[1]) - getSum(input[0] - 1));
    }

    private static int getSum(int i1) {
        int sum = 0;
        int temp = 0;
        int i = 1;
        while(temp < i1) {
            sum += i * i;
            temp += i;
            i++;
        }

        sum -= (temp - i1) * (i - 1);
        return sum;
    }
}
