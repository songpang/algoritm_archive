package hackerRank;

import java.util.*;

public class HR_CommonChild {
    public static void main(String[] args) {
//        List<String> check = combination("ABCD");

////        System.out.println(check.toString());
//        int answer = commonChild("HARRY", "SALLY");
//        System.out.println(answer);
        String temp = "SALLY";
        temp.replaceAll("S", "");
        System.out.println(temp);
    }

    public static int commonChild(String s1, String s2) {
        // counting array[26] 만들어 놓고
        // 한바퀴 돌아서 알파벳 개수 센다음에
        // 0인데 s2에 있거나
        // s2에 있는데 s1가 0이면 삭제
        int[] countingEnglish = new int[26];
        int[] countingEnglish2 = new int[26];

        int result = 0;

        s2 = countEnLetters(s2, s1, countingEnglish);
        s1 = countEnLetters(s1, s2, countingEnglish2);

        if (s2.equals(s1)) {
            return s1.length();
        }

        // 순열 이용해서 set에 넣은 후
        // s2를 순열 이용해서 set에 큰것부터 하나씩 넣는다
        // 하나씩 넣을 때 마다 길이 측정해서 +1 안되어 있으면 그게 최대값.
        Set<String> redundant = new HashSet<>();

        List<String> getCombS1 = combination(s1);
        List<String> getCombS2 = combination(s2);

        for (int i = getCombS1.size() - 1; i >= 0; i--) {
            redundant.add(getCombS1.get(i));
        }

        for (int i = getCombS2.size() - 1; i >= 0 ; i--) {
            int temp = redundant.size();
            redundant.add(getCombS2.get(i));
            if(redundant.size() == temp) {
                result = getCombS2.get(i).length();
                break;
            }
        }

        return result;
    }

    private static String countEnLetters(String s1, String s2, int[] countingArr) {
        for (char c : s2.toCharArray()) {
            countingArr[c - 65]++;
        }

        for (int i = 0; i < countingArr.length; i++) {
            if (countingArr[i] == 0) {
                char temp = (char) (i + 65);
                String temp1 = String.valueOf(temp);
                System.out.println(temp1);
                s1.replaceAll(temp1, "OO");
            }
        }

        return s1;
    }

    public static List<String> combination(String s) {
        char[] sCharArr = s.toCharArray();
        List<String> resultComb = new ArrayList<>();

        for (int i = 1; i < s.length() + 1; i++) {
            boolean[] visited = new boolean[sCharArr.length];
            getComb(sCharArr, resultComb, 0, i, visited);
        }

        return resultComb;
    }

    private static void getComb(char[] sCharArr, List<String> resultComb, int start, int r, boolean[] visited) {
        if (r == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < visited.length; i++) {
                if(visited[i]) {
                    sb.append(sCharArr[i]);
                }
            }
            resultComb.add(sb.toString());
        }

        for (int i = start; i < sCharArr.length; i++) {
            visited[i] = true;
            getComb(sCharArr, resultComb, i + 1, r - 1, visited);
            visited[i] = false;
        }
    }
}
