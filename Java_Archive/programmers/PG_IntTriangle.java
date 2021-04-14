//public class PG_IntTriangle {
//    private static int answer = -1;
//
//    public static void main(String[] args) {
//        solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
//        System.out.println(answer);
//    }
//
//    public static int solution(int[][] triangle) {
//        int triLength = triangle.length;
//        int[][] checked = new int[triLength][triLength];
//
//        for (int i = 0; i < triLength; i++) {
//            for (int j = 0; j < i; j++) {
//                checked[i][j] = 0;
//            }
//        }
//
//        dfs(0, triangle, triangle[0][0], checked);
//
//        return answer;
//    }
//
//    public static void dfs(int depth, int[][] triangle, int prev, int[][] checked) {
//        if (depth == triangle.length) {
//            return;
//        }
//
//        if (prev > answer) {
//            answer = prev;
//        }
//
//        for (int i = 0; i < triangle.length; i++) {
//            dfs(depth+1, triangle, prev+triangle[i][]);
//        }
//
//    }
//}
