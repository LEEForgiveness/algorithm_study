import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());
        char[] s = bf.readLine().toCharArray();
        int count = 0;
        int result = 0;

        for (int i = 1; i <= m - 2; i++) {
            if (s[i - 1] == 'I' && s[i] == 'O' && s[i + 1] == 'I') {
                count++;
                if (count == n) {
                    count--;
                    result++;
                }
                i++;
            } else {
                count = 0;
            }
        }
        System.out.println(result);
    }
}
