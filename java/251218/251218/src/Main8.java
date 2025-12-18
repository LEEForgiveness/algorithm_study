//                     remove index real
// 1, 2, 3, 4, 5, 6, 7  3       2   3 - 1
// 1, 2, 4, 5, 6, 7     6       4   2 + 3 - 1
// 1, 2, 4, 5, 7        2       1   (4 + 3 - 1) % len
// 1 4 5 7              7       3   (1 + 3 - 1) % len
// 1 4 5                1       0   (4 + 3 - 1) % len

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main8 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s[] = bufferedReader.readLine().split(" ");
        int index = Integer.parseInt(s[1]) - 1;
        List<Integer> arr = IntStream.rangeClosed(1, Integer.parseInt(s[0]))
            .boxed()
            .collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < Integer.parseInt(s[0]); i++) {
            index = index % arr.size();
            sb.append(arr.get(index));
            arr.remove(index);
            if(arr.size() == 0){
                break;
            }
            sb.append(", ");
            index += (Integer.parseInt(s[1]) - 1);
        }
        sb.append(">");
        System.out.println(sb.toString());
    }
}
