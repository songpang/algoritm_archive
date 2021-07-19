package ssafy;

public class DigitTest2 {
    public static void main(String[] args) {
        int spaceCount = 0;
        int numberCount = 0;
        boolean flag = false;

        for(int i = 1; i < 18; ++i) {
            System.out.printf("%3d", i);
            ++numberCount;
            int j;
            if (!flag) {
                if (numberCount + 2 * spaceCount == 5) {
                    ++spaceCount;
                    System.out.println();

                    for(j = 0; j < spaceCount; ++j) {
                        System.out.print("   ");
                    }

                    numberCount = 0;
                    if (5 - 2 * spaceCount == 1) {
                        flag = true;
                    }
                }
            } else if (numberCount + 2 * spaceCount == 5) {
                System.out.println();

                for(j = 0; j < spaceCount - 1; ++j) {
                    System.out.print("   ");
                }

                --spaceCount;
                numberCount = 0;
            }
        }

    }
}
