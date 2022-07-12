package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2193 {

	/**
	 * 문제
	 *  0과 1로만 이루어진 수를 이진수라 한다. 이러한 이진수 중 특별한 성질을 갖는 것들이 있는데, 이들을 이친수(pinary number)라 한다. 
	 *  이친수는 다음의 성질을 만족한다.
	 *  -------------------------------------------------------------
	 *    1. 이친수는 0으로 시작하지 않는다.
	 *    2. 이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.
	 *  -------------------------------------------------------------
	 *  예를 들면 1, 10, 100, 101, 1000, 1001 등이 이친수가 된다. 하지만 0010101이나 101101은 각각 1, 2번 규칙에 위배되므로 이친수가 아니다.
	 *  N이 주어졌을 때, N자리 이친수의 개수를 구하는 프로그램을 작성하시오.
	 *   - 1 ≤ N ≤ 90
	 *   - 제한시간 2초
	 * 
	 *  N = 1 : 1
	 *  N = 2 : 10
	 *  N = 3 : 100, 101
	 *  N = 4 : 1000, 1010, 1001
	 *  N = 5 : 10000, 10001, 10100, 10101, 10010
	 *   ...
	 * => 피보나치 수열이 보여지고 있다. DP 활용
	 * => 90번째 수까지 가야하므로 범위를 long으로 잡는다.
	 * 
	 * 시간: 76 ms
	 * 메모리: 11464 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] memo = new long[N+1];
		memo[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			memo[i] = memo[i-1] + memo[i-2];
		}
		
		System.out.println(memo[N]);
	}

}
