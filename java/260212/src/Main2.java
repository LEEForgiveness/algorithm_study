import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    static int[] arr;
    static boolean[] visited;
    static int[] inputArr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visited = new boolean[n];
        inputArr = new int[n];

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputArr);
//        System.out.println(Arrays.toString(inputArr));

        dfs(n, m, 0);
    }

    static void dfs(int n, int m, int depth){
        if (m == depth) {
            StringBuilder sb = new StringBuilder();
            for (int i: arr) {
                sb.append(i).append(" ");
            }
            System.out.println(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                arr[depth] = inputArr[i];
                visited[i] = true;
                dfs(n, m, depth + 1);
                visited[i] = false;
            }
        }
    }
}
