package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJ_2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] pillar = new int[N][2];

        int max = 0;
        for (int i = 0; i < N; i++) {
            pillar[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            max = Math.max(max, pillar[i][1]);
        }

        if(N == 1) {
            System.out.println(pillar[0][1]);
            return;
        }
        Arrays.sort(pillar, Comparator.comparingInt(o -> o[0]));

        // 첫번째 원소 잡고
        int localMax = pillar[0][1];
        int xValue = pillar[0][0];
        int width = 0;
        int sum = 0;

        int i;
        for (i = 1; i < N; i++) {
            // 그놈보다 큰놈 나올 때 까지 전진
            if (!(pillar[i][1] > localMax)) {
                if(N == 2) {
                    i--;
                    break;
                }
                continue;
            }

            width = pillar[i][0] - xValue;
            sum += localMax * width;
            // 큰놈 나오면 거기까지 사각형 값 계산

            localMax = pillar[i][1];
            xValue = pillar[i][0];
            if (pillar[i][1] == max) {
                break;
            }
        }
        if(max == pillar[0][1]) {
            i = 0;
        }
        sum += max;
        int temp = pillar[i][0] + 1;
        int j = ++i;
        xValue = 0;
        int jLocation = 0;
        while (j < N) {
            max = 0;
            for (; j < N; j++) {
                if (max <= pillar[j][1]) {
                    max = pillar[j][1];
                    xValue = pillar[j][0] + 1;
                    jLocation = j + 1;
                }
            }
            width = xValue - temp;
            sum += width * max;
            temp = xValue;
            j = jLocation;
        }

        System.out.println(sum);
    }
}
