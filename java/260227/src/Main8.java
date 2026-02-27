import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main8 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        int count = 1;
        while(t --> 0){
            List<String> list = new ArrayList<>();
            int n = Integer.parseInt(bf.readLine());
            for (int i = 1; i <= 6; i++) {
                for (int j = 1; j <= 6; j++) {
                    if (i + j == n) {
                        StringBuilder sb = new StringBuilder();
                        int min = Math.min(i, j);
                        int max = Math.max(i, j);
                        sb.append("(").append(min).append(",").append(max).append(")");
                        if (!list.contains(sb.toString())) {
                            list.add(sb.toString());
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Case ").append(count).append(":").append("\n");
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i)).append("\n");
            }
            System.out.print(sb.toString());
            count++;
        }
    }
}
