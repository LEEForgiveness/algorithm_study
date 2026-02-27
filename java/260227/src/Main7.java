import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        double a = Integer.parseInt(st.nextToken());
        double i = Integer.parseInt(st.nextToken());

        for (int j = 1; j <= a * i; j++) {
            if (Math.ceil(j / a) == i) {
                System.out.println(j);
                break;
            }
        }
    }
}
