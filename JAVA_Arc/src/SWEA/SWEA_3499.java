package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] answer;
        int M, N;
        StringTokenizer st;
        int cases = Integer.parseInt(br.readLine());

        for (int t = 1; t <= cases; t++) {
            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            answer = new String[M];

            N = M % 2 == 0 ? M : M + 1;
            for (int i = 0; i < N / 2; i++)
                answer[2 * i] = st.nextToken();

            for (int i = 0; i < M / 2; i++)
                answer[2 * i + 1] = st.nextToken();

            sb.append("#").append(t);
//            Arrays.stream(answer).forEach(i -> sb.append(" ").append(i));
            for (int i = 0; i < answer.length; i++) {
                sb.append(" ").append(answer[i]);
            }
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}
