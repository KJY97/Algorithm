package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11722 {

	/**
	 * 문제
	 *  수열 A가 주어졌을 때, 가장 긴 감소하는 부분 수열을 구하는 프로그램을 작성하시오.
	 *  예를 들어, 수열 A = {10, 30, 10, 20, 20, 10} 인 경우에 가장 긴 감소하는 부분 수열은 A = {10, 30, 10, 20, 20, 10}  이고, 길이는 3이다.
	 *   - A의 크기 N (1 ≤ N ≤ 1,000)
	 *   - 수열 A를 이루고 있는 Ai (1 ≤ Ai ≤ 1,000)
	 *   - 제한시간 1초
	 *   
	 * 시간: 100 ms
	 * 메모리: 11916 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 메모이제이션 사용
		// 감소하는 부분 수열의 길이를 저장한다.
		int[] memo = new int[N+1];
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			memo[i] = 1; // // 자기 자신만 있으므로 길이는 1
			for (int j = 1; j < i; j++) {
				
				if (arr[i] < arr[j]) {
					memo[i] = Math.max(memo[i], memo[j] + 1);
				}
			}
			ans = Math.max(ans, memo[i]);
		}
		
		System.out.println(ans);
	}

}
