package codingtest.Toss;

import java.util.StringTokenizer;

public class Toss4 {
    public static void main(String[] args) {
        solution("2 3\nSHOW\nSHOW\nNEXT\nSHOW\nSHOW\nNEXT\nSHOW\nNEXT\nSHOW\nSHOW\nNEXT\nSHOW\nEXIT");

    }

    public static String solution(String input) {
        StringTokenizer st = new StringTokenizer(input, "\n");
        String userInput = st.nextToken();
        int M = userInput.charAt(0) - '0';
        int N = userInput.charAt(2) - '0';

        StringBuilder sb = new StringBuilder();
        sb.append(userInput).append("\n");

        String next = "";
        int mCount = M + 1;
        int nCount = N;

        while(st.hasMoreTokens()) {
            next = st.nextToken();

            if (next.equals("SHOW")) {
                if (nCount != 0) {
                    sb.append(1).append("\n");
                    nCount--;
                } else {
                    sb.append(0).append("\n");
                }
            } else if (next.equals("EXIT")) {
                sb.append("BYE");
            } else if (next.equals("NEXT")) {
                if(mCount == 0) {
                    nCount = N;
                }
                mCount--;
                sb.append("-");
                sb.append("\n");
            } else if (next.equals("NEGATIVE")) {
                sb.append("0").append("\n");
                nCount = 0;
                mCount = M;
            }

            if(mCount == -1) {
                mCount = M;
                nCount = N;
            }
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

}
