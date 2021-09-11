package codingtest.Line;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Line_2 {

    @Test
    public void test() {
        Assertions.assertEquals("x", solution(new String[] {"yxxy", "xxyyy"}, 2, 1));
    }

    public String solution(String[] research, int n, int k) {
        Map<Character, Integer> result = new HashMap<>();

        int size = research.length;
        for (int i = 0; i < size; i++) {
            Map<Character, Integer> wordCount = new HashMap<>();

            int localSize = research[i].length();
            for (int j = 0; j < localSize; j++) {
                char key = research[i].charAt(j);
                if (!wordCount.containsKey(key)) {
                    wordCount.put(key, 1);
                } else {
                    wordCount.put(key, wordCount.get(key) + 1);
                }
            }

            loop:
            for (Character character : wordCount.keySet()) {
                int localCount = wordCount.get(character);
                if (localCount >= k) {
                    // 후보임
                    int sum = localCount;

                    if(i + n > size) {
                        break;
                    }

                    for (int j = i + 1; j < i + n; j++) {
                        int specificLetterCount = 0;

                        for (int l = 0; l < research[j].length(); l++) {
                            if(research[j].charAt(l) == character) {
                                specificLetterCount++;
                            }
                        }

                        if(specificLetterCount >= k) {
                            sum += specificLetterCount;
                        } else {
                            continue loop;
                        }
                    }

                    if(!result.containsKey(character)) {
                        result.put(character, sum);
                    } else {
                        result.put(character, Math.max(sum, result.get(character)));
                    }
                }
            }
        }

        int max = 2 * n * k;
        char maxLetter = 'z' + 1;
        for (Character character : result.keySet()) {
            if(max <= result.get(character)) {
                if(maxLetter > character) {
                    maxLetter = character;
                    max = result.get(character);
                }
            }
        }

        if(maxLetter == 'z' + 1) {
            return "None";
        }
        return String.valueOf(maxLetter);
    }

    //
}
