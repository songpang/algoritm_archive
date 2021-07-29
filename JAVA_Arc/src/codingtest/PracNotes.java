package codingtest;

public class PracNotes {
    public static void main(String[] args) {
        int space = 4;
        char start = 'A';
        int count = 1;

        while (space != 0) {
            for (int i = 0; i < space; i++) {
                System.out.print("  ");
            }

            for (int i = 0; i < count; i++) {
                System.out.print(start++ + " ");
            }

            System.out.println();
            count+= 2;
            space--;

        }
    }
}
