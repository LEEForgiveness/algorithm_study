import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
	public static String solution(String X, String Y) {
		StringBuilder answer = new StringBuilder();
		List<Integer> pairNumber = new ArrayList<>();
		int[] xCount = new int[10];
		int[] yCount = new int[10];

		for(int i = 0; i < X.length(); i++){
			xCount[X.charAt(i) - '0']++;
		}

		for(int i = 0; i < xCount.length; i++){
			System.out.print(xCount[i] + ",");
		}

		System.out.println();

		for(int i = 0; i < Y.length(); i++){
			yCount[Y.charAt(i) - '0']++;
		}

		for(int i = 0; i < yCount.length; i++){
			System.out.print(yCount[i] + ",");
		}

		System.out.println();

		for (int i = 0; i < xCount.length; i++){
			if (xCount[i] > 0 && yCount[i] > 0 && xCount[i] != 0){
				for (int j = 0; j < Math.min(xCount[i], yCount[i]); j++){
					pairNumber.add(i);
				}
			}
		}

		System.out.println(pairNumber);

		if(pairNumber.isEmpty()){
			return "-1";
		}

		pairNumber.sort(Comparator.reverseOrder());

		for(int i = 0; i < pairNumber.size(); i++){
			answer.append(pairNumber.get(i).toString());
		}

		if(answer.charAt(0) == '0'){
			return "0";
		}

		return answer.toString();
	}
}

public class Main {

	public static void main(String[] args) {
//		System.out.println(Solution.solution("100", "2345"));
		System.out.println(Solution.solution("100", "203045"));
//		System.out.println(Solution.solution("12321", "42531"));
//		System.out.println(Solution.solution("5525", "1255"));
	}
}