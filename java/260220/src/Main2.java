import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {
    static int n,m;
    static int[] arr;
    static int[] result;
    static List<int[]> visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        result = new int[m];
        visited = new ArrayList<>();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0, 0);
    }

    static void dfs(int start, int depth){
        if (depth == m) {
            int[] clone = result.clone();
            for (int[] list: visited){
                if (Arrays.equals(list, result)) {
                    return;
                }
            }
            visited.add(clone);
//            System.out.println(Arrays.toString(clone));
            for (int i: clone){
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.print("\n");
            return;
        }
        for (int i = start; i < arr.length; i++) {
            result[depth] = arr[i];
            dfs(i, depth + 1);
        }
    }
}
