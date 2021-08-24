package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1197_MST_Prim {
    static class Edge {
        int start;
        List<Integer> weight;
        List<Integer> to;

        public Edge(int start) {
            this.start = start;
            weight = new ArrayList<>();
            to = new ArrayList<>();
        }
    }

    // 백준 최소 스패닝 트리 (인접 행렬 -> 메모리 초과)
    // 인접 행렬 -> 인접 리스트로 변경.
    // 인접 리스트 등록시 행렬처럼 반대쪽도 등록해줘야함

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점의 개수
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[V + 1];
        int[] minEdge = new int[V + 1];
        List<Edge> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjList.add(new Edge(i));
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            Edge temp = adjList.get(a);
            temp.to.add(b);
            temp.weight.add(c);

            temp = adjList.get(b);
            temp.to.add(a);
            temp.weight.add(c);
        }

        for (int i = 0; i < V; i++) {
            minEdge[i] = Integer.MAX_VALUE;
        }

        int result = 0;
        minEdge[0] = 0;

        for (int i = 0; i < V; i++) {
            int min = Integer.MAX_VALUE;
            int minVertex = -1;

            for (int j = 0; j < V; j++) {
                if (!visited[j] && min > minEdge[j]) {
                    min = minEdge[j];
                    minVertex = j;
                }
            }

            visited[minVertex] = true;
            result += min;
            int size = adjList.get(minVertex).to.size();

            for (int j = 0; j < size; j++) {
                int temp = adjList.get(minVertex).to.get(j);
                if(!visited[temp] && minEdge[temp] > adjList.get(minVertex).weight.get(j)) {
                    minEdge[temp] = adjList.get(minVertex).weight.get(j);
                }
            }
        }

        System.out.println(result);
    }
}




