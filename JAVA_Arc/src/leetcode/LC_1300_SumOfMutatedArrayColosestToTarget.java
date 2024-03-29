package leetcode;

import java.util.Arrays;

public class LC_1300_SumOfMutatedArrayColosestToTarget {
    public static void main(String[] args) {
        int temp = findBestValue(new int[]{2, 2}, 3);
        System.out.println(temp);
    }

    public static int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);

        int sum = Arrays.stream(arr).sum();
        int diff = Math.abs(sum - target);
        double calTemp = (double) target / (double) arr.length;

        if(calTemp - Math.round(calTemp) == -0.5) {
            calTemp = calTemp - 0.5;
        } else {
            calTemp = Math.round(calTemp);
        }
        int result = (int) calTemp;
        if (sum <= target) {
            return arr[arr.length - 1];
        } else {
            for (int j = arr.length - 2; j >= 0; j--) {
                int temp = arr[j];
                for (int i = j; i < arr.length; i++) {
                    sum -= (arr[i] - temp);
                    arr[i] = temp;
                }

                double count = 0;
                if (diff >= Math.abs(sum - target)) {
                    diff = Math.abs(sum - target);
                    if (arr[j] < result) {
                        int tempSum = 0;
                        for (int t = 0; t <= j; t++) {
                            tempSum += arr[t];
                        }
                        target -= tempSum;
                        count = (double) target / (double) (arr.length - (j + 1));
                        if(count - Math.round(count) == -0.5) {
                            count = count - 0.5;
                        } else {
                            count = Math.round(count);
                        }
                        return (int) count;
                    }
                } else {
                    // 0 ~ j-1
                    int tempSum = 0;
                    for (int t = 0; t <= j; t++) {
                        tempSum += arr[t];
                    }
                    target -= tempSum;
                    count = (double) target / (double) (arr.length - (j + 1));
                    if(count - Math.round(count) == 0.5) {
                        count = count - 0.5;
                    } else {
                        count = Math.round(count);
                    }
                    return (int) count;
                }
            }

            return result;
        }
    }
}
