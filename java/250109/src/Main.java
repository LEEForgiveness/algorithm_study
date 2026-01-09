import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("IOI");
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());
        String s = bf.readLine();
        String p1 = "IOI";
        sb.append("OI".repeat(Math.max(0, n - 1)));
        String pn = sb.toString();
        int count = 0;
        for (int i = 0; i <= m - pn.length(); i++) {
            if (s.substring(i, i + pn.length()).contains(pn)) {
                i += 1;
                count++;
            }
        }
        System.out.println(count);
    }
}
