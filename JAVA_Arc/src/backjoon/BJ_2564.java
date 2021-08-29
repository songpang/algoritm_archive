package backjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 2564 경비원
// 단순 구현
// IDEA : 각 선분을 길게 늘려서 사각형을 긴 선으로 만든다
// ㅁ -> ----
// 처음 풀이 실패 -> 솔루션 봤음.

public class BJ_2564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());

        int[] stores = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());

            switch (direction) {
                case 1:
                    stores[i] = height + location;
                    break;
                case 2:
                    stores[i] = 2 * height + width + (width - location);
                    break;
                case 3:
                    stores[i] = height - location;
                    break;
                case 4:
                    stores[i] = height + width + location;
                    break;
            }
        }

        int wholeLength = 2 * (height + width);
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int min = Math.abs(stores[N] - stores[i]);
            if(stores[N] > stores[i]) {
                min = Math.min(min, wholeLength - stores[N] + stores[i]);
            } else {
                min = Math.min(min, wholeLength - stores[i] + stores[N]);
            }
            sum += min;
        }

        System.out.println(sum);
    }
}
