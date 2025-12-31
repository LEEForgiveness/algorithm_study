import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) {
        Map<Integer, int[]> graph = new HashMap<>();
        List<Integer> visited = new ArrayList<>();

        graph.put(1, new int[] {2, 5 ,9});
        graph.put(2, new int[] {1, 3});
        graph.put(3, new int[] {2, 4});
        graph.put(4, new int[] {3});
        graph.put(5, new int[] {1, 6, 8});
        graph.put(6, new int[] {5, 7});
        graph.put(7, new int[] {6});
        graph.put(8, new int[] {5});
        graph.put(9, new int[] {1, 10});
        graph.put(10, new int[] {9});

        dfs(graph, 1, visited);
        System.out.println(visited);
    }

    static void dfs(Map<Integer, int[]> graph, int startNode, List<Integer> visited){
        visited.add(startNode);
        for (int node : graph.get(startNode)){
            if (!visited.contains(node)) {
                dfs(graph, node, visited);
            }
        }
    }
}
