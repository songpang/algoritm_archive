package codingtest.Toss;

import java.util.StringTokenizer;

public class Toss4 {
    // NEXT SHOW NEGATIVE EXIT 나올 때 M일 N회 까지 알림 가능
    // 사용자가 negative하면 M일 후에 가능
    // M일 안에 N번 다쓰면 M일 후에 가능.

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
        int mCount = M;
        int nCount = N;

        while(st.hasMoreTokens()) {
            if(nCount == 0) {
                mCount--;
            }






        }

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

            // M일동안 N번쓰면 그 때 부터 M일 추가
            // Next하면 M일 - 1
            //
        }


        System.out.println(sb.toString());
        return sb.toString();
    }

}
