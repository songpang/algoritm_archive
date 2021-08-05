package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_1208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] boxes = new int[100];

        for (int j = 0; j < 10; j++) {
            int T = Integer.parseInt(br.readLine());

            String[] T2 = br.readLine().split(" ");
            for (int i = 0; i < 100; i++) {
                boxes[i] = Integer.parseInt(T2[i]);
            }

            int[] mmV;
            for (int test_case = 1; test_case <= T; test_case++) {
                mmV = getMinMaxValue(boxes);
                boxes[mmV[0]]++;
                boxes[mmV[1]]--;
                if(boxes[mmV[1]] - boxes[mmV[0]] <= 1) {
                    break;
                }
            }

            mmV = getMinMaxValue(boxes);
            System.out.printf("#%d %d\n", j + 1, boxes[mmV[1]] - boxes[mmV[0]]);
        }
    }

    public static int[] getMinMaxValue(int[] arr) {
        int maxV = Integer.MIN_VALUE;
        int minV = Integer.MAX_VALUE;
        int x = 0, y = 0;

        for (int i = 0; i < arr.length; i++) {
            if(minV > arr[i]) {
                minV = arr[i];
                x = i;
            }

            if(maxV < arr[i]) {
                maxV = arr[i];
                y = i;
            }
        }

        return new int[]{x, y};
    }
}
