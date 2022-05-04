package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726 {

	/**
	 * 문제
	 *  2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
	 *  아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.
	 *   - 1 ≤ n ≤ 1,000
	 * 
	 * => 세로는 반드시 2로 고정이다!
	 * 
	 * 시간 : 80 ms
	 * 메모리 : 11516 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] memo = new int[N+2];
		memo[0] = 1; // 점화식을 맞추기 위해 임의의 값 저장
		memo[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			memo[i] = (memo[i-1] + memo[i-2]) % 10007;
		}
		System.out.println(memo[N]);
	}

}
