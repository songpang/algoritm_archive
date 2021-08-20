package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 후위 표기식 계산 후
// 연산 실행.
public class SWEA_1223 {
    static String operations = "+-*/";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            Stack<String> opStack = new Stack<>();
            br.readLine();
            String input = br.readLine();

            int idx = 0;
            String temp;
            StringBuilder sb = new StringBuilder();

            while (idx != input.length()) {
                temp = String.valueOf(input.charAt(idx++));
                if (operations.contains(temp)) {
                    if (!opStack.isEmpty()) {
                        if (temp.equals("*") || temp.equals("/")) {
                            if (opStack.peek().equals("*") || opStack.peek().equals("/")) {
                                sb.append(opStack.pop());
                            }
                        } else {
                            while (!opStack.isEmpty()) {
                                sb.append(opStack.pop());
                            }
                        }
                    }
                    opStack.add(temp);
                } else {
                    sb.append(temp);
                }
            }

            while (!opStack.isEmpty()) {
                sb.append(opStack.pop());
            }
            String result = sb.toString();

            int first = 0;
            int second;
            idx = 0;
            Stack<Integer> numStack = new Stack<>();
            while (idx != result.length()) {
                char next = result.charAt(idx);
                if (operations.contains(String.valueOf(next))) {
                    second = numStack.pop();
                    first = numStack.pop();
                    switch (next) {
                        case '+':
                            first += second;
                            break;
                        case '-':
                            first -= second;
                            break;
                        case '*':
                            first *= second;
                            break;
                        case '/':
                            first /= second;
                            break;
                    }
                    numStack.add(first);
                } else {
                    numStack.add(next - '0');
                }
                idx++;
            }

            System.out.printf("#%d %d\n", t, first);
        }
    }
}
