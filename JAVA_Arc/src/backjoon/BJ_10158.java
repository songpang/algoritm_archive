package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10158 {
    static int w, h, p, q, t;
    static int[][] DIR = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        t = Integer.parseInt(br.readLine());

        int[] xyt = {p, q, t};

        int direction = 0;
        int count = 0;
        int distance = 0;

        while (xyt[2] != 0) {
            goDirection(xyt, direction);
            distance++;

            switch (direction) {
                case 0:
                    if (xyt[0] == w && xyt[1] == h) {
                        direction = 2;
                    } else if (xyt[0] == w) {
                        direction = 3;
                    } else if (xyt[1] == h) {
                        direction = 1;
                    }
                    break;
                case 1:
                    if (xyt[0] == w && xyt[1] == 0) {
                        direction = 3;
                    } else if (xyt[0] == w) {
                        direction = 2;
                    } else if (xyt[1] == 0) {
                        direction = 0;
                    }
                    break;
                case 2:
                    if (xyt[0] == 0 && xyt[1] == 0) {
                        direction = 0;
                    } else if (xyt[0] == 0) {
                        direction = 1;
                    } else if (xyt[1] == 0) {
                        direction = 3;
                    }
                    break;
                case 3:
                    if (xyt[0] == 0 && xyt[1] == h) {
                        direction = 1;
                    } else if (xyt[0] == 0) {
                        direction = 0;
                    } else if (xyt[1] == h) {
                        direction = 2;
                    }
                    break;
            }

            if(xyt[0] == p && xyt[1] == q) {
                count++;
                if(count == 2) {
                    distance /= 2;
                    t %= distance;
                }
            }
        }
        System.out.print(xyt[0] + " ");
        System.out.println(xyt[1]);
    }

    private static void goDirection(int[] xyt, int dir) {
        xyt[0] += DIR[dir][0];
        xyt[1] += DIR[dir][1];
        xyt[2]--;
    }
}
