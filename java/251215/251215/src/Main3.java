import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String[] input = bf.readLine().split(" ");
            List<Integer> numbers = new ArrayList<>();
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            if (a == 0 && b == 0 && c == 0){
                break;
            }

            numbers.add(a);
            numbers.add(b);
            numbers.add(c);
            Collections.sort(numbers);

            if(Math.pow(numbers.get(0), 2) + Math.pow(numbers.get(1), 2) == Math.pow(numbers.get(2), 2)){
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
