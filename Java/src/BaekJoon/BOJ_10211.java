package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10211 {

	/**
	 * 문제
	 *  크기 N인 정수형 배열 X가 있을 때, X의 부분 배열(X의 연속한 일부분) 중 
	 *  각 원소의 합이 가장 큰 부분 배열을 찾는 Maximum subarray problem(최대 부분배열 문제)은 컴퓨터 과학에서 매우 잘 알려져 있다.
	 *  여러분은 N과 배열 X가 주어졌을 때, X의 maximum subarray의 합을 구하자. 
	 *  즉, max(1 ≤ i ≤ j ≤ N, X[i]+...+X[j])를 구하자.
	 *   - 첫 번째 줄에 테스트 케이스의 수를 의미하는 자연수 T
	 *   - 각 테스트케이스 별로 첫 번째 줄에 배열의 크기 N(1 ≤ N ≤ 1,000)
	 *   - 배열 X의 내용을 나타내는 N개의 정수가 공백으로 구분되어 주어진다. 
	 *     이때 주어지는 수는 절댓값이 1,000보다 작은 정수이다.
	 *     
	 * 시간: 120 ms
	 * 메모리: 12864 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine()); 
		for (int test_case = 0; test_case < T; test_case++) {
			
			int N = Integer.parseInt(br.readLine()); // 배열의 크기
			
			int[] arr = new int[N];
			// 메모이제이션 방법 활용
			// 누적합을 memo에 저장한다. 
			int[] memo = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				memo[i] = arr[i];
			}
			
			int max = memo[0]; // 초기화
			
			for (int i = 1; i < N; i++) {
				// 누적 합이 0보다 작다면 해당 구간은 포함하지 않는다
				if (memo[i-1] >= 0) {
					memo[i] += memo[i-1];
				}
				max = Math.max(max, memo[i]);
			}
			
			System.out.println(max);
		}
	}

}
