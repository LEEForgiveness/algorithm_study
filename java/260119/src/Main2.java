import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main2{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solve(Integer.parseInt(bf.readLine())));
    }
    static int[] dp = new int[50001];
    static List<Integer> list = new ArrayList<>();
    static int solve(int i){
        for (int j = 1; j <= i; j++) {
            double sqrt = Math.sqrt(j);
            if (sqrt % 1 == 0) {
                dp[j] = 1;
                list.add(j);
            } else {
                int min = dp[j - 1];
                for (int k = 1; k < list.size(); k++) {
                    if (min > dp[j - list.get(k)]) {
                        min = dp[j - list.get(k)];
                    }
                }
                dp[j] = min + 1;
            }
        }
        return dp[i];
    }
}