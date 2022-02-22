package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1209 {

	/**
	 * 문제
	 *  다음 100X100의 2차원 배열이 주어질 때, 각 행의 합, 각 열의 합, 각 대각선의 합 중 최댓값을 구하기
	 *   - 배열 크기는 100x100로 고정
	 *   - 합의 범위는 integer 를 넘어가지 않음
	 *   
	 * 시간: 163 ms
	 * 메모리: 27,856 kb
	 */
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = Integer.parseInt(br.readLine()); // 테스트 케이스 번호
			
			// 초기화
			int[][] map = new int[100][100]; 	// 행x열 순서로 저장
			int[][] reMap = new int[100][100];	// 열x행 순서로 저장
			
			int r_diagonal = 0, l_diagonal = 0; // 각각 오른쪽/왼쪽 아래 대각선의 합 저장
		
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < 100; j++) {
					int num = Integer.parseInt(st.nextToken());
					
					// 오른쪽 아래 대각선
					if(i==j) r_diagonal += num;
					// 왼쪽 아래 대각선
					if(i+j == 99) l_diagonal += num;
					
					map[i][j] = num;
					reMap[j][i] = num;
				}
			}
			
			max = 0;
			sum(map);	// 각 행의 합
			sum(reMap); // 각 열의 합
			
			// 각 대각선의 합
			max = Math.max(max, r_diagonal); 
			max = Math.max(max, l_diagonal);
			
			System.out.println("#" + test_case + " " + max);
		}
		
	}
	
	// 각 가로 방향의 합 구하기
	public static void sum(int[][] arr) {
		
		for (int i = 0; i < 100; i++) {
			int tmp = 0;
			for (int j = 0; j < 100; j++) {
				tmp += arr[i][j]; 
			}
			max = Math.max(max, tmp);
		}
	}
	
}
