package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class PG_KAKAO_DivideExamVenue {
    public static void main(String[] args) {
        solution(3, new int[]{12, 30, 1, 8, 8, 6, 20, 7, 5, 10, 4, 1},
                new int[][]{{-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {8, 5}, {2, 10},
                        {3, 0}, {6, 1}, {11, -1}, {7, 4}, {-1, -1}, {-1, -1}});

        System.out.println(minGroup);
    }

    static int minGroup;
    static int[] roots;
    static int size;
    static int[] rootMax;

    public static int solution(int k, int[] num, int[][] links) {
        int root = -1;
        minGroup = Integer.MAX_VALUE;

        size = num.length;
        boolean[] visited = new boolean[size];
        // 아무도 자신을 자식노드로 갖고있지 않으면 그게 루트노드
        for (int i = 0; i < size; i++) {
            if (links[i][0] != -1) visited[links[i][0]] = true;
            if (links[i][1] != -1) visited[links[i][1]] = true;
        }

        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                root = i;
                break;
            }
        }


        roots = new int[k];
        roots[0] = root;

        combination(1, 0, k, num, links);
        return minGroup;
    }

    public static void combination(int count, int start, int k, int[] num, int[][] links) {
        if (count == k) {
            // root 만들고 k 개

            Queue<Integer> venueQ;
            int localMax = 0;
            for (int i : roots) {
                venueQ = new LinkedList<>();
                int rootMax = num[i];

                venueQ.add(links[i][0]);
                venueQ.add(links[i][1]);

                loop:
                while (!venueQ.isEmpty()) {
                    if (venueQ.peek() == -1) {
                        venueQ.poll();
                        continue;
                    }

                    int temp = venueQ.poll();
                    // root인지 아닌지 검사
                    for (int rt : roots)
                        if (temp == rt) continue loop;

                    rootMax += num[temp];
                    venueQ.add(links[temp][0]);
                    venueQ.add(links[temp][1]);
                }

                localMax = Math.max(localMax, rootMax);

                if (localMax > minGroup) {
                    return;
                }
            }

            minGroup = Math.min(minGroup, localMax);
            return;
        }

        for (int i = start; i < size; i++) {
            roots[count] = i;
            combination(count + 1, i + 1, k, num, links);
        }
    }
/*
    2차 제출 코드
    1차와 같음.
    -> 각 루트노드 당 인원값을 저장해야겠다고 생각하고 코드 리팩토링
    static int minGroup;
    static int[] roots;
    static int size;

    public static int solution(int k, int[] num, int[][] links) {
        int root = -1;
        minGroup = Integer.MAX_VALUE;

        size = num.length;
        boolean[] visited = new boolean[size];
        // 아무도 자신을 자식노드로 갖고있지 않으면 그게 루트노드
        for (int i = 0; i < size; i++) {
            if (links[i][0] != -1) visited[links[i][0]] = true;
            if (links[i][1] != -1) visited[links[i][1]] = true;
        }

        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                root = i;
                break;
            }
        }
        roots = new int[k];
        roots[0] = root;

        combination(1, 0, k, num, links);
        return minGroup;
    }

    public static void combination(int count, int start, int k, int[] num, int[][] links) {
        if (count == k) {
            // root 만들고 k 개

            Queue<Integer> venueQ;
            int localMax = 0;
            for (int i : roots) {
                venueQ = new LinkedList<>();
                int rootMax = num[i];

                venueQ.add(links[i][0]);
                venueQ.add(links[i][1]);

                loop:
                while (!venueQ.isEmpty()) {
                    if (venueQ.peek() == -1) {
                        venueQ.poll();
                        continue;
                    }

                    int temp = venueQ.poll();
                    // root인지 아닌지 검사
                    for (int rt : roots)
                        if (temp == rt) continue loop;

                    rootMax += num[temp];
                    venueQ.add(links[temp][0]);
                    venueQ.add(links[temp][1]);
                }

                localMax = Math.max(localMax, rootMax);

                if (localMax > minGroup) {
                    return;
                }
            }

            minGroup = Math.min(minGroup, localMax);
            return;
        }

        for (int i = start; i < size; i++) {
            roots[count] = i;
            combination(count + 1, i + 1, k, num, links);
        }
    }
 */
    /* 1차 제출 코드.
        정확성 PASS
        효율성 FAIL

    static int minGroup;

    public static int solution(int k, int[] num, int[][] links) {
        List<Node> examVenue = new ArrayList<>();
        int root = -1;
        minGroup = Integer.MAX_VALUE;

        int size = num.length;
        boolean[] visited = new boolean[size];
        // 아무도 자신을 자식노드로 갖고있지 않으면 그게 루트노드
        for (int i = 0; i < size; i++) {
            examVenue.add(new Node(links[i][0], links[i][1], i, num[i]));
            if (links[i][0] != -1) visited[links[i][0]] = true;
            if (links[i][1] != -1) visited[links[i][1]] = true;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                root = i;
                break;
            }
        }
        int[] roots = new int[k];
        roots[0] = root;

        combination(1, 0, examVenue, roots, k);
        return minGroup;
    }

    public static void combination(int count, int start, List<Node> list, int[] root, int k) {
        if (count == k) {
            // root 만들고 k 개
            Node tempRoot;

            Queue<Integer> venueQ;
            int localMax = 0;
            for (int i : root) {
                venueQ = new LinkedList<>();
                tempRoot = list.get(i);
                int rootMax = tempRoot.count;

                venueQ.add(tempRoot.left);
                venueQ.add(tempRoot.right);

                loop:
                while (!venueQ.isEmpty()) {
                    if (venueQ.peek() == -1) {
                        venueQ.poll();
                        continue;
                    }

                    int temp = venueQ.poll();
                    // root인지 아닌지 검사
                    for (int rt : root)
                        if (temp == rt) continue loop;

                    Node n = list.get(temp);
                    rootMax += n.count;
                    venueQ.add(n.left);
                    venueQ.add(n.right);
                }

                localMax = Math.max(localMax, rootMax);
            }

            minGroup = Math.min(minGroup, localMax);
            return;
        }

        for (int i = start; i < list.size(); i++) {
            root[count] = i;
            combination(count + 1, i + 1, list, root, k);
        }
    }

    static class Node {
        int number;
        int left;
        int right;
        int count;

        public Node(int left, int right, int number, int count) {
            this.left = left;
            this.right = right;
            this.number = number;
            this.count = count;
        }
    }

     */
}
