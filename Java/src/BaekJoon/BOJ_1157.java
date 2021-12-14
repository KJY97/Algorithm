package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1157 {

	/**
	 * 문제
	 *  알파벳으로 이루어진 단어에서 가장 많이 사용된 알파벳은 무엇인지 알아내기
	 *   - 단어의 길이는 0 <= str.length <= 1,000,000
	 *   - 대문자로 출력
	 *   - 가장 많이 사용된 알파벳이 여러 개면 ? 출력
	 *   
	 * 시간 : 184 ms
	 * 메모리 : 20720 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int[] alphaCnt = new int[26];
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if('A' <= ch && ch <= 'Z') alphaCnt[ch-'A']++;
			else if('a' <= ch && ch <= 'z') alphaCnt[ch-'a']++;
		}
		
		int max = 0, idx = 0;
		boolean flag = false; // max와 동일한 알파벳이 또 있는지 체크
		for (int i = 0; i < 26; i++) {
			if(alphaCnt[i] == 0) continue;
			
			if(alphaCnt[i] > max) {
				max = alphaCnt[i];
				idx = i;
				flag = false;
			}
			else if(alphaCnt[i] == max) flag = true;
		}
		
		if(flag) System.out.println("?");
		else System.out.println((char)(idx+'A'));
	}

}
