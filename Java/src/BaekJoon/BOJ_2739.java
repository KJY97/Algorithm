package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2739 {

	/**
	 * 문제
	 *  구구단 N단 출력하기
	 *   - 출력형식 맞춰야 함(n * 1 = n)
	 *   
	 * 시간 : 84 ms
	 * 메모리 : 11772 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d\n", N, i, N*i);
		}
	}

}
