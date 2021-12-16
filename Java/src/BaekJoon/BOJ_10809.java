package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10809 {
	/**
	 * 문제
	 *  알파벳 소문자로만 이루어진 단어 S가 주어진다. 각각의 알파벳에 대해서 아래 조건에 맞게 출력하라
	 *   - 단어에 포함되어 있는 경우에는 "처음" 등장하는 위치를 출력
	 *   - 포함되어 있지 않은 경우에는 -1을 출력
	 *   - 단어 길이는 100을 넘지 않는다.
	 *   
	 * 시간 : 76 ms
	 * 메모리 : 11500 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int[] alphabet = new int[26];
		Arrays.fill(alphabet, -1); // -1로 배열 초기화
		
		for (int i = 0; i < str.length(); i++) {
			int idx = str.charAt(i) - 'a';
			if(alphabet[idx] == -1)
				alphabet[idx] = i;
		}
		
		for (int i = 0; i < alphabet.length; i++) {
			System.out.print(alphabet[i] + " ");
		}
	}

}
