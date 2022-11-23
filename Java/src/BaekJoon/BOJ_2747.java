package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2747 {

	/**
	 * 문제
	 *  피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
	 *  이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
	 *  n=17일때 까지 피보나치 수를 써보면 다음과 같다.
	 *  0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
	 *  n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
	 *   - n은 45보다 작거나 같은 자연수이다.
	 *   
	 * => 메모이제이션 활용
	 * 
	 * 시간: 76 ms
	 * 메모리: 11484 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] memo = new int[N+1];
		
		memo[0] = 0; memo[1] = 1;
		for (int i = 2; i <= N; i++) {
			memo[i] = memo[i-1] + memo[i-2];
		}
		
		System.out.println(memo[N]);
	}

}
