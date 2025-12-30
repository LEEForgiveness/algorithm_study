import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, String> passwords = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            String site = st.nextToken();
            String password = st.nextToken();
            passwords.put(site, password);
        }

        for (int i = 0; i < m; i++) {
            String site = bf.readLine();
            bw.write(passwords.get(site) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
