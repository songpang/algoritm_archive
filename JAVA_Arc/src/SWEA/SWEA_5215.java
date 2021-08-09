package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215 {
    static int[][] ingredients;
    static int maxCal;
    static int maxPoint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());
        for (int t = 1; t <= M; t++) {
            int[] input = new int[2];

            st = new StringTokenizer(br.readLine());
            input[0] = Integer.parseInt(st.nextToken());
            input[1] = Integer.parseInt(st.nextToken());

            maxCal = input[1];
            maxPoint = 0;
            ingredients = new int[input[0]][2];
            for (int i = 0; i < input[0]; i++) {
                st = new StringTokenizer(br.readLine());
                ingredients[i][0] = Integer.parseInt(st.nextToken());
                ingredients[i][1] = Integer.parseInt(st.nextToken());
            }

            find(0, 0, 0);
            System.out.printf("#%d %d\n", t, maxPoint);
        }
    }

    public static void find(int point, int cal, int r) {
        if (cal > maxCal) {
            return;
        }

        if (maxPoint <= point) {
            maxPoint = point;
        }

        if (r == ingredients.length) {
            return;
        }

        find(point + ingredients[r][0], cal + ingredients[r][1], r + 1);
        find(point, cal, r + 1);
    }
}

