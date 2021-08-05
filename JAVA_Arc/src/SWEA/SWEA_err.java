package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_err {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String origin[];
        int M = Integer.parseInt(br.readLine());
        String[] code = br.readLine().split(" ");

        int S = Integer.parseInt(br.readLine());
        String[] modification = br.readLine().split("I");

        for (int i = 1; i <= S; i++) {
            String[] temp = modification[i].split(" ");
            for (int j = Integer.parseInt(temp[1]); j <= Integer.parseInt(temp[2]); j++) {
                if (j >= code.length) {
                    break;
                }
                code[j] = temp[3 + j];
            }
            System.out.println(Arrays.toString(temp));
        }

        System.out.println(Arrays.toString(code));
        System.out.println(Arrays.toString(modification));

    }

//    public static int[] modifyCode(int[] origin, int[][] modification) {
//
//    }
}
