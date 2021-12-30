package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18111 {

	/**
	 * 문제
	 *  집터 내의 땅의 높이를 일정하게 바꾸는 ‘땅 고르기’ 작업에 걸리는 최소 시간과 그 경우 땅의 최대 높이를 출력하기
	 *   - 세로 N, 가로 M 크기 집터. (1 ≤ M, N ≤ 500)
	 *   - 집터 아래 빈 공간은 존재하지 않고, 집터 바깥에서 블록 가져올 수 없다.
	 *   - 작업 시작할 때 인벤토리에 B개의 블록이 있음. (0 ≤ B ≤ 6.4 × 10⁷)
	 *   - 작업
	 *    - (i,j)의 가장 위에 있는 블록을 제거하여 인벤토리에 넣기 -> 2초 걸림
	 *    - 인벤토리에서 블록 하나를 꺼내어 좌표 (i,j)의 가장 위에 있는 블록 위에 놓기 -> 1초 걸림 
	 * 
	 * => 완탐을 고려할 때 최악의 경우 256 x 500 x 500 = 6천 4백만 이므로 완탐(브루트 포스) 가능
	 * => 모든 높이에 대해서 계산하기
	 * 
	 * 시간: 664 ms
	 * 메모리: 34536 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 세로
		int M = Integer.parseInt(st.nextToken()); // 가로
		int B = Integer.parseInt(st.nextToken()); // 인벤토리에 들어있는 블록 수
		
		// map 초기화
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); // 0 <= 땅의 높이 <= 256
			}
		}
		
		// 완탐 시작
		int minTime = Integer.MAX_VALUE; // 최소시간
		int maxHeight = 0; // 최대높이
		for (int height = 0; height <= 256; height++) { // 만들어주기 위한 높이
			int remove = 0; // 가장 위 블록 제거. 2초 걸림
			int append = 0; // 인벤토리에서 블록 추가. 1초 걸림
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// height로 만들기 위해 추가/제거해야 하는 블록 개수 구하기
					int curHeight = map[i][j] - height;
					
					// 추가해야 한는 경우. curHeight가 음수라서 -로 양수 만들기
					if(curHeight < 0) append -= curHeight; 
					// 제거해야 하는 경우
					else if(curHeight > 0) remove += curHeight;
				}
			}
			
			// 인벤토리에 들어있는 블록의 수가 인벤토리에서 꺼내야 하는 블록의 수보다 크다면 작업 가능
			if(remove + B >= append) {
				int totalTime = remove * 2 + append;
				if(minTime >= totalTime) {
					minTime = totalTime;
					maxHeight = height;
				}
			}
		}
		// 최소 시간, 최대 높이 출력
		System.out.println(minTime + " " + maxHeight);
	}

}
