import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(bf.readLine(), 1);
        }

        for (int i = 0; i < m; i++) {
            String input = bf.readLine();
            map.put(input, map.getOrDefault(input, 0) + 1);
        }
        int count = 0;
        List<String> search = new ArrayList<>();
        for (String key : map.keySet()){
            if(map.get(key) > 1){
                count++;
                search.add(key);
            }
        }

        sb.append(String.valueOf(count)).append("\n");
        Collections.sort(search);

        for (int i = 0; i < search.size(); i++) {
            if(i == search.size() - 1){
                sb.append(search.get(i));
                break;
            }
            sb.append(search.get(i)).append("\n");
        }

        System.out.println(sb.toString());
    }
}
