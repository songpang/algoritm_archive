package programmers;

import java.util.ArrayList;
import java.util.List;

public class PG_TruckPassingThroughTheBridge {

    public static void main(String[] args) {
        System.out.println(solution(5, 5, new int[]{2, 2, 2, 2, 1, 1, 1, 1, 1}));
    }

    //미해결
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        List<Integer> bridge = new ArrayList<>();
        int currentWeight = 0;

        for (int truck_weight : truck_weights) {

            if (bridge.size() == 0) {
                bridge.add(truck_weight);
                currentWeight += truck_weight;
                answer += bridge_length + 1;
            } else if (currentWeight + truck_weight <= weight) {
                currentWeight = currentWeight - bridge.remove(0) + truck_weight;
                bridge.add(truck_weight);
                answer++;
            } else {
                currentWeight = currentWeight - bridge.remove(0) + truck_weight;
                bridge.add(truck_weight);
                answer += bridge_length;
            }

        }
        return answer;
    }
}
