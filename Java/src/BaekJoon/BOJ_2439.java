package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2439 {

	/**
	 * 문제
	 *  첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
	 *   - 오른쪽 기준으로 정렬
	 *   
	 * 시간: 216 ms
	 * 메모리: 13304 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 1 ≤ N ≤ 100

		for (int i = 0; i < N; i++) {
			
			// 공백 출력
			for (int j = 0; j < N-1-i; j++) {
				System.out.print(" ");
			}
			
			// 별 출력
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
