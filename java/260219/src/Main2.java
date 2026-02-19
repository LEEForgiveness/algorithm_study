import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {
    static int n,m, result;
    static List<int[]> chickens, homes;
    static boolean[] used;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        chickens = new ArrayList<>();
        homes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 2) {
                    chickens.add(new int[] {i, j});
                } else if(input == 1){
                    homes.add(new int[] {i, j});
                }
            }
        }
        result = Integer.MAX_VALUE;
        used = new boolean[chickens.size()];
        dfs(0, 0);
        System.out.println(result);
    }

    static void dfs(int start, int depth){
        if (depth == m) {
            int sum = 0;
            for (int[] home: homes) {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < chickens.size(); i++) {
                    if (used[i]) {
                        int temp = Math.abs(chickens.get(i)[0] - home[0]) + Math.abs(chickens.get(i)[1] - home[1]);
                        min = Math.min(temp, min);
                    }
                }
                sum += min;
            }
            result = Math.min(result, sum);
            return;
        } else {
            for (int i = start; i < chickens.size(); i++) {
                used[i] = true;
                dfs(i + 1, depth + 1);
                used[i] = false;
            }
        }
    }
}
