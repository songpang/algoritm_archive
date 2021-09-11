package codingtest.Line;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Line_1 {
    @Test
    public void test() {
        Assertions.assertEquals(8, solution(new int[]{0, 1, 0, 0, 1, 1, 0}, 2));
    }

    public int solution(int[] student, int k) {
        List<Integer> points = new ArrayList<>();

        int studentSize = student.length;
        for (int i = 0; i < studentSize; i++) {
            if (student[i] == 1) {
                points.add(i);
            }
        }

        int pSize = points.size();
        if (pSize < k) {
            return 0;
        }

        int totalCount = 0;
        for (int i = 0; i < pSize; i++) {
            int zeroCount = 0;
            int temp = points.get(i);
            if (i == 0) {
                zeroCount += points.get(i);
            } else {
                zeroCount += temp - points.get(i - 1) - 1;
            }

            if (i + k - 1 >= pSize) {
                break;
            } else {
                temp = points.get(i + k - 1);
                if (i + k - 1 == pSize - 1) {
                    zeroCount += studentSize - 1 - temp;
                } else {
                    zeroCount += points.get(i + 1) - temp;
                }
            }

            totalCount += 2 * zeroCount;
        }

        return totalCount;
    }
// 0 0 1 0 1 0 0

}















