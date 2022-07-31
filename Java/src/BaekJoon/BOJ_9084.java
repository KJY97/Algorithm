package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9084 {

	/**
	 * 문제
	 *  우리나라 화폐단위, 특히 동전에는 1원, 5원, 10원, 50원, 100원, 500원이 있다. 
	 *  이 동전들로는 정수의 금액을 만들 수 있으며 그 방법도 여러 가지가 있을 수 있다.
	 *  예를 들어, 30원을 만들기 위해서는 1원짜리 30개 또는 10원짜리 2개와 5원짜리 2개 등의 방법이 가능하다.
	 *  동전의 종류(N)가 주어질 때에 주어진 금액(M)을 만드는 모든 방법을 세는 프로그램을 작성하시오.
	 *   - 테스트 케이스의 개수 T(1 ≤ T ≤ 10)
	 *   - 동전의 가지 수 N(1 ≤ N ≤ 20)
	 *   - N가지 동전으로 만들어야 할 금액 M(1 ≤ M ≤ 10000)
	 *   - N가지 동전의 각 금액이 오름차순으로 정렬되어 주어진다. 
	 *   - 각 금액은 정수로서 1원부터 10000원까지 있을 수 있으며 공백으로 구분된다.
	 *   - 편의를 위해 방법의 수는 2³¹ - 1 보다 작고, 같은 동전이 여러 번 주어지는 경우는 없다.
	 * 
	 * => DP로 풀기
	 * 
	 * 시간: 88 ms
	 * 메모리: 11832 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 0; test_case < T; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 동전의 가지 수
			
			int[] coin = new int[N];
			
			// N개의 동전 금액 오름차순으로 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				coin[i] = Integer.parseInt(st.nextToken());
			}
			
			int M = Integer.parseInt(br.readLine()); // N가지 동전으로 만들어야 할 금액
			int[] memo = new int[M+1]; // M원까지 만드는데의 경우의 수 저장
			
			// 초기화
			memo[0] = 1; // 누적시키기 위해
			
			for (int i = 0; i < N; i++) {
				for (int j = coin[i]; j <= M; j++) {
					memo[j] = memo[j] + memo[j - coin[i]];
				}
			}
			
			System.out.println(memo[M]);
		}
		
	}

}
