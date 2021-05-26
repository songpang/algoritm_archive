package hackerRank;

import java.util.Arrays;

public class BiggerIsGreater {
    public static void main(String[] args) {
        System.out.println(biggerIsGreater("aaa"));
        // abacbzyk
    }

    public static String biggerIsGreater(String w) {
        int[] priorityArr = new int[w.length()];

        int i = 0;
        for (char c : w.toCharArray()) {
            priorityArr[i] = c;
            i++;
        }

        if(w.length() == 1) {
            return "no answer";
        }

        int count = 0;
        Loop1:
        for (int j = priorityArr.length - 1; j > 0; j--) {
            for (int k = j - 1; k >= 0; k--) {
                if (priorityArr[j] > priorityArr[k]) {
                    int temp = priorityArr[j];
                    priorityArr[j] = priorityArr[k];
                    priorityArr[k] = temp;
                    count = k;
                    break Loop1;
                }
            }
            if (j == 1) {
                return "no answer";
            }
        }

        StringBuilder result = new StringBuilder();

        int[] sortedArr = Arrays.copyOfRange(priorityArr, count + 1, priorityArr.length);
        Arrays.sort(sortedArr);

        for (int i1 : sortedArr) {
            priorityArr[count + 1] = i1;
            count++;
        }

        for (int i1 : priorityArr) {
            result.append((char) i1);
        }

        return result.toString();
    }

    // 94347
    // 94334
}
