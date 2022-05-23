package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053 {

	/**
	 * 문제
	 *  수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하라.
	 *  예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 30, 50} 이고, 길이는 4이다.
	 *   - 수열 A의 크기 N (1 ≤ N ≤ 1,000)
	 *   - 수열 A를 이루고 있는 Ai (1 ≤ Ai ≤ 1,000)
	 * 
	 * => LIS(최장 증가 부분 수열) 알고리즘 활용
	 *   => 구현하는 간편한 방법으로 DP가 있다. O(n^2)
	 *   => 1000 * 1000 = 1000000 (1초 안넘으므로 괜찮)
	 *   
	 * 시간: 100 ms
	 * 메모리: 12212 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[N]; // 수열 저장
		int[] LIS = new int[N]; // i번째 인덱스에서 끝나는 최장 증가 부분 수열의 길이 저장
		
		// 수열 A 초기화
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0; // LIS 중 가장 큰 값 저장
		
		// LIS 알고리즘 활용
		for (int i = 0; i < N; i++) {
			LIS[i] = 1; // 해당 원소에서 끝나는 LIS 길이의 최솟값. 즉, 자기 자신
			for (int j = 0; j < i; j++) {
				// i번째 이전의 모든 원소에 대해, 그 원소에서 끝나는 LIS의 길이를 확인한다.
				if (numbers[j] < numbers[i]) {
					// 단, 이는 현재 수가 그 원소보다 클 때만 확인한다.
					// dp[j] + 1 : 이전 원소에서 끝나는 LIS에 현재 수를 붙인 새 LIS 길이
					LIS[i] = Math.max(LIS[i], LIS[j] + 1);
				}
			}
			max = Math.max(max, LIS[i]);
		}
		
		// 가장 긴 증가하는 부분 수열의 길이를 출력
		System.out.println(max);
	}

}
