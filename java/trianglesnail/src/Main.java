import java.util.ArrayList;
import java.util.List;
// 1
// 2 3

// 1
// 2 6
// 3 4 5

// 1
// 2 9
// 3 10 8
// 4 5 6 7

// 1
// 2 12
// 3 13 11
// 4 14 15 10
// 5 6 7 8 9
class Solution {
	public static List<Integer> solution(int n) {
		List<Integer> answer = new ArrayList<>();
		int [][] top = new int[n][n];

		for (int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				top[i][j] = 0;
			}
		}

		for (int i = 0; i < n; i++){
			top[i][0] = i + 1;
			if(i == n - 1){

			}
		}

		return answer;
	}
}

public class Main {

	public static void main(String[] args) {
		System.out.println(Solution.solution(4));
	}
}