package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


// 백준 2527 직사각형
// 단순 구현 문제.

public class BJ_2527 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            int q1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int q2 = Integer.parseInt(st.nextToken());

            if (isSame(x1, y1, p2, q2) ||
                    isSame(x2, y2, p1, q1) ||
                    isSame(x1, q1, p2, y2) ||
                    isSame(p1, y1, x2, q2)) {
                System.out.println("c");
            } else if ((p1 < x2) || (x1 > p2) || (y1 > q2) || (q1 < y2)) {
                System.out.println("d");
            } else if ((y1 == q2 && x1 != p2) || (q1 == y2 && p1 != x2)
                    || (x1 == p2 && y1 != q2) || (p1 == x2 && q1 != y2)) {
                System.out.println("b");
            } else {
                System.out.println("a");
            }
        }
    }

    public static boolean isSame(int x, int y, int x1, int y1) {
        if (x == x1 && y == y1) return true;
        else return false;
    }

}