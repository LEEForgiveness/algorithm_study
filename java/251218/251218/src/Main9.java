import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main9 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int start = Integer.parseInt(stringTokenizer.nextToken());
        int end = Integer.parseInt(stringTokenizer.nextToken());
        List<Integer> primeNumbers = primeNumber(end);
        for (int i = 0; i < primeNumbers.size(); i++) {
            if(start <= primeNumbers.get(i)){
                bufferedWriter.write(primeNumbers.get(i));
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
    static List<Integer> primeNumber(int end){
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i <= end; i++) {
            boolean check = true;
            for(Integer number: primeNumbers){
                if(i % number == 0){
                    check = false;
                    break;
                }
            }
            if(check){
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }
}
//통과안됨 ㅠㅠ