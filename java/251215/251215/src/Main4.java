import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int guests = Integer.parseInt(bufferedReader.readLine());
        String[] sizes = bufferedReader.readLine().split(" ");
        String[] amount = bufferedReader.readLine().split(" ");


        int T = 0;
        for (int i = 0; i < sizes.length; i++) {
            if(Integer.parseInt(sizes[i]) == 0){
                continue;
            }
            int plus = (Integer.parseInt(sizes[i]) % Integer.parseInt(amount[0])) == 0 ? Integer.parseInt(sizes[i]) / Integer.parseInt(amount[0]) : Integer.parseInt(sizes[i]) / Integer.parseInt(amount[0]) + 1;
            T += plus;
        }
        System.out.println(T);
        int P1 = guests / Integer.parseInt(amount[1]);
        int P2 = guests % Integer.parseInt(amount[1]);
        System.out.print(P1 + " ");
        System.out.println(P2);
    }
}
