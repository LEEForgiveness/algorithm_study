import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.List;

public class Main6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        List<String[]> people = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] strings = bufferedReader.readLine().split(" ");
            people.add(strings);
        }
        people.sort((a, b) -> {
            if (Integer.parseInt(a[0]) != Integer.parseInt(b[0])){
                return Integer.parseInt(a[0]) - Integer.parseInt(b[0]);
            } else{
                return Integer.parseInt(b[0]) - Integer.parseInt(a[0]);
            }
        });
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i)[0] + " " + people.get(i)[1]);
        }
    }
}
