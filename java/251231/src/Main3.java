import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Main3 {
    public static void main(String[] args) {
        Map<Integer, int[]> graph = new HashMap<>();

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

        System.out.println(dfs(graph, 1).toString());
    }

    static List<Integer> dfs(Map<Integer, int[]> graph, int startNode){
        List<Integer> visited = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            visited.add(current);
            for (int i: graph.get(current)){
                if (!visited.contains(i)) {
                    stack.push(i);
                }
            }
        }

        return visited;
    }
}
