package programmers;

import java.util.ArrayList;
import java.util.List;

public class PG_TravelRoute {
    public static List<String> answer = new ArrayList<>();

    public static void main(String[] args) {
        for (String s : solution(new String[][]{{"ICN","A"},{"A","B"},{"B","A"},{"A","ICN"},{"ICN","A"}})) {
            System.out.println(s);
        }
    }
    public static String[] solution(String[][] tickets) {
        boolean visited[] = new boolean[tickets.length];
        String[] temp = {"", ""};
        char max = '[';

        int tempIndex = 0;
        for (int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];
            if (ticket[0].equals("ICN") && max > ticket[1].charAt(0)) {
                max = ticket[1].charAt(0);
                temp = ticket;
                tempIndex = i;
            }
        }

        visited[tempIndex] = true;
        answer.add("ICN");
        answer.add(temp[1]);

        findRoute(tickets, visited, answer);

        return answer.toArray(new String[0]);
    }

    public static void findRoute(String[][] tickets, boolean[] visited, List<String> route) {
        if(route.size() -1 == tickets.length) {
            if(answer.size() == route.size()) {
                for (int i = 0; i < route.size(); i++) {
                    if(!answer.get(i).equals(route.get(i))) {
                        if(answer.get(i).charAt(0) > route.get(i).charAt(0)) {
                            answer.clear();
                            answer.addAll(route);
                            return;
                        }
                        return;
                    }
                }
            }
            answer.clear();
            answer.addAll(route);
            return;
        }

        List<String> tempResult = new ArrayList<>();
        tempResult.addAll(route);

        String lastCountry = tempResult.get(tempResult.size()-1);
        for (int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];
            if (ticket[0].equals(lastCountry) && !visited[i]) {
                visited[i] = true;
                tempResult.add(ticket[1]);
                findRoute(tickets, visited, tempResult);
                visited[i] = false;
                tempResult.remove(tempResult.size()-1);
            }
        }
    }
}
