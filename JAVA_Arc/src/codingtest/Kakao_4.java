package codingtest;

import java.util.Arrays;

public class Kakao_4 {
    public static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(solution(4, 1, 4, new int[][]{{1, 2, 1}, {3, 2, 1}, {2, 4, 1}}, new int[]{2, 3}));
    }

    public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
        findRoute(0, start, end, roads, traps);
        return result;
    }

    public static void findRoute(int count, int present, int end, int[][] roads, int[] traps) {
        if (present == end) {
            result = Math.min(result, count);
            return;
        }

        for (int i = 0; i < roads.length; i++) {
            //트랩이면 visited 필요없고
            // 일반 방이면 false일때만 입장
            if (roads[i][0] == present) {
                int[][] temp = new int[roads.length][roads[0].length];

                for (int j = 0; j < roads.length; j++) {
                    for (int k = 0; k < roads[0].length; k++) {
                        temp[j][k] = roads[j][k];
                    }
                }

                //트랩 확인하고 로드 바꿔 준걸 넘겨주고.
                for (int trap : traps) {
                    if (trap == roads[i][1]) {
                        //로드의 방향 바꿔줘야한다.
                        //하나만 바꾸는 게 아니라 트랩에 연결된 거 모두

                        for (int j = 0; j < roads.length; j++) {
                            if (roads[j][0] == trap || roads[j][1] == trap) {
                                temp[j] = new int[]{roads[j][1], roads[j][0], roads[j][2]};
                            }
                        }
                        break;
                    }
                }

                findRoute(count + roads[i][2], roads[i][1], end, temp, traps);
            }
        }
    }
}

/*
for (int trap : traps) {
                    if(trap == rd[0])
                        //로드의 방향 바꿔줘야한다.
                        //하나만 바꾸는 게 아니라 트랩에 연결된 거 모두
                }
 */
