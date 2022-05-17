package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_2407 {

	/**
	 * 문제
	 *  nCm을 출력한다.
	 *   - 5 ≤ n ≤ 100
	 *   - 5 ≤ m ≤ 100
	 *   - m ≤ n
	 *   
	 * => 일반 조합 방식으로 하면 시간 초과 발생
	 *  => DP 알고리즘
	 *  => 조합 성질 이해하기
	 *  => nCm = n-1Cm-1 + n-1Cm
	 * 
	 * => long으로 해도 오버플로우 발생. long보다 더 큰 무한대 정수형 BigInteger 클래스 사용
	 * 
	 * 시간 : 76 ms
	 * 메모리 : 11960 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 조합의 특성 이용하기
		// nCm = n-1Cm-1 + n-1Cm
		BigInteger[][] memo = new BigInteger[N+1][N+1];
		
		// 기본 초기화
		memo[0][0] = memo[1][0] = memo[1][1] = BigInteger.ONE;
		
		for (int n = 2; n <= N; n++) {
			for (int m = 0; m <= n; m++) {
				if (m == 0 || m == n) {
					memo[n][m] = BigInteger.ONE;
				} else {
					memo[n][m] = memo[n-1][m-1].add(memo[n-1][m]);
				}
			}
		}
		
		System.out.println(memo[N][M]);
	}

}
