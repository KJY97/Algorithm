package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659 {

	/**
	 * 문제
	 *  수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
	 *   - 수의 개수 N, 합을 구해야 하는 횟수 M
	 *   - 입력되는 수는 1000보다 작거나 같은 자연수
	 *   - 1 ≤ N ≤ 100,000
	 *   - 1 ≤ M ≤ 100,000
	 *   - 1 ≤ i ≤ j ≤ N
	 *
	 * => 다이나믹 프로그래밍. 메모이제이션 사용
	 * 
	 * 시간 : 1956 ms
	 * 메모리 : 69432 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 수의 개수
		int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수
		
		// 메모이제이션 초기화
		int[] memo = new int[N+1]; // 1번부터 사용
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			memo[i] = memo[i-1] + num;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			System.out.println(memo[end] - memo[start-1]);
		}
	}

}
