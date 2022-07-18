package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2293 {

	/**
	 * 문제
	 *  n가지 종류의 동전이 있다. 각각의 동전이 나타내는 가치는 다르다. 이 동전을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다.
	 *  그 경우의 수를 구하시오. 각각의 동전은 몇 개라도 사용할 수 있다.
	 *  사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다.
	 *   - 1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000
	 *   - 동전의 가치는 100,000보다 작거나 같은 자연수이다.
	 *   - 경우의 수는 2³¹보다 작다.
	 *   - 시간제한 0.5초
	 *   
	 * => DP 활용하기
	 * 
	 * 시간: 92 ms
	 * 메모리: 11716 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 동전 종류
		int K = Integer.parseInt(st.nextToken()); // 원하는 가치의 합
		
		int[] coin = new int[N];
		
		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		int[] memo = new int[K+1]; // K원까지의 경우의 수 찾기
		memo[0] = 1; // 0원을 만드는 경우의 수는 아무것도 선택하지 않는 경우밖에 없다.
		
		for (int i = 0; i < N; i++) {
			for (int j = coin[i]; j <= K; j++) {
				// i번째 동전의 가치보다 적은 금액의 경우의 수는 모두 0이다.
				memo[j] = memo[j] + memo[j - coin[i]];
			}
		}
		
		System.out.println(memo[K]);
	}
	

}
