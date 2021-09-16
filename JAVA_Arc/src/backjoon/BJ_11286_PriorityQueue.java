// 언어 : JAVA , 메모리 : 24704 KB , 시간 : 344 ms

package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 백준 11286 절댓값 힙
//
public class BJ_11286_PriorityQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if(Math.abs(o1) == Math.abs(o2)) return o1 - o2;
            return Math.abs(o1) - Math.abs(o2);
        });

        // 삼항 연산자로 아주 간단하게 코드를 줄일 수 있음.
        // 삼항 연산자는 코딩할 때 지양하는 코드 스타일.
        for (int i = 0; i < N; i++) {
            int next = Integer.parseInt(br.readLine());
            if(next== 0) {
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
            } else {
                pq.add(next);
            }
        }

        System.out.println(sb.toString());
    }
}
