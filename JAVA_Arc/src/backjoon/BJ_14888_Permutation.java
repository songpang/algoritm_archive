package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 백준 연산자 끼워넣기 14888
// MAX값 MIN값을 -10억 10억 이하 이상으로 해야되는데
// 그냥 MIN값을 0으로 둬서 틀린 문제
// 수가 작아서 permutation으로 풀었는데 속도가 너무 느림.
// dfs로 인자에 값을 바로바로 넘겨서 계산했어야 함.

public class BJ_14888_Permutation {
    static int N, MAX, MIN;
    static int[] numbers, operators;
    static char[] OPERATOR = {'+', '-', '*', '/'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        operators = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        char[] ops = new char[N - 1];
        int idx = 0;
        for (int i = 0; i < 4; i++) {
            while (operators[i] != 0) {
                ops[idx++] = OPERATOR[i];
                operators[i]--;
            }
        }

        MAX = -Integer.MAX_VALUE;
        MIN = Integer.MAX_VALUE;

        permutation(0, ops, new char[N - 1], new boolean[N - 1]);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void permutation(int count, char[] ops, char[] output, boolean[] visited) {
        if (count == N - 1) {
            int first = numbers[0];
            int second;
            for (int i = 0; i < N - 1; i++) {
                second = numbers[i + 1];
                switch (output[i]) {
                    case '+':
                        first += second;
                        break;
                    case '-':
                        first -= second;
                        break;
                    case '/':
                        first /= second;
                        break;
                    case '*':
                        first *= second;
                        break;
                }
            }
            MAX = Math.max(MAX, first);
            MIN = Math.min(MIN, first);
        }

        for (int i = 0; i < N - 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[count] = ops[i];
                permutation(count + 1, ops, output, visited);
                visited[i] = false;
            }
        }
    }
}
