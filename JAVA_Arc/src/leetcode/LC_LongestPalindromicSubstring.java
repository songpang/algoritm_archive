package leetcode;

/*
    Longest Palindromic Substring 을 구하는 문제
    Palindromic String은 거꾸로 뒤집어도 원 상태와 같은 String을 뜻함.
 */

import java.util.ArrayList;
import java.util.List;

public class LC_LongestPalindromicSubstring {

    public static void main(String[] args) {
        String temp = longestPalindrome("aacabdkacaa");
        System.out.println(temp);
    }

    public static String longestPalindrome(String s) {
        int max = 1;
        String maxS = String.valueOf(s.charAt(0));

        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if ((right - left + 1) > max) {
                    max = right - left + 1;
                    maxS = s.substring(left, right + 1);
                }
                left--;
                right++;
            }

            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if ((right - left + 1) > max) {
                    max = right - left + 1;
                    maxS = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }
        return maxS;
    }

    /*
     시간초과 : O(n^3) 인 알고리즘, O(n^2)로 줄여야함.
     */
//    public static String longestPalindrome(String s) {
//        for (int i = s.length(); i > 0; i--) {
//            List<String> reverse = makeSubs(s, i);
//            for (String s1 : reverse) {
//                if (s1.equals(reverse(s1))) {
//                    return s1;
//                }
//            }
//        }
//
//        return String.valueOf(s.charAt(0));
//    }
//
//    private static String reverse(String s1) {
//        char[] reverse = new char[s1.length()];
//
//        for (int i = 0; i < s1.length(); i++) {
//            reverse[reverse.length - i - 1] = s1.charAt(i);
//        }
//
//        return new String(reverse);
//    }
//
//    private static List<String> makeSubs(String s, int i) {
//        List<String> result = new ArrayList<>();
//
//        for (int j = 0; j < s.length() - i + 1; j++) {
//            result.add(s.substring(j, j + i));
//        }
//
//        return result;
//    }
}
