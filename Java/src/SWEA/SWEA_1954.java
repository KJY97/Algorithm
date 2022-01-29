package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1954 {

	/**
	 * 문제
	 *  달팽이는 1부터 N*N까지의 숫자가 시계방향으로 이루어져 있다.
	 *  다음과 같이 정수 N을 입력 받아 N크기의 달팽이를 출력하시오.
	 *   - 1 ≤ N ≤ 10
	 *   
	 * 시간: 116 ms
	 * 메모리: 20,592 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 배열 크기
			
			int[][] map = new int[N][N];
			int cnt = 1;
			int flag = 1; // 오른쪽, 아래: 1, 왼쪽, 위: -1
			int col = -1; // 바로 flag 더해줘야 하므로
			int row = 0;
			
			while(N != 0) {
				// 오른쪽, 왼쪽
				for (int i = 0; i < N; i++) {
					col += flag;
					map[row][col] = cnt++;
				}
				
				N--; 
				
				// 위, 아래
				for (int i = 0; i < N; i++) {
					row += flag;
					map[row][col] = cnt++;
				}
				
				flag *= -1; // 방향 바꿔주기
			}
			
			// 출력
			System.out.println("#" + test_case);
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}

	}

}
