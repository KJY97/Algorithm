package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1259 {

	/**
	 * 문제
	 *  단어를 뒤에서부터 읽어도 똑같다면 그 단어를 팰린드롬이라고 부른다.
	 *  각 줄마다 주어진 수가 팰린드롬이면 'yes', 아니면 'no'를 출력
	 *   - 0이 주어지면 종료
	 *   - 1 이상 99999 이하의 정수가 주어짐
	 *   
	 * 시간 : 72 ms
	 * 메모리 : 11276 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String num = br.readLine();
			
			if(num.equals("0")) break;
			
			if(checkPalindrome(num)) 
				System.out.println("yes");
			else 
				System.out.println("no");
		}
	}
	
	public static boolean checkPalindrome(String str) {
		int last = str.length() - 1;
		for (int i = 0; i < str.length()/2; i++) {
			// idx 처음과 끝을 비교해간다.
			if(str.charAt(i) != str.charAt(last - i)) return false;
		}
		return true;
	}

}
