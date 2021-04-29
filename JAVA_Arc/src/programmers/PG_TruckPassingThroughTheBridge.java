package programmers;

import java.util.*;

public class PG_TruckPassingThroughTheBridge {

    public static void main(String[] args) {
        System.out.println(solution(5, 5, new int[]{2, 2, 2, 2, 1, 1, 1, 1, 1}));
    }

//    public static int solution(int bridge_length, int weight, int[] truck_weights) {
//        int answer = 0;
//        Queue<Integer> trucks = new LinkedList<>();
//        int current_weight = 0;
//
//        for (int truck_weight : truck_weights) {
//            while (true) {
//                if(trucks.isEmpty()) {
//                    trucks.offer(truck_weight);
//                    current_weight += truck_weight;
//                    answer++;
//                    break;
//                } else if (trucks.size() == bridge_length) {
//                    current_weight -= trucks.poll();
//                } else {
//                    if(current_weight + truck_weight <= weight) {
//                        trucks.offer(truck_weight);
//                        current_weight += truck_weight;
//                        answer++;
//                        break;
//                    } else {
//                        trucks.add(0);
//                        answer++;
//                    }
//                }
//            }
//        }
//        return answer + bridge_length;
//    }

    // 클래스를 분리한 풀이 (효율성 제한이 있으면 통과하지 못할 수도 있을듯 )

    //    class Truck {
//        int weight;
//        int move;
//
//        public Truck(int weight) {
//            this.weight = weight;
//            this.move = 1;
//        }
//
//        public void moving() {
//            move++;
//        }
//    }
//
//    public int solution(int bridgeLength, int weight, int[] truckWeights) {
//        Queue<Truck> waitQ = new LinkedList<>();
//        Queue<Truck> moveQ = new LinkedList<>();
//
//        for (int truckWeight : truckWeights) {
//            waitQ.offer(new Truck(truckWeight));
//        }
//
//        int answer = 0;
//        int curWeight = 0;
//
//        while(!waitQ.isEmpty() || !moveQ.isEmpty()) {
//            answer++;
//
//            if (moveQ.isEmpty()) {
//                Truck t = waitQ.poll();
//                curWeight += t.weight;
//                moveQ.offer(t);
//                continue;
//            }
//
//            for (Truck truck : moveQ) {
//                truck.moving();
//            }
//
//            if(moveQ.peek().move > bridgeLength) {
//                Truck t = moveQ.poll();
//                curWeight -= t.weight;
//            }
//
//            if(!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
//                Truck t = waitQ.poll();
//                curWeight += t.weight;
//                moveQ.offer(t);
//            }
//        }
//        return answer;
//    }
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Stack<Integer> truckStack = new Stack<>();
        Map<Integer, Integer> bridgeMap = new HashMap<>();

        for(int i = truck_weights.length-1; i >= 0; i--)
            truckStack.push(truck_weights[i]);

        int answer = 0;
        int sum = 0;
        while(true) {
            answer++;

            if(bridgeMap.containsKey(answer))
                bridgeMap.remove(answer);

            sum = bridgeMap.values().stream().mapToInt(Number::intValue).sum();

            if(!truckStack.isEmpty()) {
                if(sum + truckStack.peek() <= weight)
                    bridgeMap.put(answer + bridge_length, truckStack.pop());
            }

            if(truckStack.isEmpty())
               return answer + bridge_length;
        }
    }
}
