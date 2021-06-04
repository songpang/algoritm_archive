package programmers;


public class PG_PushKeypad {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }

    public static String solution(int[] numbers, String hand) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] left = new int[]{0, -3};
        int[] right = new int[]{2, -3};

        for (int number : numbers) {
            if (number % 3 == 2 || number == 0) {
                int[] temp;
                if (number == 0) {
                    temp = new int[]{1, -3};
                } else {
                    temp = new int[]{1, -(number / 3)};
                }

                double leftD = getDistance(left, temp);
                double rightD = getDistance(right, temp);
                if (leftD > rightD || (leftD == rightD && hand.equals("right"))) {
                    right = temp;
                    stringBuilder.append("R");
                } else {
                    left = temp;
                    stringBuilder.append("L");
                }
            } else if (number % 3 == 0) {
                stringBuilder.append("R");
                right = new int[]{2, -(number / 3 - 1)};
            } else {
                stringBuilder.append("L");
                left = new int[]{0, -(number / 3)};
            }
        }

        return stringBuilder.toString();
    }

    public static double getDistance(int[] temp, int[] xy) {

        double result = Math.abs((temp[0] - xy[0])) + Math.abs((temp[1] - xy[1]));
        return Math.sqrt(result);
    }
}
