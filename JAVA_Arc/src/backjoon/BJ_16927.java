package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_16927 {
    static int[][] plate;

    // 배열 돌리기 2
    // 배열 돌리기 1과 다르게 R의 크기가 10^9까지 커져서 최적화 필요.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] inputs = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        plate = new int[inputs[0]][inputs[1]];
        for (int i = 0; i < inputs[0]; i++) {
            plate[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        // 배열 돌리기
        int rs = 0;
        int re = inputs[0] - 1;
        int cs = 0;
        int ce = inputs[1] - 1;

        // inputs[2] - > R
        // 5 4 (7)(R)
        while (rs < re && cs < ce) {
            int modTimes = inputs[2] % (2 * (re - rs + ce - cs));
            for (int i = 0; i < modTimes; i++) {
                leftRotate(rs, re, cs, ce);
            }
            rs++;
            re--;
            cs++;
            ce--;
        }

        StringBuilder sb = new StringBuilder();
        for (int[] vals : plate) {
            for (int val : vals) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    static void leftRotate(int rs, int re, int cs, int ce) {
        int temp = plate[rs][cs];
        for (int i = cs; i < ce; i++) plate[rs][i] = plate[rs][i + 1];
        for (int i = rs; i < re; i++) plate[i][ce] = plate[i + 1][ce];
        for (int i = ce; i > cs; i--) plate[re][i] = plate[re][i - 1];
        for (int i = re; i > rs; i--) plate[i][cs] = plate[i - 1][cs];
        plate[rs + 1][cs] = temp;
    }
}
