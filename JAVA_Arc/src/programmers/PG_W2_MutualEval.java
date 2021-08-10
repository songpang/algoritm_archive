package programmers;

public class PG_W2_MutualEval {
    static char[] grade = {'A', 'A', 'B', 'C', 'D', 'D', 'F', 'F', 'F', 'F', 'F'};

    public static String solution(int[][] scores) {
        String answer = "";
        int[] students = new int[scores.length];
        int only, max, min, count;
        int[] result = new int[scores.length];

        for (int i = 0; i < scores.length; i++) {
            // 자기 자신 저장
            only = scores[i][i];
            max = 0;
            min = Integer.MAX_VALUE;
            count = scores.length;

            for (int j = 0; j < scores.length; j++) {
                if (i != j) {
                    if (scores[i][j] > max) {
                        max = scores[i][j];
                    } else if (scores[i][j] < min) {
                        min = scores[i][j];
                    }
                }
                students[i] += scores[i][j];
            }

            if (only > max) {
                students[i] -= only;
                count--;
            } else if (only < min) {
                students[i] -= only;
                count--;
            }

            result[i] = students[i] / count;
            answer += grade[10 - result[i]/10];
        }
        return answer;
    }
}
