import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int result = 2147483647;
        int height = 0;

        for (int i = 0; i < 257; i++) {
            int count = 0;
            int currentBlock = b;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    int block = map[j][k] - i;
                    if (block < 0) {
                        count += Math.abs(block);

                    } else {
                        count += (2 * block);
                    }
                    currentBlock += block;
                }
            }
            System.out.println("height: " + i + " count: " + count + " currentBlock: " + currentBlock);
            if (currentBlock >= 0 && count <= result) {
                result = count;
                height = i;
            }
        }

        System.out.print(result + " ");
        System.out.println(height);
    }
}
