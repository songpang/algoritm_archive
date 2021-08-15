package programmers;

import java.util.ArrayList;
import java.util.List;

public class PG_KAKAO_EscapeMaze {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int result = solution(3, 1, 3, new int[][]{{1, 2, 2}, {3, 2, 3}}, new int[]{2});
        System.out.println(result);
    }

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

        for (int trap : traps) {
            nList.get(trap).isTrap = true;
        }

        getShortest(start, end, nList, 0);

        return answer;
    }

    private static void getShortest(int start, int end, List<Node> nList, int count) {
        Node tempNode = nList.get(start);
        if(start == end) {
            min = Math.min(min, count);
            return;
        }

        if(tempNode.isTrap) {
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
        }

        if(tempNode.next.size() == 0) {
            return;
        }

        // next로 한 번씩 다 가기.
        List<Time> next = tempNode.next;
        for (int i = 0; i < next.size(); i++) {
            Time time = next.get(i);
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
