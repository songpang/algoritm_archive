package hackerRank;

import java.util.*;

public class HR_CommonChild {
    public static void main(String[] args) {
        int answer = commonChild("ABCDEF", "FBDAMN");
        System.out.println(answer);
        // S H I N C H A N
        // N O H A R A A A

    }

    // LCS(Longest Common Subsequence)를 이용해서 풀어야함
    static int commonChild(String S, String T) {
        int LArr[][] = new int[S.length() + 1][T.length() + 1];

        for (int i = 0; i <= S.length(); i++) {
            for (int j = 0; j <= T.length(); j++) {
                if (i == 0 || j == 0)
                    LArr[i][j] = 0;
                else if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    LArr[i][j] = LArr[i - 1][j - 1] + 1;
                } else {
                    LArr[i][j] = Math.max(LArr[i - 1][j], LArr[i][j - 1]);
                }
            }
        }
        return LArr[S.length()][T.length()];
    }

    // 너무 비효율적인 코드
    // timeout
//    public static int commonChild(String s1, String s2) {
//        // counting array[26] 만들어 놓고
//        // 한바퀴 돌아서 알파벳 개수 센다음에
//        // 0인데 s2에 있거나
//        // s2에 있는데 s1가 0이면 삭제
//        int[] countingEnglish = new int[26];
//        int[] countingEnglish2 = new int[26];
//
//        int result = 0;
//
//        s2 = countEnLetters(s2, s1, countingEnglish);
//        s1 = countEnLetters(s1, s2, countingEnglish2);
//
//        if (s2.equals(s1)) {
//            return s1.length();
//        }
//
//        Set<String> redundant = new HashSet<>();
//
//        Set<String> getCombS1 = combination(s1);
//        Set<String> getCombS2 = combination(s2);
//
//        String[] s1Arr =  getCombS1.toArray(new String[0]);
//        Arrays.sort(s1Arr, new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return s1.length() - s2.length();
//            }
//        });
//        String[] s2Arr = getCombS2.toArray(new String[0]);
//        Arrays.sort(s2Arr, new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return s1.length() - s2.length();
//            }
//        });
//
//        for (int i = getCombS1.size() - 1; i >= 0; i--) {
//            redundant.add(s1Arr[i]);
//        }
//
//        for (int i = getCombS2.size() - 1; i >= 0 ; i--) {
//            int temp = redundant.size();
//            redundant.add(s2Arr[i]);
//            if(redundant.size() == temp) {
//                result = s2Arr[i].length();
//                break;
//            }
//        }
//
//        return result;
//    }
//
//    private static String countEnLetters(String s1, String s2, int[] countingArr) {
//        for (char c : s2.toCharArray()) {
//            countingArr[c - 65]++;
//        }
//
//        for (int i = 0; i < countingArr.length; i++) {
//            if (countingArr[i] == 0) {
//                char temp = (char) (i + 65);
//                String temp1 = String.valueOf(temp);
//                s1 = s1.replaceAll(temp1, "");
//            }
//        }
//
//        return s1;
//    }
//
//    public static Set<String> combination(String s) {
//        char[] sCharArr = s.toCharArray();
//        Set<String> resultComb = new HashSet<>();
//
//        for (int i = 1; i < s.length() + 1; i++) {
//            boolean[] visited = new boolean[sCharArr.length];
//            getComb(sCharArr, resultComb, 0, i, visited);
//        }
//
//        return resultComb;
//    }
//
//    private static void getComb(char[] sCharArr, Set<String> resultComb, int start, int r, boolean[] visited) {
//        if (r == 0) {
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < visited.length; i++) {
//                if(visited[i]) {
//                    sb.append(sCharArr[i]);
//                }
//            }
//            resultComb.add(sb.toString());
//        }
//
//        for (int i = start; i < sCharArr.length; i++) {
//            visited[i] = true;
//            getComb(sCharArr, resultComb, i + 1, r - 1, visited);
//            visited[i] = false;
//        }
//    }
}
