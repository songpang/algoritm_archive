package programmers;

import java.util.Arrays;

public class PG_TransformWord {

    public static void main(String[] args) {

    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        char[] beginArr = begin.toCharArray();
        char[] targetArr = target.toCharArray();
        boolean[] checked = new boolean[targetArr.length];
        for (boolean i : checked){
            i = false;
        }

        if (!Arrays.stream(words).anyMatch(str -> str == target)) {
            return 0;
        }

//        int checkNumber = 0;
//        while(checkNumber < targetArr.length) {
//            for (int i = 0; i < beginArr.length; i++) {
//                if(checked[i] != true) {
//                    for (String word: words) {
//                        if(word.)
//                    }
//                    checked[i] = true;
//                }
//            }
//        }



        return answer;
    }

}
