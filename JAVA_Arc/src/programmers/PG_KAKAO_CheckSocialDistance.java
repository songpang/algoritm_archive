package programmers;

import java.util.ArrayList;
import java.util.List;

public class PG_KAKAO_CheckSocialDistance {

    public static void main(String[] args) {
        Integer[] test1 = new Integer[]{1, 2};
        Integer[] test2 = new Integer[]{2, 2};

        String[][] test3 = new String[][]{{"POOOP", "OXXOX", "PXXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        for (int i : solution(test3)) {
            System.out.println(i);
        }
    }

    public static int[] solution(String[][] places) {
        List<Integer> answer = new ArrayList<>();

        for (String[] place : places) {
            List<Integer[]> temp = new ArrayList<>();
            // P위치 저장하고
            for (int j = 0; j < 5; j++) {
                for (int i = 0; i < 5; i++) {
                    if (place[j].charAt(i) == 'P') {
                        temp.add(new Integer[]{j, i});
                    }
                }
            }

            if (temp.size() < 2) {
                answer.add(1);
                continue;
            }

            //1, 1
            // 각 P까지 거리 구하고
            // 1이 있으면 무조건 X 2 있으면 벽있나 판별
            wayOut:
            for (int i = 0; i < temp.size() - 1; i++) {
                for (int j = i + 1; j < temp.size(); j++) {
                    Integer[] tP1 = temp.get(i);
                    Integer[] tP2 = temp.get(j);
                    double result = getManhattanDistance(tP1, tP2);

                    if (result < 2) {
                        answer.add(0);
                        break wayOut;
                    } else if (result == 2) {
                        if (tP1[1].equals(tP2[1])
                                && place[tP1[0] + 1].charAt(tP1[1]) == 'X') {
                        } else if (tP1[0].equals(tP2[0])
                                && place[tP1[0]].charAt(tP1[1] + 1) == 'X') {
                        } else if (place[tP1[0] + 1].charAt(tP1[1]) == 'X'
                                && place[tP2[0] - 1].charAt(tP2[1]) == 'X') {
                        } else {
                            answer.add(0);
                            break wayOut;
                        }
                    }
                }

                if (i == temp.size() - 2) {
                    answer.add(1);
                }
            }
        }
        int[] answer2 = answer.stream().mapToInt(Integer::intValue).toArray();

        return answer2;
    }

    public static double getManhattanDistance(Integer[] ind1, Integer[] ind2) {
        return Math.abs(ind1[0] - ind2[0]) + Math.abs(ind1[1] - ind2[1]);
    }
}
