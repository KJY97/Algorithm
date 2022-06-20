package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10844 {

	/**
	 * 문제
	 *  45656이란 수를 보자.
	 *  이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.
	 *  N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구해보자. 0으로 시작하는 수는 계단수가 아니다.
	 *  첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.
	 *   - 1 <= N <= 100
	 *  
	 *  => DP 방식을 이용. 경우의 수를 저장한다.
	 *  => 0을 제외한 모든 숫자는 앞에 올 수 있다.
	 *  => 9 다음 숫자로는 오로지 8만 올 수 있다. (ex. 98)
	 *  => 1 ~ 8 다음 숫자로는 2종류의 숫자가 올 수 있다. (ex. 10, 12)
	 *    1 = 1, 2, ...., 9
	 *    2 = 10, 12, 21, 23, 32, 34, ..., 87, 89, 98
	 *  => %1_000_000_000는 모든 경우의 수를 더할 때도 해줘야 한다.
	 *  
	 * 시간: 72 ms
	 * 메모리: 11512 kb
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 찾아야 하는 계단 수의 길이
		int MAX = 1_000_000_000;
		
		// 메모이제이션 방법 사용
		// N은 1부터 시작. 0 ~ 9 숫자 사용
		// memo[자리수][맨 앞 수(1~9)] = 경우의 수
		int[][] memo = new int[101][10];
		
		// 한자리의 경우 경우의 수는 모두 1로 초기화
		for (int i = 1; i <= 9; i++) {
			memo[1][i] = 1;
		}
		
		for (int i = 2; i <= N; i++) {
			memo[i][0] = memo[i-1][1];
			memo[i][9] = memo[i-1][8];
			for (int j = 1; j <= 8; j++) {
				memo[i][j] = (memo[i-1][j-1] + memo[i-1][j+1]) % MAX;
			}
		}

		int sum = 0;
		for (int i = 0; i <= 9; i++) {
			sum = (sum + memo[N][i]) % MAX;
		}
		
		System.out.println(sum);
	}

}
