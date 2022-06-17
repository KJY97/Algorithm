package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912 {

	/**
	 * 문제
	 *  n개의 정수로 이루어진 임의의 수열이 주어진다. 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다.
	 *  단, 수는 한 개 이상 선택해야 한다. 
	 *  예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 여기서 정답은 12+21인 33이 정답이 된다.
	 *   - n(1 ≤ n ≤ 100,000)
	 *   - n개의 정수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.
	 *  
	 * => DP 사용
	 * => 부분합 구하는 방식
	 * => 더한 값은 구하는 것이지, 어떤 수를 더한것인지는 알 필요가 없다
	 * 
	 * 시간: 192 ms
	 * 메모리: 22168 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine()); // 수열의 크기
		int[] nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// 메모이제이션 사용
		int[] memo = new int[N];
		memo[0] = nums[0];
		
		int max = memo[0]; // 연속된 부분합 중 가장 큰 합 
		
		// 직전까지의 합과 현재 가리키고 있는 수 비교한다
		// 현재 가리키고 있는 수가 더 크다면 직전까지 더한 합들은 버린다
		for (int i = 1; i < N; i++) {
			memo[i] = Math.max(memo[i-1] + nums[i], nums[i]);
			max = Math.max(max, memo[i]);
		}
		
		System.out.println(max);
	}

}