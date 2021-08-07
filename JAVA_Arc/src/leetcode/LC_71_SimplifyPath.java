package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class LC_71_SimplifyPath {
    public static void main(String[] args) {
        String temp = simplifyPath("/../");
        System.out.println(temp );
    }

    public static String simplifyPath(String path) {
        Stack<String> st = new Stack<>();

        String[] pathSplit = path.split("/");

        for (int i = 0; i < pathSplit.length; i++) {
            if (pathSplit[i].equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
                continue;
            }

            if (pathSplit[i].equals(".") || pathSplit[i].equals("")) {
                continue;
            }

            st.push(pathSplit[i]);
        }

        StringBuilder sb = new StringBuilder();

        if(st.isEmpty()) {
            return "/";
        }

        for (String s : st) {
            if (!s.equals("")) {
                sb.append("/").append(s);
            }
        }
        return sb.toString();
    }
}
