package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2005 {

	/**
	 * 문제
	 *  크기가 N인 파스칼 삼각형 출력하기
	 *   - 첫 번째 줄은 항상 1
	 *   - 두 번째 줄부터 각 숫자들은 자신의 왼쪽과 오른쪽 위의 숫자의 합으로 구성
	 *   - 1 ≤ N ≤ 10
	 * 
	 * => 메모이제이션 사용
	 * 
	 * 시간: 105 ms
	 * 메모리: 18,400 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); 

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 1 ≤ N ≤ 10
			int[][] memo = new int[N][N+1]; // 1번 열부터 사용
			
			memo[0][1] = 1;
			for (int i = 1; i < N; i++) {
				for (int j = 1; j <= i+1; j++) {
					memo[i][j] = memo[i-1][j-1] + memo[i-1][j]; // 0번 열의 값은 모두 0
				}
			}
			
			System.out.println("#" + test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 1; j <= i+1; j++) {
					System.out.print(memo[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
