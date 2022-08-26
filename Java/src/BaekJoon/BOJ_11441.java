package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11441 {

	/**
	 * 문제
	 *  N개의 수 A1, A2, ..., AN이 입력으로 주어진다. 총 M개의 구간 i, j가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
	 *   - 수의 개수 N (1 ≤ N ≤ 100,000), 구간의 개수 M (1 ≤ M ≤ 100,000)
	 *   - A1 ~ AN 범위 : -1,000 ≤ Ai ≤ 1,000
	 *   - 각 구간을 나타내는 i와 j (1 ≤ i ≤ j ≤ N)
	 *   - 시간 제한 1초
	 * 
	 * => 100,000 x 1000 = 100,000,000 (1억) 이므로 합의 범위는 Integer
	 * => 반복문으로 start ~ end로 구하기에는 O(MN) 
	 *    즉 100,000 x 100,000 = 10,000,000,000 이다.
	 *    1초는 대략 1억번 계산이 가능하다고 할 때 이를 넘어가므로 DP를 활용한다.
	 * => 시간 초과 발생하여 StringBuilder 사용
	 * 
	 * 시간: 648 ms
	 * 메모리: 61580 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine()); // 수의 개수
		int[] arr = new int[N+1]; // 1부터 사용
		
		// N개의 수 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 메모이제이션(DP)을 활용하여 시간 단축하기
		int[] memo = new int[N+1];
		for (int i = 1; i <= N; i++) {
			memo[i] = memo[i-1] + arr[i];
		}
		
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine()); // 구간의 개수
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			sb.append(memo[end] - memo[start-1]).append('\n');
		}
		
		System.out.println(sb.toString());
	}

}
