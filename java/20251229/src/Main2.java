import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            list.add(Integer.valueOf(bf.readLine()));
        }
        Collections.sort(list);
        int result1 = 0;
        int result2 = list.get(list.size() / 2);
        int result3 = 0;
        int result4 = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
            map.put(list.get(i), map.getOrDefault(list.get(i), 0) + 1);
        }
        result1 = Math.round((float) sum / list.size());
        result4 = list.get(list.size() - 1) - list.get(0);

        List<Integer> list1 = new ArrayList<>();
        Integer max = Collections.max(map.values());
        for (Integer key : map.keySet()) {
            if (map.get(key).equals(max)) {
                list1.add(key);
            }
        }
        Collections.sort(list1);
        if (list1.size() > 1) {
            result3 = list1.get(1);
        } else {
            result3 = list1.get(0);
        }
        sb.append(result1).append("\n");
        sb.append(result2).append("\n");
        sb.append(result3).append("\n");
        sb.append(result4);
        System.out.println(sb.toString());
    }
}
