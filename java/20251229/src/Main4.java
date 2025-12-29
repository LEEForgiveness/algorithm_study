import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        int m = Integer.parseInt(bf.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            switch (st.nextToken()){
                case "add":
                    int input = Integer.parseInt(st.nextToken());
                    set.add(input);
                    break;
                case "check":
                    int checkNumber = Integer.parseInt(st.nextToken());
                    if(set.contains(checkNumber)){
                        sb.append("1").append("\n");
                    } else {
                        sb.append("0").append("\n");
                    }
                    break;
                case "remove":
                    int removeNumber = Integer.parseInt(st.nextToken());
                    set.remove(removeNumber);
                    break;
                case "toggle":
                    int toggleNumber = Integer.parseInt(st.nextToken());
                    if (set.contains(toggleNumber)) {
                        set.remove(toggleNumber);
                    } else {
                        set.add(toggleNumber);
                    }
                    break;
                case "all":
                    set = new HashSet(
                        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
                    break;
                case "empty":
                    set = new HashSet<>();
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
