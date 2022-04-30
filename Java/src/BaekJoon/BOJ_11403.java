package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11403 {

	/**
	 * 문제
	 *  가중치 없는 방향 그래프 G가 주어졌을 때, 모든 정점 (i, j)에 대해서, i에서 j로 가는 경로가 있는지 없는지 구하는 프로그램을 작성하라.
	 *   - 정점의 개수 N. (1 ≤ N ≤ 100)
	 *   - 1은 간선이 존재, 0은 없다는 의미
	 *
	 * => 플로이드 와샬
	 * => 정점 i로 시작해서 정점 k를 지나 정점 j에 도착해야 하기 때문이다.
	 * 
	 * 시간 : 316 ms
	 * 메모리 : 21196 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 정점의 개수
		
		// 초기화
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// i -> k -> j (플로이드 와샬 사용하기)
		// k = 거쳐가는 노드
		for (int k = 0; k < N; k++) {
			// i = 출발 노드
			for (int i = 0; i < N; i++) {
				// j = 도착 노드
				for (int j = 0; j < N; j++) {
					// i -> j 로 가려면 결국 중간에 거쳐가는 노드와의 관계도 1이라는 의미
					if(arr[i][k] == 1 && arr[k][j] == 1) arr[i][j] = 1;
				}
			}
		}
		
		// 결과 출력하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
