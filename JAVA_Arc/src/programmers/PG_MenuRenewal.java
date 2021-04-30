package programmers;

import java.util.*;

public class PG_MenuRenewal {
    public static Map<String, Integer> combMap = new HashMap<>();
    public static List<String> finalAnswer = new ArrayList<>();

    public static void main(String[] args) {
        solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});

    }

    public static String[] solution(String[] orders, int[] course) {
        String[] answer;
        for (int i : course) {
            for (String order : orders) {
                String[] tempArr = order.split("");
                Arrays.sort(tempArr);
                combination(tempArr, new boolean[order.length()], 0, order.length(), i);
            }
            int max = 2;
            for (Integer v : combMap.values()) {
                if(v > max) max = v;
            }
            for (String s : combMap.keySet()) {
                if(combMap.get(s).equals(max)) {
                    finalAnswer.add(s);
                }
            }
            combMap.clear();
        }

        answer = finalAnswer.toArray(new String[finalAnswer.size()]);
        Arrays.sort(answer);

        return answer;
    }

    public static void combination(String[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            String temp = "";
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    temp += arr[i];
                }
            }
            if (combMap.containsKey(temp)) {
                combMap.put(temp, combMap.get(temp) + 1);
            } else {
                combMap.put(temp, 1);
            }
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
}
