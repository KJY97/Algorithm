package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16916 {

	/**
	 * 문제
	 *  문자열 S의 부분 문자열이란, 문자열의 연속된 일부를 의미한다.
	 *  예를 들어, "aek", "joo", "ekj"는 "baekjoon"의 부분 문자열이고, "bak", "p", "oone"는 부분 문자열이 아니다.
	 *  문자열 S와 P가 주어졌을 때, P가 S의 부분 문자열이면 1, 아니면 0을 출력한다.
	 *   - 두 문자열은 빈 문자열이 아니며, 길이는 100만을 넘지 않는다.
	 *   - 알파벳 소문자로만 이루어져 있다.
	 *   
	 * => kmp 알고리즘 사용
	 * 
	 * 시간 : 316 ms
	 * 메모리 : 29928 kb
	 */
	private static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String search = br.readLine();
		String pattern = br.readLine();
		
		result = 0;
		
		// 부분일치 테이블 만들기
		int[] table = makeTable(pattern);
		
		// kmp 알고리즘 탐색
		KMP(search, pattern, table);
		
		System.out.println(result);
	}
	
	// 부분일치 테이블 만들기
	public static int[] makeTable(String pattern) {
		int size = pattern.length();
		int[] table = new int[size];
		
		int idx = 0;
		for (int i = 1; i < size; i++) {
			// 일치하는 문자가 발생했을 때(idx>0), 연속적으로 더 일치하지 않으면 idx = table[idx-1]로 돌려준다.
			while(idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) {
				idx = table[idx-1];
			}
			
			if(pattern.charAt(i) == pattern.charAt(idx)) {
				idx += 1;
				table[i] = idx;
			}
		}
		
		return table;
	}
	
	public static void KMP(String search, String pattern, int[] table) {
		int idx = 0; // 현재 대응되는 글자 수
		
		for (int i = 0; i < search.length(); i++) {
			// idx번 글자와 글자가 불일치할 경우 다시 매칭을 시작하기 위해 table[idx-1]로 글자수를 줄인다.
			while(idx > 0 && search.charAt(i) != pattern.charAt(idx)) {
				idx = table[idx - 1];
			}
			
			// 글자가 대응할 경우
			if (search.charAt(i) == pattern.charAt(idx)) {
				// idx값이 pattern을 길이에 도달했다면 문자열 매칭에 성공한 것이므로 탐색 종료
				// 즉, pattern은 search 문자열의 부분 문자열이 맞다!
				if (idx == pattern.length()-1) {
					result = 1;
					break;
				}
				else idx++;
			}
		}	
	}

}
