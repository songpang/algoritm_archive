package codingtest.Kakao;

import java.util.*;

public class Kakao_3 {
    public static void main(String[] args) {
        System.out.println(solution(8, 2, new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"}));
    }

    public static String solution(int n, int k, String[] cmd) {
        boolean[] original = new boolean[n];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(i);
        }
        Stack<Integer> undo = new Stack<>();

        for (String s : cmd) {
            if (s.equals("C")) {
                if (n - 1 == k) {
                    // 끝에있는 경우 마지막 값 선택
                    int temp = result.remove(k);
                    undo.push(temp);
                    original[temp] = true;
                    k--;
                } else {
                    // 아닌 경우 삭제후 해당 번호 유지.
                    int temp = result.remove(k);
                    undo.push(temp);
                    original[temp] = true;
                }
                n--;
            } else if (s.equals("Z")) {
                //복구
                //스택에 있는 값 꺼내오기
                int temp = undo.pop();
                original[temp] = false;
                int i;
                for (i = 0; i < result.size(); i++) {
                    if(result.get(i) > temp) {
                        if(result.get(k) > temp) {
                            k++;
                        }
                        result.add(i, temp);
                        break;
                    }
                }
                if(i == result.size() - 1) {
                    result.add(temp);
                }
                n++;
            } else {
                int numericValue = Character.getNumericValue(s.charAt(2));
                if (s.startsWith("U")) {
                    if(k - numericValue < 0) {
                        k = 0;
                    } else {
                        k -= numericValue;
                    }
                } else {
                    if(k + numericValue > n - 1) {
                        k = n - 1;
                    } else {
                        k += numericValue;
                    }
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for (boolean b : original) {
            if(!b) {
                answer.append("O");
            } else {
                answer.append("X");
            }
        }

        return String.valueOf(answer);
    }
}
