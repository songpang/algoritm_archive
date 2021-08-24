package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2116 {
    static int[][] pairNumber = {{0, 5}, {1, 3}, {2, 4}};
    static int T;
    static int[][] dices;
    static int resultMax;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        dices = new int[T][6];
        resultMax = 0;

        for (int i = 0; i < T; i++) {
            dices[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 1; i <= 6; i++) {
            dfs(0, 0, i);
        }

        System.out.println(resultMax);
    }

    public static void dfs(int sum, int dice, int top) {
        if (dice == T) {
            resultMax = Math.max(resultMax, sum);
            return;
        }

        int number;
        int bottom = top;

        for (int i = 0; i < 6; i++) {
            if (dices[dice][i] == bottom) {
                number = i;
                if (number < 3) {
                    top = dices[dice][pairNumber[number][1]];
                } else {
                    top = dices[dice][pairNumber[(number - 2) % 3][0]];
                }
                break;
            }
        }

        int max = 0;
        for (int die : dices[dice]) {
            if (die != bottom && die != top) {
                max = Math.max(max, die);
            }
        }

        dfs(sum + max, dice + 1, top);
    }
}
