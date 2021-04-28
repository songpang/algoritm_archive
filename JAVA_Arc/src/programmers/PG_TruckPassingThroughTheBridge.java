package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class PG_TruckPassingThroughTheBridge {

    public static void main(String[] args) {
        System.out.println(solution(5, 5, new int[]{2, 2, 2, 2, 1, 1, 1, 1, 1}));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> trucks = new LinkedList<>();
        int current_weight = 0;

        for (int truck_weight : truck_weights) {
            while (true) {
                if(trucks.isEmpty()) {
                    trucks.offer(truck_weight);
                    current_weight += truck_weight;
                    answer++;
                    break;
                } else if (trucks.size() == bridge_length) {
                    current_weight -= trucks.poll();
                } else {
                    if(current_weight + truck_weight <= weight) {
                        trucks.offer(truck_weight);
                        current_weight += truck_weight;
                        answer++;
                        break;
                    } else {
                        trucks.add(0);
                        answer++;
                    }
                }
            }
        }
        return answer + bridge_length;
    }
}
