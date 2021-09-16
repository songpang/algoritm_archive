// 언어 : JAVA , 메모리 : 68MB , 시간 : 691.17ms

package programmers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PG_KAKAO17_GroupPhoto {

    @Test
    public void test() {
        Assertions.assertEquals(3648, solution(2, new String[]{"N~F=0", "R~T>2"}));
        Assertions.assertEquals(0, solution(2, new String[]{"M~C<2", "C~M>1"}));
        // TDD
    }

    static char[] family = {'A', 'C', 'F', 'N', 'M', 'J', 'R', 'T'};

    static class Operation {
        char f1;
        char f2;
        char op;
        int seat;

        public Operation(char f1, char f2, char op, int seat) {
            this.f1 = f1;
            this.f2 = f2;
            this.op = op;
            this.seat = seat;
        }
    }
    static int answer;

    // 전역변수를 함수 안에서 초기화 해주지 않아서 틀렸던 문제.
    public int solution(int n, String[] data) {
        int size = data.length;
        Operation[] ops = new Operation[size];

        for (int i = 0; i < size; i++) {
            char c1 = data[i].charAt(0);
            char c2 = data[i].charAt(2);
            char c3 = data[i].charAt(3);
            int i1 = data[i].charAt(4) - '0';

            ops[i] = new Operation(c1, c2, c3, i1);
        }
        answer = 0;
        permutation(0, new boolean[8], new char[8], ops);
        return answer;
    }

    // 순열을 이용해서 해결.
    public static void permutation(int count, boolean[] visited, char[] output, Operation[] ops) {
        if (count == 8) {
            // 만든 output 을 ops로 검사
            for (Operation op : ops) {
                int loc1 = 0;
                int loc2 = 0;
                for (int i = 0; i < 8; i++) {
                    if(output[i] == op.f1) {
                        loc1 = i;
                    } else if(output[i] == op.f2) {
                        loc2 = i;
                    }
                }

                int seat = op.seat;
                int diff = Math.abs(loc1 - loc2);
                // 바로 옆일경우 거리는 1
                // seat가 2 초과이면 0 1 1 1 0 배치, 그래서 거리가 4임.
                switch (op.op) {
                    case '=':
                        if(diff - 1 != seat) return;
                        break;
                    case '>':
                        if(diff - 1 <= seat) return;
                        break;
                    case '<':
                        if(diff - 1 >= seat) return;
                        break;
                }
            }

            answer++;
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[count] = family[i];
                permutation(count + 1, visited, output, ops);
                visited[i] = false;
            }
        }
    }
}
