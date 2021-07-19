package hackerRank;

public class BiggerIsGreater {
    public static String biggerIsGreater(String w) {
        if(w.length() == 1) {
            return "no answer";
        }
        char[] wToChar = w.toCharArray();

        for (int i = wToChar.length - 1; i > 0; --i) {
            if(wToChar[i] > wToChar[i-1]) {
                for (int j = wToChar.length - 1; j >= i ; --j) {
                    if(wToChar[j] > wToChar[i-1]) {
                        char temp = wToChar[j];
                        wToChar[j] = wToChar[i - 1];
                        wToChar[i - 1] = temp;
                        break;
                    }
                }
                int k = wToChar.length - 1;
                while(i < k) {
                    char temp1 = wToChar[i];
                    wToChar[i] = wToChar[k];
                    wToChar[k] = temp1;
                    i++; k--;
                }
                break;
            }
        }
        String result = new String(wToChar);
        return result;
    }
}
