// 언어 : JAVA , 메모리 : 19632 KB , 시간 : 236 ms
package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 1976 여행가자
// 정점끼리 연결 되어있는지를 확인하는 문제.
public class BJ_1976_BFS_ConnectedVertex {
    static int[][] adjacent;
    static int[] route;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adjacent = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                adjacent[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        route = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }

        bfs(new boolean[N + 1]);
    }

    // 예정지가 아니어도 갈 수 있다는 걸 몰라서 틀림.
    public static void bfs(boolean[] visited) {
        Queue<Integer> iq = new LinkedList<>();
        iq.offer(route[0]);

        while (!iq.isEmpty()) {
            int temp = iq.poll();
            visited[temp] = true;
            for (int i = 1; i <= N; i++) {
                if (adjacent[temp][i] == 1 && !visited[i]) {
                    iq.offer(i);
                }
            }
        }

        for (int i : route) {
            if (!visited[i]) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
