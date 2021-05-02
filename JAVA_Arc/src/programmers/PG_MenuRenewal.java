package programmers;

import java.util.*;

public class PG_MenuRenewal {
    public static Map<String, Integer> combMap = new HashMap<>();

    public static void main(String[] args) {
        for (String s : solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4})) {
            System.out.println(s);
        }
    }

    public static List<String> solution(String[] orders, int[] course) {
        String[] answer = {};
        List<String> answer2 = new ArrayList<>();


        for (String order : orders) {
            for (int i : course) {
                combination(order.split(""), new boolean[order.length()], 0, order.length(), i);
            }
        }

        for (String s : combMap.keySet()) {
            System.out.println(combMap.get(s));
        }


//        List<Integer> max = new ArrayList<>();
//        for (int i = 0; i < course.length; i++) {
//            max.add(0);
//        }
//
//        for (String s : combMap.keySet()) {
//            System.out.println(s);
//            System.out.println(combMap.get(s));
//        }
//
//        for (Integer integer : max) {
//            System.out.println(integer);
//        }
//
//        for (int i = 0; i < max.size(); i++) {
//            for (String s : combMap.keySet()) {
//                if(s.length() == course[i] && max.get(i) == combMap.get(s)) {
//                    answer2.add(s);
//                }
//            }
//        }

//        answer = answer2.toArray(new String[answer2.size()]);
        return answer2;
    }

    public static void combination(String[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            String comb = "";
            for (int i = 0; i < arr.length; i++) {
                if(visited[i]) {
                    comb += arr[i];
                }
            }
            if(combMap.containsKey(comb)) {
                combMap.put(comb, combMap.get(comb));
            } else {
                combMap.put(comb, 1);
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
