// 언어 : JAVA , 메모리 : 280912 KB , 시간 : 3204 ms

package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 자료형때문에 틀림 int -> long

public class BJ_13975_PriorityQ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i < K; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            long result = 0;
            while (pq.size() >= 2) {
                long next = pq.poll() + pq.poll();
                result += next;
                pq.offer(next);
            }

            System.out.println(result);
        }
    }
}
