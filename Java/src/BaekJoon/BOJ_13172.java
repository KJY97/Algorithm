package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13172 {

	/**
	 * 문제
	 *  모든 주사위를 한 번씩 던졌을 때 나온 숫자들의 합의 기댓값을 출력하기
	 *   - M개의 주사위, i번째 주사위는 N면체 주사위
	 *   - 모든 면에 적힌 숫자를 더한 값은 S
	 *   - 각 주사위에 대해서 던졌을 때 주사위의 각 면이 나올 확률은 동일
	 *   - b의 모듈러 곱셈에 대한 역원 b^(-1)은 다음과 같은 성질을 만족하는 정수
	 *     : b^(-1) × b ≡ 1(mod X) 일 때, b^(X - 2) ≡ b^(-1) (mod X)
	 *   - 기약분수로 나타내었을 때 a/b가 된다면, (a × b^(-1)) mod 1,000,000,007을 대신 출력하기
	 * 
	 * => 분할 정복 이용하여 거듭제곱하기(a^n -> O(log n))
	 * => N과 S의 최대값이 10⁹이므로 int형 범위를 벗어난다. long 사용하기!!
	 * 
	 * 시간: 172 ms
	 * 메모리: 17508 kb
	 */
	private static final int X = 1_000_000_007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int M = Integer.parseInt(br.readLine()); // 주사위를 나타내는 정수. 1 ≤ M ≤ 10⁴
		
		long ans = 0;
		for (int i = 0; i < M; i++) {
			// 1 ≤ N, S ≤ 10⁹ => int 범위 벗어남
			st = new StringTokenizer(br.readLine());
			long N = Long.parseLong(st.nextToken());
			long S = Long.parseLong(st.nextToken());
			
			ans += (S * power(N, X-2)) % X;
			ans %= X; // 반드시 추가해줘야 함. 
		}
		System.out.println(ans);
	}
	
	// 제곱 계산 : 분할 정복으로 시간 단축
	private static long power(long N, int mod) {
		long res = 1;
		while(mod > 0) {
			if(mod % 2 == 1) res = (res * N) % X;
			
			N = (N * N) % X;
			mod /= 2;
		}
		return res;
	}

}
