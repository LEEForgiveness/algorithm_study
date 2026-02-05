import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        //(a * b) % c = (a % c * b % c) % c

        System.out.println(solve(a, b, c));
    }

    static long solve(long a, long b, long c){
        if(b == 1){
            return a % c;
        }
        long temp = solve(a, b / 2, c);
        if (b % 2 == 1) {
            return (temp * temp % c) * a % c;
        }
        return temp * temp % c;
    }
}
