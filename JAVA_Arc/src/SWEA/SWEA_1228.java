package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SWEA_1228 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();;

        for (int t = 1; t <= 10; t++) {
            br.readLine();
            String[] code = br.readLine().split(" ");
            List<String> origin = new ArrayList<>(Arrays.asList(code));

            int S = Integer.parseInt(br.readLine());
            String[] modification = br.readLine().split("I");

            for (int i = 1; i <= S; i++) {
                String[] temp = modification[i].split(" ");

                for (int j = 0; j < Integer.parseInt(temp[2]); j++) {
                    int codeIdx = Integer.parseInt(temp[1]) + j;
                    if (codeIdx >= origin.size()) {
                        break;
                    }
                    origin.add(codeIdx, temp[3 + j]);
                }
            }

            sb.append("#").append(t).append(" ");
            for (int j = 0; j < 10; j++) {
                sb.append(origin.get(j)).append(" ");
            }
            System.out.println(sb.toString());
            sb.setLength(0);
        }
    }
}
