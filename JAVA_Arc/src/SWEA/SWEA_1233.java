package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nodes = new String[200];
        int M, result;
        String[] temp;

        for (int t = 1; t <= 10; t++) {
            M = Integer.parseInt(br.readLine());
            for (int i = 0; i < M; i++) {
                nodes[i] = br.readLine();
            }

            result = 1;
            for (int i = 0; i < nodes.length / 2; i++) {
                temp = nodes[i].split(" ");
                if (temp[1].equals("-") || temp[1].equals("+") ||
                        temp[1].equals("*") || temp[1].equals("/")) {
                    // 자식이 두놈이 있는가?
                    if (temp.length != 4) {
                        result = 0;
                        break;
                    }
                } else {
                    // 자식이 있는가?
                    if (temp.length != 2) {
                        result = 0;
                        break;
                    }
                }
            }

            System.out.printf("#%d %d\n", t, result);
        }
    }
    // 자식이 없거나 하나인데 연산자이거나
    // 자식이 2명 다 있는데 숫자이거나
    //
    // 연산자에 자식이 없거나 하나일 때

    // 연산자 자식이 연산자여도
    // 그 밑에 숫자 두놈이 있으면 된다.

    // 연산자 밑에 자식이 하나거나 없거나
    // 숫자는 자식이 숫자면 안됨.
}
