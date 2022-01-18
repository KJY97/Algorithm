package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2047 {

	/**
	 * 문제
	 *  입력으로 주어진 문장에 모든 소문자 알파벳을 찾아 대문자로 변환한 다음, 그 결과를 출력하는 프로그램을 작성
	 *   - 문자열의 최대 길이는 80 bytes
	 *   
	 * 시간: 98 ms
	 * 메모리: 16,076 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		System.out.println(text.toUpperCase());
	}

}
