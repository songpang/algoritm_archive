package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    생각했지만 실패한 알고리즘
    1. DFS로 접근
    2. 모든 노드를 다 만든다음에
    3. roads 에 따라서 next를 위한 List와 prev(나한테 들어오는 길)을 위한 List를 만들어준다.
    4. 순차적으로 방문하는데 trap 이라면
    5. next에 있는 놈들 방문해서 prev에 있는 놈을 next로 옮겨주고
    6. prev에 있는 놈들 방문해서 next에 있는 놈들 prev로 바꿔줌
    7. 방문한 노드의 next, prev 바꿈
    8. 그다음 next로 출발
 */
public class PG_KAKAO_EscapeMaze {
    public static void main(String[] args) {
        int result = solution(4, 1, 4, new int[][]{{1, 2, 1}, {3, 2, 1}, {2, 3, 1}, {2, 3, 2}, {2, 4, 1}}, new int[]{2, 3});
        System.out.println(result);
    }

    static int min = Integer.MAX_VALUE;
    static Map<Integer, Integer> visited;

    public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int answer = 0;

        // n까지 노드 만들기
        List<Node> nList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            nList.add(new Node(i));
        }

        for (int[] road : roads) {
            int number = road[0];
            int destination = road[1];
            int time = road[2];

            Node tempNode = nList.get(number);
            tempNode.next.add(new Time(destination, time));
            tempNode = nList.get(destination);
            tempNode.prev.add(new Time(number, time));
        }

        visited = new HashMap<>();
        for (int trap : traps) {
            visited.put(trap, 0);
            nList.get(trap).isTrap = true;
        }

        getShortest(start, end, nList, 0);

        return min;
    }

    private static void getShortest(int start, int end, List<Node> nList, int count) {
        Node tempNode = nList.get(start);
        if(start == end) {
            min = Math.min(min, count);
            return;
        }

        if(tempNode.isTrap) {
            // next의 값들 갖고오기
            List<Time> next = tempNode.next;
            for (int i = 0; i < next.size(); i++) {
                Time time = next.get(i);
                Node nextNode = nList.get(time.n);
                // prev에 있는걸 next에 넣어야 함
                Time tempTime;
                List<Time> prev = nextNode.prev;
                for (int j = 0; j < prev.size(); j++) {
                    Time time1 = prev.get(j);
                    if (time1.n == tempNode.n) {
                        tempTime = time1;
                        nextNode.prev.remove(tempTime);
                        nextNode.next.add(tempTime);
                    }
                }
            }

            List<Time> prev = tempNode.prev;
            for (int j = 0; j < prev.size(); j++) {
                Time time = prev.get(j);
                Node prevNode = nList.get(time.n);
                // next에 있는걸 prev에 넣어야 함
                Time tempTime;
                List<Time> prevN = prevNode.next;
                for (int i = 0; i < prevN.size(); i++) {
                    Time time1 = prevN.get(i);
                    if (time1.n == tempNode.n) {
                        tempTime = time1;
                        prevNode.next.remove(tempTime);
                        prevNode.prev.add(tempTime);
                    }
                }
            }

            // 문제 발생 prev 에 있는 걸 next에 넣었는데
            // 다음 next에 있는 걸 prev에 넣을 때 중복되는 번호면
            // 여기서 꼬임 발생.

            tempNode.next = prev;
            tempNode.prev = next;
        }

        if(tempNode.next.size() == 0) {
            return;
        }

        if(count > min) {
            return;
        }

        // next로 한 번씩 다 가기.
        List<Time> next = tempNode.next;
        for (int i = 0; i < next.size(); i++) {
            Time time = next.get(i);
            if(nList.get(time.n).isTrap) {
                if(visited.get(time.n) > 2) {
                    continue;
                }
                visited.put(time.n, visited.get(time.n) + 1);
            }
            getShortest(time.n, end, nList, count + time.time);
        }
    }

    static class Node {
        int n;
        List<Time> next;
        List<Time> prev;
        boolean isTrap;

        public Node(int n) {
            this.n = n;
            next = new ArrayList<>();
            prev = new ArrayList<>();
            isTrap = false;
        }
    }

    static class Time {
        int n;
        int time;

        public Time(int n, int time) {
            this.n = n;
            this.time = time;
        }
    }
}
