package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 1062 가르침
// 고민하다가 조합으로 접근
// 반례로 인해 고생
// 해결하였으나 ***너무 느림***

/*
2 7
antatica
antaktica
 */

public class BJ_1062_SetCombination {
    static int N, K, maxCount;
    static Character[] alphabet;
    static String[] words;
    static String base = "antic";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        String temp;
        // a n t i c
        if (K < 5) {
            System.out.println(0);
            return;
        }

        words = new String[N];
        int idx = 0;

        // 알파벳 중복 검사를 위해 SET
        Set<Character> noDuplicate = new HashSet<>();
        for (int i = 0; i < N; i++) {
            temp = br.readLine();
            words[idx++] = temp;
            int size = temp.length();

            // anta tica 필요 없으니 범위 제외.
            for (int j = 4; j < size - 4; j++) {
                noDuplicate.add(temp.charAt(j));
            }
        }

        for (int i = 0; i < 5; i++) {
            noDuplicate.remove(base.charAt(i));
        }

        maxCount = 0;
        alphabet = noDuplicate.toArray(new Character[0]);

        if(alphabet.length <= K - 5) {
            System.out.println(words.length);
            return;
        }

        char[] output = new char[K];
        for (int i = 0; i < 5; i++) {
            output[i] = base.charAt(i);
        }


        combination(5, 0, output);
        System.out.println(maxCount);
    }

    public static void combination(int count, int start, char[] output) {
        if (count == K) {
            int wordCount = 0;
            String temp = String.valueOf(output);
            loop:
            for (String word : words) {
                for (int i = 0; i < word.length(); i++) {
                    if (!temp.contains(String.valueOf(word.charAt(i)))) {
                        continue loop;
                    }
                }
                wordCount++;
            }

            maxCount = Math.max(wordCount, maxCount);
            return;
        }

        for (int i = start; i < alphabet.length; i++) {
            output[count] = alphabet[i];
            combination(count + 1, i + 1, output);
        }
    }
}
