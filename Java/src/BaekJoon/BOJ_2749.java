package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2749 {

	/**
	 * 문제
	 *  피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
	 *  이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
	 *  n=17일때 까지 피보나치 수를 써보면 다음과 같다.
	 *  0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
	 *  n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
	 *  첫째 줄에 n번째 피보나치 수를 1,000,000으로 나눈 나머지를 출력한다.
	 *   - n은 1,000,000,000,000,000,000보다 작거나 같은 자연수이다.
	 *   - 제한시간 1초
	 *   
	 * => 메모이제이션 활용
	 * => N이 10¹⁸로 매우 크기 때문에, 10⁶로 나눈 나머지의 주기(=피사노 주기)로 해결한다.
	 *    주기의 길이가 P 이면, N번째 피보나치 수를 M으로 나눈 나머지는 N%P번째 피보나치 수를 M을 나눈 나머지와 같다.
	 *    M = 10^k일 때, k > 2 라면, 주기는 항상 15 × 10^k-1 입니다. 
	 *    참고: https://www.acmicpc.net/blog/view/28
	 * 
	 * 시간: 108 ms
	 * 메모리: 17632 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int MOD = 1000000; // 나눌 수
		int P = 15 * 100000; // 피사노주기
		
		long N = Long.parseLong(br.readLine());
		
		// 피보나치는 MOD로 나눈 나머지의 주기를 가지고 있다.
		// 피사노 주기는 주기의 길이 P만큼 값이 반복되므로 P만큼만 구한다.
		int[] memo = new int[P+1];
		
		memo[0] = 0; memo[1] = 1;
		for (int i = 2; i <= P; i++) {
			memo[i] = memo[i-1] + memo[i-2];
			memo[i] %= MOD;
		}
		
		System.out.println(memo[(int) (N%P)]);

	}

}
