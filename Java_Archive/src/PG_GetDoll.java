import java.util.ArrayList;
import java.util.List;

public class PG_GetDoll {
    public static void main(String[] args) {
        solution(new int[][]{{0,0,0,0,0},
                             {0,0,1,0,3},
                             {0,2,5,0,1},
                             {4,2,4,4,2},
                             {3,5,1,3,1}},
                             new int[]{1,5,3,5,1,2,1,4});

    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> bucket = new ArrayList<>();

        int depth = 0;
        int bucketCount = 0;
        for (int i = 0; i < moves.length; i++) {
            int temp = moves[i]-1;
            while (depth < board.length) {
                if (board[depth][temp] == 0) {
                    depth++;
                } else {
                    int temp2 = board[depth][temp];
                    bucket.add(temp2);
                    bucketCount++;
                    board[depth][temp] = 0;
                    break;
                }
            }
            depth = 0;
            if (bucketCount > 1 && bucket.get(bucketCount-1) == bucket.get(bucketCount-2)) {
                answer++;
                bucket.remove(bucketCount-1);
                bucketCount--;
                bucket.remove(bucketCount-1);
                bucketCount--;
            }
        }
        return answer*2;
    }
}
