import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        dfs(n, m, 0, 0);
    }

    static void dfs(int n, int m, int start, int depth){
        if (depth == m) {
            for (int i: arr){
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < n; i++) {
            arr[depth] = i + 1;
            dfs(n, m, i,depth + 1);
        }
    }
}
