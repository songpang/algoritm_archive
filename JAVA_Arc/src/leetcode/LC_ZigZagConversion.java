package leetcode;

import java.util.Arrays;

/*
  LeetCode 6. ZigZag
  순서를 뒤집을 때는 분기점에서 -1을 곱하자 !
 */
public class LC_ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
    }

    public static String convert(String s, int numRows) {
        StringBuilder[] resultArr = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            resultArr[i] = new StringBuilder();
        }

        int count = 0;
        int pl = 1;
        for (char c : s.toCharArray()) {
            resultArr[count].append(c);
            if (numRows > 1) {
                count += pl;
                if (count == 0 || count == numRows - 1) {
                    pl *= -1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder s1 : resultArr) {
            sb.append(s1);
        }
        return sb.toString();
    }


}
