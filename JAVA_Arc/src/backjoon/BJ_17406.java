package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17406 {
    static int min = Integer.MAX_VALUE;
    static int[][] plate, work;

    /*
        배열 돌리기 4
        * nPn 순열 만들기
        * 2차원 배열 deepCopy
     */
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

        int K = inputs[2];
        work = new int[K][3];
        for (int i = 0; i < work.length; i++) {
            work[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        // 순서 만들기
        permutation(new int[K], new boolean[K], 0, K);

        System.out.println(min);
    }

    static void rightRotate(int[][] arr, int rs, int re, int cs, int ce) {
        int temp = arr[rs][ce];
        for (int i = ce; i > cs; i--) arr[rs][i] = arr[rs][i - 1]; // >
        for (int i = rs; i < re; i++) arr[i][cs] = arr[i + 1][cs]; // ^
        for (int i = cs; i < ce; i++) arr[re][i] = arr[re][i + 1]; // <
        for (int i = re; i > rs; i--) arr[i][ce] = arr[i - 1][ce]; // v
        arr[rs + 1][ce] = temp;
    }

    static void permutation(int[] output, boolean[] visited, int depth, int r) {
        if (depth == r) {
            int[][] plateClone;

            plateClone = deepCopy(plate);
            for (int j = 0; j < r; j++) {
                int rs = work[output[j]][0] - work[output[j]][2] - 1;
                int cs = work[output[j]][1] - work[output[j]][2] - 1;
                int re = work[output[j]][0] + work[output[j]][2] - 1;
                int ce = work[output[j]][1] + work[output[j]][2] - 1;

                while (rs < re && cs < ce) {
                    rightRotate(plateClone, rs++, re--, cs++, ce--);
                }
            }

            for (int[] ints : plateClone) {
                min = Math.min(min, Arrays.stream(ints).sum());
            }
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = i;
                permutation(output, visited, depth + 1, r);
                output[depth] = 0;
                visited[i] = false;
            }
        }
    }

    static int[][] deepCopy(int[][] origin) {
        if (origin == null) return null;
        int[][] result = new int[origin.length][origin[0].length];

        for (int i = 0; i < origin.length; i++) {
            System.arraycopy(origin[i], 0, result[i], 0, origin[0].length);
        }

        return result;
    }
}
