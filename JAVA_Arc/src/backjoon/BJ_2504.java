package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 21-09-08 실패
// 이유 : 괄호 여부는 구현했으나 계산에서 실패(안떠오름).
//

public class BJ_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();
        Stack<Character> brStack = new Stack<>();
        Stack<Integer> localStack = new Stack<>();

        int depth = 0;
        int local = 1;
        int result = 0;

        for (char c : input) {
            if (depth == 0) {
                result = local;
                local = 1;
                localStack.push(result);

                int sum = 0;
                while(!localStack.isEmpty()) {
                    sum += localStack.pop();
                }
                localStack.push(sum);
            }

            switch (c) {
                case '(':
                case '[':
                    brStack.push(c);
                    depth++;
                    continue;
            }

            if (brStack.isEmpty()) {
                System.out.println(0);
                return;
            } else {
                char temp = brStack.pop();
                if (c == ')' && temp == '(') {
                    depth--;
                    local *= 2;
                } else if (c == ']' && temp == '[') {
                    depth--;
                    local *= 3;
                } else {
                    System.out.println(0);
                    return;
                }
            }
        }

        System.out.println(result);
    }
}
