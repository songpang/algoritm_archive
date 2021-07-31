package codingtest;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
/*
zum CT
 */
public class ZUM_1 {
    public static void main(String[] args) {
        int[] test = solution(new int[][]{{1, 0, 5}, {2, 2, 2}, {3, 3, 1}, {4, 4, 1}, {5, 10, 2}});
        int[] test1 = solution(new int[][]{{1, 0, 3}, {2, 1, 3}, {3, 3, 2}, {4, 9, 1}, {5, 10, 2}});
        int[] test2 = solution(new int[][]{{1, 2, 10}, {2, 5, 8}, {3, 6, 9}, {4, 20, 6}, {5, 25, 5}});

        for (int i : test2) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[][] data) {
        PriorityQueue<PracNotes.PaperQ> pq = new PriorityQueue<>();
        List<Integer> answer = new ArrayList<>();

        pq.add(new PracNotes.PaperQ(data[0][0], data[0][1], data[0][2]));
        int flag = 1;
        int time = data[0][1];

        while(!pq.isEmpty()) {
            PracNotes.PaperQ temp = pq.poll();
            time += temp.pages;
            answer.add(temp.number);

            if(flag < data.length) {
                for (int j = flag; j < data.length; j++) {
                    if (data[j][1] <= time) {
                        flag++;
                        pq.add(new PracNotes.PaperQ(data[j][0], data[j][1], data[j][2]));
                        continue;
                    }
                    break;
                }
                if(pq.isEmpty()) {
                    time = data[flag][1];
                    pq.add(new PracNotes.PaperQ(data[flag][0], data[flag][1], data[flag++][2]));
                }
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static class PaperQ implements Comparable<PracNotes.PaperQ>{
        int number;
        int time;
        int pages;

        public PaperQ(int number, int time, int pages) {
            this.number = number;
            this.time = time;
            this.pages = pages;
        }

        @Override
        public int compareTo(PracNotes.PaperQ paperQ) {
            if (this.pages > paperQ.pages)
                return 1;
            else if (this.pages < paperQ.pages)
                return -1;
            else if (this.time > paperQ.time)
                return 1;
            else if (this.time < paperQ.time)
                return -1;
            return 0;
        }
    }
}
