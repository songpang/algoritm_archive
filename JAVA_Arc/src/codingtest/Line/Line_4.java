package codingtest.Line;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Line_4 {

    @Test
    public void test() {
        Assertions.assertEquals(new int[]{1,5,9,3,7,11,2,6,10,4,8,12}, solution(12));
    }

    public int[] solution(int n) {
        int p = 1;
        int len = n;
        int[] result = new int[n];

        for (int i = 1; i <= n; i++) {
            result[i - 1] = i;
        }

        while(len != 1) {
            Queue<Integer> queue = new LinkedList<>();
            for (int val : result) {
                queue.add(val);
            }

            for (int i = 2; i < n; i++) {
                if(len % i == 0) {
                    p = i;
                    break;
                }
            }

            int idx = 0;
            while(!queue.isEmpty()) {
                for (int i = idx; i < idx + len / p; i++) {
                    int pLast = i;
                    while(pLast < idx + len) {
                        result[pLast] = queue.poll();
                        pLast += len / p;
                    }
                }
                idx += len;
            }
            len /= p;
        }

        return result;
    }
}
