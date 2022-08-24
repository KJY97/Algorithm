package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11502 {

	/**
	 * 문제
	 *  정수론(수학)에서, 세 개의 소수 문제(3-primes problem) 는 다음과 같은 추측을 말한다.
	 *  '5보다 큰 임의의 홀수는 정확히 세 개의 소수들의 합으로 나타낼 수 있다. 물론 하나의 소수를 여러 번 더할 수도 있다.'
	 *  예를 들면,
	 *    - 7 = 2 + 2 + 3
	 *    - 11 = 2 + 2 + 7
	 *    - 25 = 7 + 7 + 11
	 *  5보다 큰 임의의 홀수를 입력받아서, 그 홀수가 어떻게 세 소수의 합으로 표현될 수 있는지 (또는 불가능한지) 알아보는 프로그램을 작성하시오.
	 *  가능하다면 그 세 소수를 오름차순 정렬하여 출력하면 된다. 
	 *  여러 개의 답이 가능하다면 그 중 하나만 출력하면 되고, 만약 불가능하다면 0을 출력한다.
	 *   - 하나의 정수 N (7 ≤ N < 1,000, N는 홀수)
	 *   - 제한 시간 1초
	 * 
	 * => 에라토스테네스의 체를 활용하여 소수 구한 다음 T개의 정수를 이루는 세 소수의 합을 구한다.
	 * 
	 * 시간: 220 ms
	 * 메모리: 13036 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 에라토스테네스의 체 - 소수 구하기
		boolean[] isNotPrime = new boolean[1001];
		
		isNotPrime[0] = isNotPrime[1] = true;
		
		for (int i = 2; i <= 1000; i++) {
			// 소수가 아니라면 skip
			if (isNotPrime[i]) continue;
			
			for (int j = i*2; j <= 1000; j += i) {
				isNotPrime[j] = true;
			}
		}
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		for (int test_case = 0; test_case < T; test_case++) {
			int N = Integer.parseInt(br.readLine());
		
			boolean flag = false; // N을 만드는 세 소수를 찾았는지 체크하는 변수
			
			for (int i = 2; i <= N; i++) {
				// i가 소수가 아니라면 skip
				if (isNotPrime[i]) continue;
				
				for (int j = 2; j <= N; j++) {
					// j가 소수가 아니라면 skip
					if (isNotPrime[j]) continue;
					
					for (int k = 2; k <= N; k++) {
						// k가 소수가 아니라면 skip
						if (isNotPrime[k]) continue;
						
						// 세 소수의 합이 N이라면 세 소수 출력 후 break
						if (i + j + k == N) {
							flag = true;
							System.out.println(i + " " + j + " " + k);
							break;
						}
					}
					if (flag) break;
				}
				if (flag) break;
			}
			
		}
	}

}
