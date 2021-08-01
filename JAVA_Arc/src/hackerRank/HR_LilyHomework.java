package hackerRank;

import java.util.*;

public class HR_LilyHomework {
    public static void main(String[] args) {
        List<Integer> temp2 = new ArrayList<>();
        temp2.add(3);
        temp2.add(4);
        temp2.add(2);
        temp2.add(5);
        temp2.add(1);
        int temp = lilysHomework(temp2);
        System.out.println(temp);
    }

    public static int lilysHomework(List<Integer> arr) {
        List<Integer> sorted = new ArrayList<>(arr);
        List<Integer> sortedReverse = new ArrayList<>(arr);
        List<Integer> arr2 = new ArrayList<>(arr);

        sorted.sort(Comparator.naturalOrder());
        sortedReverse.sort(Comparator.reverseOrder());

        int count = getCount(arr, sorted);
        int count2 = getCount(arr2, sortedReverse);

        return Math.min(count, count2);
    }

    private static int getCount(List<Integer> arr, List<Integer> sorted) {
        Map<Integer, Integer> matching = new HashMap<>();
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            matching.put(arr.get(i), i);
        }

        for (int i = 0; i < arr.size(); i++) {
            int temp = arr.get(i);
            int temp2 = matching.get(temp);
            int temp3 = matching.get(sorted.get(i));

            if(temp2 != temp3) {
                matching.put(sorted.get(i), temp2);
                matching.put(temp, temp3);
                arr.set(temp3, arr.get(i));
                count++;
                //3 4 2 5 1
            }
        }
        return count;
    }


    // Write your code here
    // 정렬 먼저 하고
    // arr1, arr2 같은 것 제거
    // 3 4 2 5 1
    // 1 4 2 5 3
    // 1 2 4 5 3
    // 1 2 3 5 4
    // 1 2 3 4 5

    // 5 4 2 5 1  (5, 3), (3, 2)
    // 5 4 3 5 1  (3, 2)

    // 5 4 3 2 1
    // 1 2 3 4 5

    // a[0] = 3;
    // != 0 ->
    //
}
