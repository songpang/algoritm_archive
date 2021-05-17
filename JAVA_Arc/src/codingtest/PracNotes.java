package codingtest;

public class PracNotes {
    public static void main(String[] args) {
        int k = 4;
        char s = '3';

        System.out.println(s-'0');
        if((k - Character.getNumericValue(s) < 0)) {
            System.out.println("Hello");
        }
    }
}
