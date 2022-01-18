package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2019 {

	/**
	 * 문제
	 *  1부터 주어진 횟수까지 2를 곱한 값(들)을 출력하기
	 *   - 30을 넘지 않는다
	 *   
	 * 시간: 96 ms
	 * 메모리: 16,076 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		for (int i = 0; i <= num; i++) {
			System.out.print((int)Math.pow(2, i) + " ");
		}
	}

}
