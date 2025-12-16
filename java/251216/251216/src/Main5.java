import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());

        System.out.println(solve(N, K));
    }

    static int solve(int N, int K){
        if (K == 0 && N == K) {
            return 1;
        }
        int result = 0;
        int a = 1;
        int b = 1;

        for (int i = N; i > N - K; i--) {
            a = a * i;
        }

        for (int i = 1; i <= K; i++) {
            b = b * i;
        }

        result = a / b;

        return result;
    }
}
