import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        List<int[]> people = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int[] person = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            people.add(person);
        }
        int[] rank = new int[people.size()];
        for (int i = 0; i < people.size(); i++) {
            int defeat = 1;
            for (int j = 0; j < people.size(); j++) {
                if(i == j){
                    continue;
                }

                if(people.get(i)[0] < people.get(j)[0] && people.get(i)[1] < people.get(j)[1]){
                    defeat++;
                }
            }
            rank[i] = defeat;
        }
        for (int i = 0; i < rank.length; i++) {
            System.out.print(rank[i] + " ");
        }
    }
}
