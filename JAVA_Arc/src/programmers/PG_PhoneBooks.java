package programmers;

import java.util.Arrays;

public class PG_PhoneBooks {
    public static void main(String[] args) {
        String[] newstring = new String[]{"12","123","1235","567","88", "123466", "1534", "1444", "1900", "10", "17"};
        Arrays.sort(newstring);
        for (String s : newstring) {
            System.out.print(s + " ");
        }
    }

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length-1; i++) {
            if(phone_book[i+1].length() >= phone_book[i].length() && phone_book[i+1].startsWith(phone_book[i])) {
                //phone_book[i+1].startsWith(phone_book[i]) 로 줄일 수 있음.
                return false;
            }
        }
        return true;
    }
}
