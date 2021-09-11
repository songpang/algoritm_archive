package codingtest.Kakao2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Kakao_4 {
    @Test
    public void test() {
        Assertions.assertEquals(new int[]{1,2,3}, solution(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3}));
    }

    public int[] solution(int n, int[] info) {
        int aPeach = 0;
        for (int i = 0; i < 11; i++) {
            if(info[i] != 0) {
                aPeach += (10 - i);
            }
        }

        find(0, aPeach, 0, info, n, new boolean[11]);
        if(max == 0) {
            return new int[]{-1};
        }

        int[] answer = new int[11];
        for (int i = 0; i < 11; i++) {
            if(resultVisit[i]) {
                answer[i] = info[i] + 1;
            }
        }

        int restShot = n - Arrays.stream(answer).sum();
        if(restShot != 0) {
            answer[10] += restShot;
        }

        System.out.println(Arrays.toString(resultVisit));
        System.out.println(Arrays.toString(answer));

        return answer;
    }

    static int max = 0;
    static boolean[] resultVisit = new boolean[11];

    public static void find(int lionSum, int aPeachSum, int count, int[] info, int lionShot, boolean[] visited) {
        if(lionShot >= 0) {
            if(max < lionSum - aPeachSum) {
                max = lionSum - aPeachSum;
                resultVisit = visited.clone();
            } else if (max == lionSum - aPeachSum) {
                for (int i = 10; i >= 0 ; i--) {
                    if(visited[i] && !resultVisit[i]) {
                        max = lionSum - aPeachSum;
                        resultVisit = visited.clone();
                    } else if (!visited[i] && resultVisit[i]) {
                        break;
                    }
                }
            }
        }

        if(lionShot < 0) {
            return;
        }

        for (int i = count; i < 11; i++) {
            if(!visited[i]) {
                if(info[i] != 0) {
                    visited[i] = true;
                    find(lionSum + (10 - i), aPeachSum - (10 - i),count + 1, info, lionShot - info[i] - 1, visited);
                    visited[i] = false;
                } else {
                    visited[i] = true;
                    find(lionSum + (10 - i), aPeachSum,count + 1, info, lionShot - 1, visited);
                    visited[i] = false;
                }
            }
        }
    }
}