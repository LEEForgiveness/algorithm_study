class Solution {
	public static String solution(String new_id) {
		//1
		new_id = new_id.toLowerCase();
		//2
		new_id = new_id.replaceAll("[^a-zA-Z0-9._-]","");
		//3
		new_id = new_id.replaceAll("[.]{2,}", ".");
		//4
		new_id = new_id.replaceAll("^[.]|[.]$", "");
		//5
		if(new_id.isEmpty()){
			new_id = "a";
		}
		//6
		if (new_id.length() > 15){
			new_id = new_id.substring(0,15);
		}

		new_id = new_id.replaceAll("[.]$", "");
		//7
		while (new_id.length() < 3) {
			new_id += new_id.charAt(new_id.length() - 1);
		}
		return new_id;
	}
}

public class Main {
	public static void main(String[] args) {
		System.out.println(Solution.solution("...!@BaT#*..y.abcdefghijklm"));
		System.out.println(Solution.solution("z-+.^."));
		System.out.println(Solution.solution("=.="));
		System.out.println(Solution.solution("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}
}