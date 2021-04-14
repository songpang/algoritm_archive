import java.util.*;

public class PG_MOREHOT {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 10, 10, 10, 10}, 100));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            queue.offer(scoville[i]);
        }

        while (queue.size() > 1 || queue.peek() < K) {
            if(queue.size() == 1) return -1;
            int temp = queue.poll();
            int temp2= queue.poll();

            temp = temp + 2 * temp2;
            queue.offer(temp);
            answer++;
        }

        return answer;
    }

}
