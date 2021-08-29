package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 백준 2628 종이 자르기
// 솔루션 보기 전까지 헤매었던 문제
// 단순 구현

public class BJ_2628 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int cut = Integer.parseInt(br.readLine());

        List<Integer> rowList = new ArrayList<>();
        List<Integer> colList = new ArrayList<>();
        rowList.add(row);
        colList.add(col);

        for (int i = 0; i < cut; i++) {
            st = new StringTokenizer(br.readLine());
            int dir =Integer.parseInt(st.nextToken());
            int line =Integer.parseInt(st.nextToken());

            if(dir == 0) {
                splitLine(colList, line);
            } else {
                splitLine(rowList, line);
            }
        }

        int max = 0;
        for (int i = 0; i < colList.size(); i++) {
            int colTemp = colList.get(i);
            for (int j = 0; j < rowList.size(); j++) {
                int size = colTemp * rowList.get(j);
                max = Math.max(max, size);
            }
        }

        System.out.println(max);
    }

    private static void splitLine(List<Integer> rowList, int line) {
        for (int j = 0; j < rowList.size(); j++) {
            int temp = rowList.get(j);
            if(line > temp) {
                line -= temp;
            } else {
                rowList.remove(j);
                rowList.add(j, temp-line);
                rowList.add(j, line);
                break;
            }
        }
    }
}
