package leetcode;

public class LC_ContainerWithMostWater {
    public static void main(String[] args) {

        int temp = maxArea(new int[]{10, 9, 1, 1, 1, 1, 5, 2});
        System.out.println(temp);
    }

    //투포인터로 성능 대폭 개선.
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        int H;

        while(left < right) {
            H = Math.min(height[left], height[right]);
            max = Math.max(max, H * (right - left));
            if(height[left] > height[right]) {
                right--;
                continue;
            }
            left++;
        }

        return max;
    }

    //조금 개선했지만 여전히 O(n^2)이라 그런지 실패.
//    public static int maxArea(int[] height) {
//        int prev = height[height.length - 1];
//        int max = Math.min(height[0], height[height.length - 1]) * (height.length - 1);
//
//        for (int i = 0; i < height.length - 1; i++) {
//            prev = height[height.length - 1];
//            for (int j = height.length - 1; j > i; j--) {
//                if (prev <= height[j]) {
//                    int realH = Math.min(height[i], height[j]);
//                    max = Math.max(max, realH * (j - i));
//                    prev = height[j];
//                }
//            }
//        }
//        return max;
//    }

//    // Time Limit Exceeded
//    public int maxArea(int[] height) {
//        int max = 0;
//
//        for (int i = 0; i < height.length - 1; i++) {
//            for (int j = height.length - 1; j > 0; j--) {
//                int realH = Math.min(height[i], height[j]);
//                max = Math.max(max, realH * (j - i));
//            }
//        }
//        return max;
//    }


}
