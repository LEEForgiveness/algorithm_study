import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3 {
    static ArrayList<ArrayList<Integer>> tree;
    static int[] parents;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        tree = new ArrayList<>();
        parents = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            tree.get(parent).add(child);
            tree.get(child).add(parent);
        }

//        System.out.println(tree);
        dfs(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }
    }

    static void dfs(int start){
        visited[start] = true;
        for (int i = 0; i < tree.get(start).size(); i++) {
            if (!visited[tree.get(start).get(i)]) {
                dfs(tree.get(start).get(i));
            } else {
                parents[start] = tree.get(start).get(i);
            }
        }
    }
}
