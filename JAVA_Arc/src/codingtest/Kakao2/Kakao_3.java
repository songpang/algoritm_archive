package codingtest.Kakao2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Kakao_3 {
    @Test
    public void test() {
        Assertions.assertEquals(new int[]{14600, 34400, 5000},
                solution(new int[]{180, 5000, 10, 600},
                        new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
                                "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}));
    }

    static class Car {
        int number;
        int time;

        public Car(int number, int price) {
            this.number = number;
            this.time = price;
        }
    }

    public int[] solution(int[] fees, String[] records) {
        int defaultTime = fees[0];
        int defaultPrice = fees[1];
        int perTime = fees[2];
        int perPrice = fees[3];

        Map<String, String[]> rcMap = new HashMap<>();
        Map<String, Integer> cars = new HashMap<>();

        for (String record : records) {
            String[] temp = record.split(" ");

            if (temp[2].equals("IN")) {
                rcMap.put(temp[1], new String[]{temp[0], ""});
            } else {
                String a = rcMap.get(temp[1])[0]; // IN시간
                rcMap.remove(temp[1]);

                int inTime = Integer.parseInt(a.substring(0, 2)) * 60 + Integer.parseInt(a.substring(3));
                int outTime = Integer.parseInt(temp[0].substring(0, 2)) * 60 + Integer.parseInt(temp[0].substring(3));

                int diff = outTime - inTime;
                if(cars.containsKey(temp[1])) {
                    cars.put(temp[1], cars.get(temp[1]) + diff);
                } else {
                    cars.put(temp[1], diff);
                }
            }
        }

        // 안나간 차들 관리
        if(rcMap.size() != 0) {
            for (String s : rcMap.keySet()) {
                String a = rcMap.get(s)[0]; // IN시간

                int inTime = Integer.parseInt(a.substring(0, 2)) * 60 + Integer.parseInt(a.substring(3));
                int outTime = 23 * 60 + 59;

                int diff = outTime - inTime;
                if(cars.containsKey(s)) {
                    cars.put(s, cars.get(s) + diff);
                } else {
                    cars.put(s, diff);
                }
            }
        }

        List<Car> resultCars = new ArrayList<>();

        for (String s : cars.keySet()) {
            int diff = cars.get(s);

            int finalPrice = 0;
            if (diff <= defaultTime) {
                finalPrice = defaultPrice;
            } else {
                diff -= defaultTime;
                if (diff % perTime == 0) {
                    finalPrice = diff / perTime * perPrice;
                } else {
                    finalPrice = (diff / perTime + 1) * perPrice;
                }
                finalPrice += defaultPrice;
            }
            resultCars.add(new Car(Integer.parseInt(s), finalPrice));
        }

        resultCars.sort(Comparator.comparingInt(o -> o.number));

        int[] answer = new int[resultCars.size()];
        int idx = 0;
        for (Car resultCar : resultCars) {
            answer[idx++] = resultCar.time;
        }

        return answer;
    }
}













