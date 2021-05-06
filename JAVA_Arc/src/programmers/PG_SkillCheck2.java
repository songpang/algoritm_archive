package programmers;

public class PG_SkillCheck2 {
    //    boolean solution(String s) {
//        String[] splits = s.split("");
//        char[] splitss = s.toCharArray();
//        int count = 0;
//        for (char split : splitss) {
//            if (split == '(') {
//                count++;
//            } else {
//                count--;
//            }
//            if (count < 0) {
//                return false;
//            }
//        }
//
//        if (count == 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int indexX = arr1.length;
        int indexY = arr2[0].length;
        int indexK = arr2.length;

        int[][] answer = new int[indexX][indexY];

        for (int i = 0; i < indexX; i++) {
            for (int j = 0; j < indexY; j++) {
                int temp = 0;
                for (int k = 0; k < indexK; k++) {
                    temp += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = temp;
            }
        }

        return answer;
    }
}
