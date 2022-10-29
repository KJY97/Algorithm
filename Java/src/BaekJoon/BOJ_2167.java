package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2167 {

	/**
	 * 문제
	 *  2차원 배열이 주어졌을 때 (i, j) 위치부터 (x, y) 위치까지에 저장되어 있는 수들의 합을 구하는 프로그램을 작성하시오.
	 *  배열의 (i, j) 위치는 i행 j열을 나타낸다.
	 *  K개의 줄에 순서대로 배열의 합을 출력한다. 배열의 합은 2³¹-1보다 작거나 같다.
	 *   - 배열의 크기 N, M(1 ≤ N, M ≤ 300)
	 *   - 배열에 포함되어 있는 수는 절댓값이 10,000보다 작거나 같은 정수이다.
	 *   - 합을 구할 부분의 개수 K(1 ≤ K ≤ 10,000)
	 *   - K개의 줄에는 네 개의 정수로 i, j, x, y가 주어진다(1 ≤ i ≤ x ≤ N, 1 ≤ j ≤ y ≤ M)
	 *   - 제한시간 2초
	 *   
	 * 시간: 908 ms
	 * 메모리: 30612 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int K = Integer.parseInt(br.readLine()); // 합을 구할 부분의 개수
		
		while(K-- != 0) {
			st = new StringTokenizer(br.readLine());
			
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
		
			sumFromAToB(arr, i-1, j-1, x-1, y-1);
		}
	}
	
	// (x1, y1) ~ (x2, y2)에 저장되어 있는 수들의 합
	public static void sumFromAToB(int[][] arr, int x1, int y1, int x2, int y2) {
		int sum = 0; // 배열 합
		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				sum += arr[i][j];
			}
		}
		System.out.println(sum);
	}
}
