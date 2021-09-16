package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3307 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] nums = new int[N];
            int[] lis = new int[N];
            int size = 1;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            lis[0] = nums[0];
            loop:
            for (int i = 1; i < N; i++) {
                for (int j = 0; j < size; j++) {
                    if (lis[j] > nums[i]) {
                        lis[j] = nums[i];
                        continue loop;
                    }
                }
                lis[size++] = nums[i];
            }

            System.out.printf("#%d %d\n", t, size);
        }
    }
}
