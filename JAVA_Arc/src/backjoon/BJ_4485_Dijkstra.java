// 언어 : JAVA , 메모리 : 44824 KB , 시간 : 1320 ms

package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_4485_Dijkstra {
    static class Adjacent {
        int from;
        List<Integer> to = new ArrayList<>();
        List<Integer> weight = new ArrayList<>();

        public Adjacent(int from) {
            this.from = from;
        }
    }

    private static final String SYSOUT_STRING = "Problem %d: ";
    static int N;
    static int[][] cave;
    static int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // 처음에 BFS로 접근을 했음 -> 테케 실패
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int t = 1; ; t++) {
            String carryOn = br.readLine();
            if (carryOn.equals("0")) break;
            N = Integer.parseInt(carryOn);
            // 인접 리스트 선언 및 초기화
            List<Adjacent> adjacentList = new ArrayList<>();
            for (int i = 0; i < N * N; i++) {
                adjacentList.add(new Adjacent(i));
            }

            cave = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 4방향에 있는 정점들을 인접 리스트에 등록
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int location = i * N + j;

                    for (int k = 0; k < 4; k++) {
                        int nx = i + DIR[k][0];
                        int ny = j + DIR[k][1];

                        if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                            int toLocation = nx * N + ny;
                            adjacentList.get(location).to.add(toLocation);
                            adjacentList.get(location).weight.add(cave[nx][ny]);
                        }
                    }
                }
            }

            // 다익스트라 알고리즘 시작
            boolean[] visited = new boolean[N * N];
            int[] distance = new int[N * N];

            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[0] = 0;
            int min = 0, current = 0;
            for (int i = 0; i < N * N; i++) {
                min = Integer.MAX_VALUE;

                // 갈 수 있는 노드 중 최선인 노드 선택
                for (int j = 0; j < N * N; j++) {
                    if (!visited[j] && distance[j] < min) {
                        min = distance[j];
                        current = j;
                    }
                }

                visited[current] = true;
                if (current == N * N - 1) break;

                // 선택한 노드를 거쳐 갈 수 있는 곳 거리 갱신신
               int size = adjacentList.get(current).to.size();
                for (int j = 0; j < size; j++) {
                    if (!visited[adjacentList.get(current).to.get(j)]
                            && distance[adjacentList.get(current).to.get(j)] > min + adjacentList.get(current).weight.get(j)) {
                        distance[adjacentList.get(current).to.get(j)] = min + adjacentList.get(current).weight.get(j);
                    }
                }
            }

            int result = distance[distance.length - 1] + cave[0][0];
            System.out.printf(SYSOUT_STRING + result + "\n", t);
        }
    }
}
