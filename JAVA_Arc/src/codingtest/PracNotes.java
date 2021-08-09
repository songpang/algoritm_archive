package codingtest;

import java.util.ArrayList;
import java.util.List;

public class PracNotes {
    static int[] num = {5, 8, 3, 4, 1};
    static boolean[] visited;

    public static void main(String[] args) {
        String name = ",..,";
        name = name.replace(",", " he").replace(".", "hi");
        System.out.println(name);
    }
}