import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());

        if (n == 0) {
            bw.write(String.valueOf(0));
            bw.flush();
            bw.close();
        } else {
            int exclusion = Math.toIntExact(Math.round(n * 0.15));
            List<Integer> rates = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                rates.add(Integer.valueOf(bf.readLine()));
            }
            rates.sort(((o1, o2) -> o1 - o2));
            int total = 0;
            int avg = 0;
            for (int i = exclusion; i < rates.size() - exclusion; i++) {
                total += rates.get(i);
            }
            avg = Math.toIntExact(Math.round((float) total / (rates.size() - (exclusion * 2))));
            bw.write(String.valueOf(avg));
            bw.flush();
            bw.close();
        }
    }
}