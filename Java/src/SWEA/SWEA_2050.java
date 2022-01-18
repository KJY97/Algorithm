package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2050 {

	/**
	 * 문제
	 *  알파벳으로 이루어진 문자열을 입력 받아 각 알파벳을 1부터 26까지의 숫자로 변환하여 출력하기
	 *   - 문자열의 최대 길이는 200
	 *   
	 * 시간: 108 ms
	 * 메모리: 19,900 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		for (int i = 0; i < str.length(); i++) {
			System.out.printf("%d ", str.charAt(i) - 'A' + 1);
		}
	}

}
