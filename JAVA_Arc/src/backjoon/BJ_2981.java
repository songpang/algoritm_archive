// 언어 : JAVA , 메모리 : 14400 KB , 시간 : 136 ms
package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BJ_2981 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);

        // 첫번째 수와 두번째 수 만 나머지가 될 수 있다는 규칙 찾았지만 73% 시간초과
//        loop:
//        for (int i = 2; i <= numbers[1]; i++) {
//            int mod = numbers[0] % i;
//            for (int j = 0; j < N; j++) {
//                if(mod != numbers[j] % i) continue loop;
//            }
//            result.add(i);
//        }

        int r = numbers[1] - numbers[0];
        for (int i = 2; i < N; i++) {
            r = gcd(r, numbers[i] - numbers[i - 1]);
        }

        List<Integer> output = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        // i 를 r까지 돌리면 시간 확 늘어남....
        for (int i = 2; i <= Math.sqrt(r); i++) {
            if(r % i == 0) {
                output.add(i);
                if(r / i != i) {
                    output.add(r / i);
                }
            }
        }
        output.add(r);

        Collections.sort(output);
        for (Integer integer : output) {
            sb.append(integer).append(" ");
        }
        System.out.println(sb);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int mod = a % b;
            a = b;
            b = mod;
        }

        return a;
    }
}
