package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1974 {

	/**
	 * 문제
	 *  입력으로 9 X 9 크기의 스도쿠 퍼즐의 숫자들이 주어졌을 때, 
	 *  겹치는 숫자가 없을 경우, 1을 정답으로 출력하고 그렇지 않을 경우 0 을 출력하기
	 *   - 입력 숫자는 1 이상 9 이하의 정수
	 *   
	 * 시간: 105 ms
	 * 메모리: 18,560 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			// 스도쿠 초기화 입력
			StringTokenizer st;
			int[][] map = new int[9][9];
			
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int ans = 1;
			
			// 1. 가로방향 조건 만족하는지 확인
			for (int i = 0; i < 9; i++) {
				
				boolean[] numCheck = new boolean[10]; // 0번 인덱스 사용안함
				
				// i행 1 ~ 9 체크
				for (int j = 0; j < 9; j++) {
					numCheck[map[i][j]] = true;
				}
				
				// 모든 숫자가 한번씩 나왔는지 확인. 하나라도 false 있으면 0
				for (int j = 1; j <= 9; j++) {
					if(!numCheck[j]) ans = 0;
				}
			}
			
			// 2. 세로방향 조건 만족하는지 확인
			for (int i = 0; i < 9; i++) {
				
				boolean[] numCheck = new boolean[10]; // 0번 인덱스 사용안함
				
				// j열 1 ~ 9 체크
				for (int j = 0; j < 9; j++) {
					numCheck[map[j][i]] = true;
				}
				
				// 모든 숫자가 한번씩 나왔는지 확인. 하나라도 false 있으면 0
				for (int j = 1; j <= 9; j++) {
					if(!numCheck[j]) ans = 0;
				}
			}
			
			// 3. 3x3 격자 안 조건 만족하는지 확인
			for (int i = 0; i < 9; i+=3) {
				for (int j = 0; j < 9; j+=3) {
					
					boolean[] numCheck = new boolean[10]; // 0번 인덱스 사용안함
					
					for (int k = i; k < i+3; k++) {
						for (int l = j; l < j+3; l++) {
							numCheck[map[k][l]] = true;
						}
					}
					
					// 모든 숫자가 한번씩 나왔는지 확인. 하나라도 false 있으면 0
					for (int k = 1; k <= 9; k++) {
						if(!numCheck[k]) ans = 0;
					}
				}
			}
			
			// 위에서 한번이라도 false를 만나면 ans=0, 없으면 1이다.
			System.out.println("#" + test_case + " " + ans);
		}
	}
	

}
