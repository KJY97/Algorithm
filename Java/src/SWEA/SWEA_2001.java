package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001 {

	/**
	 * 문제
	 *  N x N 배열 안에는 파리가 존재한다.
	 *  M x M 크기의 파리채를 한 번 내리쳐 최대한 많은 파리를 죽이고자 한다. 죽은 파리의 개수를 구하라!
	 *   - 5 <= N <= 15
	 *   - 2 <= M <= N
	 *   - 영역 안 파리는 30 이하
	 *   
	 * 시간: 101 ms
	 * 메모리: 19,664 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// map 초기화
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// MxM 크기 파리채 내려치기
			// (0,0)에서부터 파리채를 내려치기 때문에 범위 벗어나지 않도록 한다
			int max = 0;
			for (int i = 0; i < (N-M+1); i++) {
				for (int j = 0; j < (N-M+1); j++) {
					int sum = 0;
					for (int k = i; k < M + i; k++) {
						for (int l = j; l < M + j; l++) {
							sum += map[k][l];
						}
					}
					if(max <= sum) max = sum;
				}
			}
			
			System.out.println("#" + test_case + " " + max);
		}

	}

}
