package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 최소, 최대
public class BJ_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = -1000001;
        int temp;
        for (int i = 0; i < N; i++) {
            temp = Integer.parseInt(st.nextToken());
            min = Math.min(min, temp);
            max = Math.max(max, temp);
        }
        System.out.printf("%d %d",min,max);
    }
}

