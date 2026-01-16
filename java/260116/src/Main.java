import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solve(bf.readLine()));
    }

    static int solve(String number){
        int result = 0;
        boolean[] used = new boolean[number.length()];
        Set<Integer> numbers = new HashSet<>();
        getNumbers("", number, used, numbers);
        List<Integer> numberList = new ArrayList<>(numbers);
        for (int i = 0; i < numberList.size(); i++) {
            if(getPrimeNumber(numberList.get(i))){
                result++;
            }
        }
        return result;
    }

    static boolean getPrimeNumber(int number){
        if (number == 2) {
            return true;
        } else if(number == 0 || number == 1){
            return false;
        }
        for (int i = 2; i < number; i++) {
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }

    static void getNumbers(String cur, String original, boolean[] used, Set<Integer> numbers){
        if(!cur.isEmpty()){
            numbers.add(Integer.parseInt(cur));
        }
        if (cur.length() == original.length()){
            return;
        }

        for (int i = 0; i < original.length(); i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            getNumbers(cur + original.charAt(i), original, used, numbers);
            used[i] = false;
        }
    }
}
