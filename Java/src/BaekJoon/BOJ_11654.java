package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11654 {

	/**
	 * 문제
	 *  알파벳 소문자, 대문자, 숫자 0-9 중 하나가 주어졌을 때, 해당 글자의 아스키 코드값 출력하기
	 *   
	 * 시간 : 84 ms
	 * 메모리 : 11472 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char ch = br.readLine().charAt(0);
		System.out.println((int)ch);
	}

}
