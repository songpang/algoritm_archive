package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SWEA_1873 {
    static final int[][] DIRECTION = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static Map<String, Integer> dirDic = new HashMap<>();

    public static void main(String args[]) throws Exception {
        dirDic.put("^", 0);
        dirDic.put("v", 1);
        dirDic.put("<", 2);
        dirDic.put(">", 3);
        dirDic.put("U", 0);
        dirDic.put("D", 1);
        dirDic.put("L", 2);
        dirDic.put("R", 3);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int userCount = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= userCount; test_case++) {
            int[] input = new int[2];
            int count = 0;
            // 행열 받기
            for (String s : br.readLine().split(" ")) {
                input[count++] = Integer.parseInt(s);
            }

            String[][] gameMap = new String[input[0]][input[1]];
            int[] curL = {0, 0};
            int curD = 0;

            for (int i = 0; i < input[0]; i++) {
                count = 0;
                for (String s : br.readLine().split("")) {
                    if (s.equals("^") || s.equals("v") || s.equals("<") || s.equals(">")) {
                        curL = new int[]{i, count};
                        curD = dirDic.get(s);
                    }
                    gameMap[i][count++] = s;
                }
            }

            br.readLine();
            String curSymbol = "";
            for (String command : br.readLine().split("")) {
                if (!command.equals("S")) {
                    curD = dirDic.get(command);
                    switch (command) {
                        case "U":
                            curSymbol = "^";
                            break;
                        case "D":
                            curSymbol = "v";
                            break;
                        case "L":
                            curSymbol = "<";
                            break;
                        case "R":
                            curSymbol = ">";
                            break;
                    }
                }

                moveForward(curL, curD);
                if (curL[0] < 0 || curL[1] < 0
                        || curL[0] >= input[0] || curL[1] >= input[1]) {
                    moveBack(curL, curD);
                    gameMap[curL[0]][curL[1]] = curSymbol;
                    continue;
                }

                int[] curS = new int[]{curL[0], curL[1]};
                if (command.equals("S")) {
                    // 강철이 아닌 것 다 부수고 강철이면 그 전에서 포탄 끝
                    moveBack(curL, curD);

                    while (curS[0] >= 0 && curS[1] >= 0 && curS[0] < input[0] && curS[1] < input[1]) {
                        if (gameMap[curS[0]][curS[1]].equals("#")) {
                            break;
                        } else if (gameMap[curS[0]][curS[1]].equals("*")) {
                            gameMap[curS[0]][curS[1]] = ".";
                            break;
                        } else {
                            moveForward(curS, curD);
                        }
                    }
                } else {
                    if (!gameMap[curL[0]][curL[1]].equals(".")) {
                        moveBack(curL, curD);
                        gameMap[curL[0]][curL[1]] = curSymbol;
                    } else {
                        gameMap[curL[0]][curL[1]] = curSymbol;
                        moveBack(curS, curD);
                        gameMap[curS[0]][curS[1]] = ".";
                    }
                }
            }

            System.out.printf("#%d ", test_case);
            StringBuilder sb = new StringBuilder();
            for (String[] strings : gameMap) {
                for (String string : strings) {
                    sb.append(string);
                }
                System.out.println(sb.toString());
                sb.setLength(0);
            }
        }
    }

    private static void moveBack(int[] curL, int curD) {
        curL[0] -= DIRECTION[curD][0];
        curL[1] -= DIRECTION[curD][1];
    }

    private static void moveForward(int[] curL, int curD) {
        curL[0] += DIRECTION[curD][0];
        curL[1] += DIRECTION[curD][1];
    }
}
