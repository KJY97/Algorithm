package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1961 {

	/**
	 * 문제
	 *  N x N 행렬이 주어질 때, 시계 방향으로 90도, 180도, 270도 회전한 모양을 출력하기
	 *   - 3 <= N <= 7
	 * 
	 * => 90, 180, 270도 회전 모양을 각 열에 N줄로 출력
	 * 
	 * 시간: 108 ms
	 * 메모리: 18,368 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			String[][] matrix = new String[N][N];
			
			for (int i = 0; i < N; i++) {
				matrix[i] = br.readLine().split(" ");
			}
			
			String[][] result = new String[N][3]; // 90, 180, 270 회전 결과담는 배열
			
			// 90도 회전 
			int idx = 0;
			for (int i = 0; i < N; i++) {
				String tmp = "";
				for (int j = N-1; j >= 0; j--) {
					tmp += matrix[j][i];
				}
				result[idx++][0] = tmp;
			}
			
			// 180도 회전
			idx = 0;
			for (int i = N-1; i >= 0; i--) {
				String tmp = "";
				for (int j = N-1; j >= 0; j--) {
					tmp += matrix[i][j];
				}
				result[idx++][1] = tmp;
			}
			
			// 270도 회전
			idx = 0;
			for (int i = N-1; i >= 0; i--) {
				String tmp = "";
				for (int j = 0; j < N; j++) {
					tmp += matrix[j][i];
				}
				result[idx++][2] = tmp;
			}
			
			// 출력
			System.out.println("#" + test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(result[i][j] + " ");
				}
				System.out.println();
			}
		}

	}

}
