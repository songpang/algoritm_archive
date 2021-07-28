package programmers;

import java.util.ArrayList;
import java.util.List;

public class PG_KAKAO_EscapeMaze {
    private static int shortest_length = Integer.MAX_VALUE;

    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int answer = 0;

        boolean[] visited = new boolean[n];
        List<Node> nodes = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            // 노드 초기화
            nodes.add(new Node(i));
        }

        for (int[] road : roads) {
            // 만들어 놓은 노드에 연결된 노드들 추가
            Node node = nodes.get(road[0]);
            node.next.add(road[1]);
            node.length.add(road[1]);

            // end에 해당되는 노드에 linked 추가.
            node = nodes.get(road[1]);
            node.linked.add(road[0]);
        }

        // 트랩인 노드 true 로 초기화
        for (int trap : traps) {
            nodes.get(trap).isTrap = true;
        }

        visited[start] = true;
        dfs(0, start, end, nodes, visited);
        // 탈출 조건은
        // 현재 노드에서
        // 더이상 갈곳이 없을 때 next에서 visited를 탐색했을 때 다 방문하면.


        // roads 에서 첫 출발지 찾고
        // 가장 작은


        // 노드를 만들어 놓고
        // 트랩 방문했을 때
        // 노드의 방향을 바꿈


        return answer;
    }

    private void dfs(int totalLength, int start, int end, List<Node> nodes, boolean[] visited) {
        if (start == end) {
            shortest_length = Math.min(shortest_length, totalLength);
        }

        Node startNode = nodes.get(start);
        if(startNode.next.size() == 0) {
            return;
        }

        if (startNode.isTrap) {
            for (int i = 0; i < startNode.next.size(); i++) {

            }

            for (Integer n : startNode.next) {
                // next에 있는 linked를 next로 만들기
                // 그리고 next를 삭제하기.
                // length도 삭제하기.

                // next에 있는 놈들을
                //

                // linked에 있는 애들을 next로 만들기.
                // 그리고 length를 추가하기.

//                nodes.get(n).linked
            }
        }

        List<Integer> next = startNode.next;
        for (int i = 0; i < next.size(); i++) {
            int nextNode = next.get(i);
            if (visited[nextNode]) {
                int nextLength = startNode.length.get(i);

                visited[nextNode] = true;
                dfs(totalLength + nextLength, nextNode, end, nodes, visited);
                visited[nextNode] = false;
            }
        }
    }

    class Node {
        int curNumber;
        List<Integer> next;
        List<Integer> length;
        List<Integer> linked;
        boolean isTrap;

        public Node(int curNumber) {
            this.curNumber = curNumber;
        }

        public int getFastestRoad(int road) {
            int minimum = Integer.MAX_VALUE;
            for (int i = 0; i < next.size(); i++) {
                if (next.get(i) == road) {
                    minimum = Math.min(length.get(i), minimum);
                }
            }
            return minimum;
        }
    }

}
