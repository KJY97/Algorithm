package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2960 {

	/**
	 * 문제
	 *  에라토스테네스의 체는 N보다 작거나 같은 모든 소수를 찾는 유명한 알고리즘이다.
	 *  이 알고리즘은 다음과 같다.
	 *    1. 2부터 N까지 모든 정수를 적는다
	 *    2. 아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 P라고 하고, 이 수는 소수이다.
	 *    3. P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
	 *    4. 아직 모든 수를 지우지 않았다면, 다시 2번 단계로 간다.
	 *  N, K가 주어졌을 때, K번째 지우는 수를 구하는 프로그램을 작성하시오.
	 *   - 1 ≤ K < N, max(1, K) < N ≤ 1000
	 *   
	 * 시간: 76 ms
	 * 메모리: 11448 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); // 구해야 하는 K번째 소수가 아닌 수

		// 소수가 아닌 수 체크하기
		boolean[] isNotPrime = new boolean[N+1]; // 1번부터 사용
		
		// 지워지는 숫자 카운트
		int cnt = 0;
		
		// 에라토스테네스의 체 알고리즘
		for (int i = 2; i <= N; i++) {
			for (int j = i; j <= N; j += i) {
				// 이미 소수가 아니라고 체크된 수는 skip
				if(isNotPrime[j]) continue;
				
				// i의 배수 지우기
				isNotPrime[j] = true;
				cnt++;
				
				if(cnt == K) {
					System.out.println(j);
					return ;
				}
			}
		}
	}

}
