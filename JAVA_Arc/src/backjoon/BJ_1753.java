package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1753 {
    static class Edge {
        int number;
        List<Integer> weight;
        List<Integer> to;

        public Edge(int number) {
            this.number = number;
            weight = new ArrayList<>();
            to = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine()) - 1;

        Edge[] adjList = new Edge[V + 1];
        boolean[] visited = new boolean[V];
        int[] minEdge = new int[V];

        for (int i = 0; i < V; i++) {
            adjList[i] = new Edge(i);
            minEdge[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            adjList[u].to.add(v);
            adjList[u].weight.add(w);

            adjList[v].to.add(u);
            adjList[v].weight.add(w);
        }

        minEdge[K] = 0;
        Edge temp = adjList[K];

        for (int i = 0; i < V; i++) {
            int minVertex = -1;
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < V; j++) {
                if(!visited[j] && min > minEdge[j]) {
                    minVertex = j;
                    min = minEdge[j];
                }
            }

            visited[minVertex] = true;
            int size = temp.to.size();

            for (int j = 0; j < size; j++) {
                if(!visited[j] && minEdge[j] > min + temp.weight.get(j)) {
                    minEdge[j] = min + temp.weight.get(j);
                }
            }
        }

        for (int i : minEdge) {
            System.out.println(i);
        }

    }

}




