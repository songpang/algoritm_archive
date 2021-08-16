package backjoon;

import java.util.Scanner;

public class BJ_3460 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        scanner.nextLine();

//        for (int i = 0; i < T; i++) {
//            int S = scanner.nextInt();
//            int idx = 0;
//            while(S > 0) {
//                if(S % 2 == 1) {
//                    System.out.print(idx++ + " ");
//                } else {
//                    idx++;
//                }
//                S /= 2;
//            }
//        }

        int s = 0;
        while(true) {
            if(Math.pow(2, s) < T) {
                s++;
            } else {
                break;
            }
        }

        s--;
        while(T > 0) {
            if(T >= 1 << s) {
                T -= 1 << s;
                System.out.print(s + " ");
            }
            s--;
        }


        // 1101
        // 1 << 0 = 1
        // 1 << 1 = 2;
        // 1 << 2 = 4;
        // 1 << 3 = 8;
        // 1 << 4 = 16;
        // 22
        // 16 4
    }
}
