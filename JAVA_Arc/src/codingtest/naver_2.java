package codingtest;

import java.util.Stack;

public class naver_2 {
    public static void main(String[] args) {
        System.out.println(solution("2(2(hi)2(co))x2(bo)"));

        //"hihicocohihicocoxbobo"
    }

    public static String solution(String compressed) {
        Stack<Integer> multiplyString = new Stack<>();
        String roundTemp = "";

        for (int i = 0; i < compressed.length(); i++) {
            //숫자면 계속 스택에 쌓기
            while (compressed.charAt(i) > 47 && compressed.charAt(i) < 58) {
                String temp = "";
                temp += compressed.charAt(i);
                while (compressed.charAt(i + 1) != '(') {
                   temp += compressed.charAt(++i);
                }
                multiplyString.push(Integer.parseInt(temp));
                i += 2;
            }

            StringBuilder temp = new StringBuilder();
            temp.append(roundTemp);
            while (compressed.charAt(i) != ')') {
                temp.append(compressed.charAt(i++));
            }

            int popStack = 1;
            if (!multiplyString.isEmpty()) {
                popStack = multiplyString.pop();
            }
            String tempToAdd = temp.toString();
            for (int j = 0; j < popStack - 1; j++) {
                temp.append(tempToAdd);
            }

            roundTemp = temp.toString();
        }

        return roundTemp;
    }
}
