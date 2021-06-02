package hackerRank;

import java.util.List;

public class EmasSupercomputer {
//    public static void main(String[] args) {
//        String temp = String.format("%10s", "").replace(" ", "G");
//        System.out.println(temp);
//    }
//
//    public static int twoPluses(List<String> grid) {
//        int n = grid.size();
//        int m = grid.get(0).length();
//        char[][] temp = new char[n][m];
//
//        int flag = 0;
//        for (String s : grid) {
//            temp[flag++] = s.toCharArray();
//        }
//
//        for (int i = 1; i < n - 1; i++) {
//            for (int j = 1; j < m - 1; j++) {
//                int r = 0;
//                while(temp[i][j+r] == 'G'
//                   && temp[i][j-r] == 'G'
//                   && temp[i+r][j] == 'G'
//                   && temp[i-r][j] == 'G') {
//                    temp[i][j+r] = temp[i][j-r] = temp[i+r][j] = temp[i-r][j] = 'g';
//                }
//                for (int I = 1; I < n - 1; I++) {
//                    for (int J = 1; J < m - 1; J++) {
//                        while(temp[I][j+r] == 'G'
//                                && temp[i][j-r] == 'G'
//                                && temp[i+r][j] == 'G'
//                                && temp[i-r][j] == 'G') {
//                            temp[i][j+r] = temp[i][j-r] = temp[i+r][j] = temp[i-r][j] = 'g';
//                        }
//                    }
//                }
//            }
//        }
//    }
    // 가로 라인에서 가장 긴 g 갯수 저장한 배열 생성
    // 그 배열에서 홀수 인 것만 선택
    // 이제 거기서 부터 판단
    // min, max 선언
    // 홀수인 선에서 위아래 체크
    // min, max for문 끝날 때 까지 초기화

}
