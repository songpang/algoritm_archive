package programmers;

import java.util.*;

public class PG_MaximizeArithmetic {
    public static long answer = Long.MIN_VALUE;
    public static String[] numbers;
    public static String[] ops;
    public static final String[] OPERATORS = {"+", "-", "*"};

    public static long solution(String expression) {
        boolean[] visited = new boolean[3];
        String[] per = new String[3];

        ops = expression.split("[0-9]+");
        ops = Arrays.copyOfRange(ops, 1, ops.length);

        numbers = expression.split("[+\\-*]");

        permutation(visited, per, OPERATORS, 0, 3);

        return answer;
    }

    public static void permutation(boolean[] visited, String[] output, String[] operators, int depth, int r) {
        if (depth == r) {
            calculateWith(output, numbers, ops);
            return;
        }

        for (int i = 0; i < operators.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = operators[i];
                permutation(visited, output, operators, depth + 1, r);
                visited[i] = false;
            }
        }
    }

    public static void calculateWith(String[] priority, String[] numbers, String[] operators) {
        List<Long> numbersArr = new ArrayList<>();
        List<String> opArr = new ArrayList<>(Arrays.asList(operators));

        for (String number : numbers) {
            numbersArr.add(Long.parseLong(number));
        }

        for (String s : priority) {
            for (int j = 0; j < opArr.size(); j++) {
                if (opArr.get(j).equals(s)) {
                    long temp = cal(numbersArr.get(j), numbersArr.get(j + 1), s);
                    numbersArr.remove(j);
                    numbersArr.remove(j);
                    opArr.remove(j);

                    numbersArr.add(j, temp);
                    j--;
                }
            }
        }
        answer = Long.max(answer, Math.abs(numbersArr.get(0)));
    }

    public static long cal(long num1, long num2, String operator) {
        return switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            default -> 0;
        };
    }
}


// List<String> opArr = Arrays.asList(operators);
// 이렇게 선언한 opArr 에 remove 실행하니 UnsupportedOperationException 발생