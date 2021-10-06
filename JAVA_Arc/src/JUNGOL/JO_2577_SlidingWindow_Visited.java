package JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class JO_2577_SlidingWindow_Visited {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] plate = new int[N];
        for (int i = 0; i < N; i++) {
            plate[i] = Integer.parseInt(br.readLine());
        }

        int[] visited = new int[d + 1];

        int count = 0;
        for (int i = 0; i < k; i++) {
            if(visited[plate[i]]++ == 0) {
                count++;
            }
        }

        int max = count;
        for (int i = 0; i < N; i++) {
            if(visited[c]++ == 0) {
                count++;
            }

            if(--visited[plate[i]] == 0) {
                count--;
            }

            int temp = i + k;
            if(temp >= N) {
                if(visited[plate[temp - N]]++ == 0) {
                    count++;
                }
            } else {
                if(visited[plate[temp]]++ == 0) {
                    count++;
                }
            }

            max = Math.max(max, count);
        }

        System.out.println(max);
    }
}
