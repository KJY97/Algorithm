package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11720 {

	/**
	 * 문제
	 *  공백없이 쓰여진 N개의 숫자를 모두 합하기
	 *   
	 * 시간 : 72 ms
	 * 메모리 : 11480 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 숫자의 개수. 1 ≤ N ≤ 100
		String num = br.readLine();
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += num.charAt(i) - '0';
		}
		System.out.println(sum);
	}

}
