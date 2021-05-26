package algoForBank;

/*
Next Permutation
Permutation 순서에서 다음 Permutation 순서를 찾는 알고리즘

 */
import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        //Test
        int[] array = {0, 1, 1, 1, 4};
        do {
            System.out.println(Arrays.toString(array));
        } while (nextPermutation(array));
    }

    public static boolean nextPermutation(int[] array) {
        int i = array.length - 1;

        while (i > 0 && array[i - 1] >= array[i])
            i--;

        if (i <= 0)
            return false;

        int j = array.length - 1;
        while (array[j] <= array[i - 1])
            j--;

        int temp = array[i-1];
        array[i-1] = array[j];
        array[j] = temp;

        j = array.length - 1;
        while(i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

        return true;
    }
}
