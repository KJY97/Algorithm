package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1979 {

	/**
	 * 문제
	 *  N x N 크기의 단어 퍼즐을 만들려고 한다. 입력으로 단어 퍼즐의 모양이 주어진다.
	 *  주어진 퍼즐 모양에서 특정 길이 K를 갖는 단어가 들어갈 수 있는 자리의 수를 출력하는 프로그램 작성하기
	 *   - 흰색 부분은 1, 검은색 부분은 0 (흰색 부분이 들어갈 수 있는 칸)
	 *   - 5 ≤ N ≤ 15
	 *   - 2 ≤ K ≤ N
	 *   
	 * 시간: 107 ms
	 * 메모리: 18,364 kb
	 */
	private static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 퍼즐의 가로,세로 길이. 5 ≤ N ≤ 15
			K = Integer.parseInt(st.nextToken()); // 단어 길이. 2 ≤ K ≤ N
			
			// 퍼즐 초기화
			int[][] map = new int[N][N]; // 가로 방향 순서
			int[][] reMap = new int[N][N]; // 세로 방향 순서
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					// 흰 1, 검 0
					int color = Integer.parseInt(st.nextToken());
					map[i][j] = color;
					reMap[j][i] = color;
				}
			}
			
			int ans = checkWordLength(map) + checkWordLength(reMap);
			System.out.println("#" + test_case + " " + ans);
		}
	}

	// 연속되는 흰색 공간 체크 & 길이가 K인 단어가 들어갈 자리 수 체크하는 메소드
	public static int checkWordLength(int[][] board) {
		int cnt = 0; // 길이가 K인 단어가 들어갈 수 있는 자리 수 카운트
		for (int i = 0; i < N; i++) {
			
			int length = 0; // 연속되는 흰색 공간 카운트
			for (int j = 0; j < N; j++) {
				
				if(board[i][j] == 1) length++;
				else if(board[i][j] == 0 && length != 0) {
					if(length == K) cnt++;
					length = 0;
				}
			}
			if(length == K) cnt++;
		}
		return cnt;
	}

}
