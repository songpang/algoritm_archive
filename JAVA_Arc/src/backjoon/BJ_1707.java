package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

// 인접 행렬로 하면 메모리초과
// 인접 리스트로 하면 시간초과

public class BJ_1707 {
    static class Number {
        int number;
        int setLocation;

        public Number(int number, int setLocation) {
            super();
            this.number = number;
            this.setLocation = setLocation;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            // 인접행렬 생성
            List<ArrayList<Integer>> adjacent = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adjacent.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken()) - 1;
                int to = Integer.parseInt(st.nextToken()) - 1;

                adjacent.get(from).add(to);
                adjacent.get(to).add(from);
            }

            // 각각의 집합에 원소를 넣을 Set 선언
            // 정점에 연결된 정점들 넣기위한 큐 선언
            Set<Integer> check = new HashSet<>();
            Set<Integer> check2 = new HashSet<>();
            Queue<Number> iq = new LinkedList<>();

            // 시작 정점 0 넣음
            // setLocation이 1이면 0과 같은 집합, -1 이면 0과 다른 집합에 들어감.
            check.add(0);
            iq.offer(new Number(0, 1));
            while (!iq.isEmpty()) {
                Number recent = iq.poll();

                for (Integer adj : adjacent.get(recent.number)) {
                    iq.offer(new Number(adj, recent.setLocation * -1));

                    if (recent.setLocation == 1) { // 0과 같은 집합에 넣는다
                        check2.add(adj);
                    } else { // 0과 다른 집합에 넣는다
                        check.add(adj);
                    }
                }

                int size = adjacent.get(recent.number).size();
                for (int i = 0; i < size; i++) {
                    int removed = adjacent.get(recent.number).remove(0);
                    adjacent.get(removed).removeIf(n -> (n == recent.number));
                }
            }

            if (check.size() + check2.size() == V) { // 연산을 끝낸 후 size를 더한 값이 V와 같으면 성공
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
