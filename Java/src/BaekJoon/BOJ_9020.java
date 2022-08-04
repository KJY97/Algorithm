package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9020 {

	/**
	 * 문제
	 *  1보다 큰 자연수 중에서  1과 자기 자신을 제외한 약수가 없는 자연수를 소수라고 한다.
	 *  예를 들어, 5는 1과 5를 제외한 약수가 없기 때문에 소수이다. 하지만, 6은 6 = 2 × 3 이기 때문에 소수가 아니다.
	 *  골드바흐의 추측은 유명한 정수론의 미해결 문제로, 2보다 큰 모든 짝수는 두 소수의 합으로 나타낼 수 있다는 것이다. 
	 *  이러한 수를 골드바흐 수라고 한다. 또, 짝수를 두 소수의 합으로 나타내는 표현을 그 수의 골드바흐 파티션이라고 한다.
	 *  예를 들면, 4 = 2 + 2, 6 = 3 + 3, 8 = 3 + 5, 10 = 5 + 5, 12 = 5 + 7, 14 = 3 + 11, 14 = 7 + 7이다. 
	 *  10000보다 작거나 같은 모든 짝수 n에 대한 골드바흐 파티션은 존재한다.
	 *  2보다 큰 짝수 n이 주어졌을 때, n의 골드바흐 파티션을 출력하는 프로그램을 작성하시오.
	 *  만약 가능한 n의 골드바흐 파티션이 여러 가지인 경우에는 두 소수의 차이가 가장 작은 것을 출력한다.
	 *  출력하는 소수는 작은 것부터 먼저 출력하며, 공백으로 구분한다.
	 *   - 4 ≤ n ≤ 10,000
	 *   - 2초 제한시간
	 * 
	 * => 골드바흐 수는 2개의 소수 합이다.
	 * => 즉, 소수를 먼저 구하고 시작하자!
	 * => 소수는 에라토스테네스의 체를 활용하여 구한다.
	 * 
	 * 시간: 340 ms
	 * 메모리: 14940 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1. 소수 찾기. 에라토스테네스의 체 활용
		boolean[] isNotPrime = new boolean[10001];
		
		isNotPrime[0] = isNotPrime[1] = true;
		
		for (int i = 2; i <= 10000; i++) {
			// 소수가 아니라고 체크되어 있다면 skip
			if (isNotPrime[i]) continue;
			
			// 소수가 아닌 수 체크
			for (int j = i*i; j <= 10000; j += i) {
				isNotPrime[j] = true;
			}
		}
		
		// 2. 테스트 케이스 입력
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 0; test_case < T; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 짝수
			
			// 두 소수 a, b와 두 소수의 최소차를 저장하는 min
			int a = 0, b = 0, min = N;
			
			// N/2 이후는 수의 위치만 다를 뿐 결과는 중복되므로 절반까지만 한다.
			for (int i = 2; i <= N/2; i++) {
				// 골드바흐 수는 소수 2개의 합이므로 i, N-i가 모두 소수가 아니라면 skip
				if (isNotPrime[i] || isNotPrime[N-i]) continue;
				
				// 골드바흐 파티션이 여러 가지인 경우 두 소수 차가 가장 작은 것을 출력한다.
				if (min > N-i-i) {
					a = i;
					b = N-i;
					min = N-i-i;
				}
			}
			
			// 작은 것부터 출력
			System.out.println(a + " " + b);
		}

	}

}
