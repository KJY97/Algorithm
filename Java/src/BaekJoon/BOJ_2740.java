package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2740 {

	/**
	 * 문제
	 *  N*M크기의 행렬 A와 M*K크기의 행렬 B가 주어졌을 때, 두 행렬을 곱하는 프로그램을 작성하시오.
	 *   - 행렬 A의 크기 N과 원소 개수 M
	 *   - 행렬 B의 크기 M과 원소 개수 K
	 *   - N과 M, 그리고 K는 100보다 작거나 같고, 행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.
	 *   - 제한시간 1초
	 *   
	 * 시간: 324 ms
	 * 메모리: 22856 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 행렬 A의 크기
		int M = Integer.parseInt(st.nextToken()); // 행렬 A의 원소 개수

		// 행렬 A 초기화
		int[][] Arr = new int[N][M];
		for (int i = 0; i < N; i++) {	
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				Arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // 행렬 B의 크기
		int K = Integer.parseInt(st.nextToken()); // 행렬 B의 원소 개수

		// 행렬 B 초기화
		int[][] Brr = new int[M][K];
		for (int i = 0; i < M; i++) {	
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < K; j++) {
				Brr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 행렬 A와 행렬 B 곱하기
		int[][] result = new int[N][K];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				int tmp = 0;
				for (int k = 0; k < M; k++) {
					tmp += Arr[i][k] * Brr[k][j];
				}
				result[i][j] = tmp;
			}
		}
		
		// 결과 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

}
