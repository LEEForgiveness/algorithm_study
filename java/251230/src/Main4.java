import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int[] tree = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            tree[i] = input;
            if(max < input){
                max = input;
            }
        }

        int result = 0;
        for (int i = max; i > 0; i--) {
            int getTree = 0;
            for (int j = 0; j < n; j++) {
                if(tree[j] - i <= 0){
                    getTree += 0;
                } else {
                    getTree += (tree[j] - i);
                }
            }
            if (getTree == m) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
