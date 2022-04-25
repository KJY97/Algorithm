package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9461 {

	/**
	 * 문제
	 *  오른쪽 그림과 같이 삼각형이 나선 모양으로 놓여져 있다. 첫 삼각형은 정삼각형으로 변의 길이는 1이다. 
	 *  그 다음에는 다음과 같은 과정으로 정삼각형을 계속 추가한다. 나선에서 가장 긴 변의 길이를 k라 했을 때, 그 변에 길이가 k인 정삼각형을 추가한다.
	 *  파도반 수열 P(N)은 나선에 있는 정삼각형의 변의 길이이다. P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9이다.
	 *  N이 주어졌을 때, P(N)을 구하는 프로그램을 작성하시오.
	 *   - 1 ≤ N ≤ 100
	 * 
	 * => 다이나믹 프로그래밍
	 * => 범위 신경쓰기
	 * 
	 * 시간 : 80 ms
	 * 메모리 : 11656 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 0; test_case < T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			
			// 초기화
			Long[] P = new Long[N+2]; // 1부터 시작
			
			P[0] = 0L; P[1] = 1L; P[2] = 1L;
			
			for (int i = 3; i <= N; i++) {
				P[i] = P[i-2] + P[i-3];
			}
			
			System.out.println(P[N]);
		}
	}

}
