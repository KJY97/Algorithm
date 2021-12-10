package CodeUp;

import java.util.Scanner;

public class 기초100제_1098 {

	public static void main(String[] args) {
		// [기초-2차원배열] 설탕과자 뽑기
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt(); // 세로
		int w = sc.nextInt(); // 가로
		
		int n = sc.nextInt(); // 막대의 개수
		
		int[][] board = new int[h][w];
		int[][] deltas = {{0,1}, {1,0}}; // 오른쪽, 아래로 막대기가 증가한다.
		
		for (int i = 0; i < n; i++) {
			int l = sc.nextInt(); // 막대의 길이
			int d = sc.nextInt(); // 막대 놓는 방향(0:가로, 1:세로)
			// 막대 놓는 좌표
			int x = sc.nextInt(); 
			int y = sc.nextInt();
			
			// 막대 두기
			for (int j = 0; j < l; j++) {
				board[x-1][y-1] = 1;
				x += deltas[d][0];
				y += deltas[d][1];
			}
		}
		
		// 출력
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
