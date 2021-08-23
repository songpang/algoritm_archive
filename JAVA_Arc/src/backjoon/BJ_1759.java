package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1759 {
    static int L, C;
    static char[] alphabets;
    static String vowel = "aeiou";
    static List<String> result;
    static char[] sorted;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        result = new ArrayList<>();
        alphabets = br.readLine().replaceAll(" ", "").toCharArray();

        combination(0, 0, new char[L]);
        Collections.sort(result);

        for (String s : result) {
            System.out.println(s);
        }
    }

    public static void combination(int count, int start, char[] output) {
        if(count == L) {
            int vowelCount = 0;
            int consonantCount = 0;
            for (char c : output) {
                if(vowel.contains(String.valueOf(c))) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }

            if(vowelCount < 1 || consonantCount < 2) {
                return;
            } else {
                sorted = output.clone();
                Arrays.sort(sorted);
                for (char c : sorted) {
                    sb.append(c);
                }

                result.add(sb.toString());
                sb.setLength(0);
            }
            return;
        }

        for (int i = start; i < C; i++) {
            output[count] = alphabets[i];
            combination(count + 1, i + 1, output);
        }
    }
}
