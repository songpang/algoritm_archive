package SWEA;

import java.util.Scanner;

public class SWEA_1289 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int test_case = 1; test_case <= T; test_case++) {
            String temp = sc.nextLine();

            char ch = temp.charAt(0);
            int count = temp.charAt(0) - '0';
            for (int i = 1; i < temp.length(); i++) {
                if(temp.charAt(i) != ch) {
                    count++;
                    ch = temp.charAt(i);
                }
            }

            System.out.printf("#%d %d\n", test_case, count);
        }
    }

    /*
                boolean flag = false;
            for (char c : temp) {
                if (!flag) {
                    if (c == '1') {
                        count++;
                        flag = true;
                    }
                } else {
                    if (c == '0') {
                        count++;
                        flag = false;
                    }
                }
            }
     */
}
