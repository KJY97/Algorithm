package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_11727 {

	/**
	 * 문제
	 *  2×n 직사각형을 1×2, 2×1과 2×2 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
	 *   - 1 ≤ n ≤ 1,000
	 *   
	 * 시간 : 72 ms
	 * 메모리 : 11516 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] memo = new int[N+2];
		memo[0] = 1; // 점화식을 맞추기 위해 임의의 값 저장
		memo[1] = 1; memo[2] = 3;
		
		for (int i = 3; i <= N; i++) {
			memo[i] = (memo[i-1] + memo[i-2] * 2) % 10007;
		}
		
		System.out.println(memo[N]);
	} 

}
