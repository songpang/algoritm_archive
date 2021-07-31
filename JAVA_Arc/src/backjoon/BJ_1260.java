package backjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ_1260 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Node> nodes = new ArrayList<>();

        int[] members = new int[3];
        for (int i = 0; i < 3; i++) {
            members[i] = scanner.nextInt();
        }

        int[] visited = new int[members[0]];

        for (int i = 0; i < members[1]; i++) {
            int tempNumber = scanner.nextInt();
            if(nodes.size() == i) {
                nodes.add(new Node(tempNumber, scanner.nextInt()));
                System.out.println("here");
            } else {
                nodes.get(tempNumber).addAdjacent(scanner.nextInt());
                System.out.println("22");
            }
        }

        for (Node node : nodes) {
            System.out.println(node);
        }
    }
}

class Node {
    int number;
    List<Integer> adjacentNode = new ArrayList<>();

    public Node(int number, int adjacent) {
        this.number = number;
        adjacentNode.add(adjacent);
    }

    public void addAdjacent(int adjacent) {
        adjacentNode.add(adjacent);
    }

    @Override
    public String toString() {
        return "Node{" +
                "number=" + number +
                ", adjacentNode=" + adjacentNode +
                '}';
    }
}
