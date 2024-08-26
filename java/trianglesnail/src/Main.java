import java.util.ArrayList;
import java.util.List;

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
		}

		//todo https://school.programmers.co.kr/learn/courses/30/lessons/68645 완성

		return answer;
	}
}

public class Main {

	public static void main(String[] args) {
		System.out.println(Solution.solution(4));
	}
}