import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Main4 {
    public static void main(String[] args) {
        Map<Integer, int[]> graph = new HashMap<>();

        graph.put(1, new int[] {2, 3 ,4});
        graph.put(2, new int[] {1, 5});
        graph.put(3, new int[] {1, 6, 7});
        graph.put(4, new int[] {1, 8});
        graph.put(5, new int[] {2, 9});
        graph.put(6, new int[] {3, 10});
        graph.put(7, new int[] {3});
        graph.put(8, new int[] {4});
        graph.put(9, new int[] {5});
        graph.put(10, new int[] {6});

        System.out.println(bfs(graph, 1).toString());
    }

    static List<Integer> bfs(Map<Integer, int[]> graph, int startNode){
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            visited.add(current);
            for (int i: graph.get(current)){
                if (!visited.contains(i)) {
                    queue.add(i);
                }
            }
        }

        return visited;
    }
}
