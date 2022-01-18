package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1545 {

	/**
	 * 문제
	 *  주어진 숫자 N부터 0까지 순서대로 출력하기
	 *   - 거꾸로 출력하라는 의미
	 *   
	 * 시간: 96 ms
	 * 메모리: 16,076 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = N; i >= 0; i--) {
			System.out.print(i + " ");
		}
	}

}
