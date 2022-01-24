package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1989 {

	/**
	 * 문제
	 *  거꾸로 읽어도 제대로 읽은 것과 같은 문장이나 낱말을 회문(回文, palindrome)이라 한다.
	 *  단어를 입력 받아 회문이면 1을 출력하고, 아니라면 0을 출력하는 프로그램 작성하기
	 *   -  3 이상 10 이하
	 *   
	 * 시간: 100 ms
	 * 메모리: 18,568 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String str = br.readLine();
			
			int ans = isPalindrome(str, str.length()) ? 1 : 0;
			
			System.out.println("#" + test_case + " " + ans);
		}

	}
	public static boolean isPalindrome(String str, int N) {
		for (int i = 0; i < N; i++) {
			if(str.charAt(i) != str.charAt(N-1-i)) 
				return false;
		}
		return true;
	}

}
