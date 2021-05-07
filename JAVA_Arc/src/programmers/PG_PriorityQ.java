package programmers;

import java.util.*;

public class PG_PriorityQ {
    public static void main(String[] args) {
        int[] temp = solution(new String[]{"I 5", "I 5", "D 1", "I 7", "D -1", "I 8"});
        for (int i : temp) {
            System.out.println(i);
        }
    }

    public static int[] solution(String[] operations) {
        int[] answer = {0, 0};
        List<Integer> operQ = new ArrayList<>();

        for (String operation : operations) {
            String[] temp = operation.split(" ");

            if(temp[0].equals("I")) {
                operQ.add(Integer.parseInt(temp[1]));
            } else if (operQ.size() > 0){
                if(Integer.parseInt(temp[1]) < 0) {
                    operQ.remove(0);
                } else {
                    operQ.remove(operQ.size()-1);
                }
            }
            Collections.sort(operQ);
        }

        if (operQ.size() != 0) {
            answer[0] = operQ.get(operQ.size() - 1);
            answer[1] = operQ.get(0);
        }

        return answer;
    }
}
