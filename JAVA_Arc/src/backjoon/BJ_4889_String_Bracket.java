// 언어 : JAVA , 메모리 : 15044 KB , 시간 : 184 ms
package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 백준 4889 안정적인 문자열
// 스택을 이용해서 괄호 적합성 판단하는 전형적인 스트링 문제.

public class BJ_4889_String_Bracket {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        Stack<Character> bracketStack;
        char[] brackets;
        int count;
        int idx = 1;

        while(true) {
            input = br.readLine();
            if(input.charAt(0) == '-') break;

            brackets = input.toCharArray();
            bracketStack = new Stack<>();
            count = 0;
            for (char bracket : brackets) {
                if(bracket == '{') {
                    bracketStack.push(bracket);
                } else {
                    if(bracketStack.size() == 0) {
                        count++;
                        bracketStack.push(bracket);
                    } else {
                        bracketStack.pop();
                    }
                }
            }

            System.out.printf("%d. %d\n", idx++, count + bracketStack.size() / 2);
        }
    }
}
