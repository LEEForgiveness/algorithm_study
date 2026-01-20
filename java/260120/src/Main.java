import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] stairs = new int[n + 1];
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int input = Integer.parseInt(bf.readLine());
            stairs[i] = input;
        }
        if (n >= 1) {
            result[1] = stairs[1];
        }
        if (n >= 2) {
            result[2] = stairs[1] + stairs[2];
        }
        if (n >= 3) {
            for (int i = 3; i <= n; i++) {
                result[i] = Math.max(result[i - 2] + stairs[i], result[i - 3] + stairs[i - 1] + stairs[i]);
            }
        }
        System.out.println(result[n]);
    }
}