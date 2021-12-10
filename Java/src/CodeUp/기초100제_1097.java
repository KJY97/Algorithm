package CodeUp;

import java.util.Scanner;

public class 기초100제_1097 {

	public static void main(String[] args) {
		// [기초-2차원배열] 바둑알 십자 뒤집기
		Scanner sc = new Scanner(System.in);
		int[][] board = new int[20][20]; // (0,0) 사용안함
	
		// 보드 초기화
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			// 열 뒤집기
			for (int j = 0; j < 20; j++) {
				if(board[x][j] == 0) board[x][j] = 1;
				else board[x][j] = 0;
			}
			
			// 행 뒤집기
			for (int j = 0; j < 20; j++) {
				if(board[j][y] == 0) board[j][y] = 1;
				else board[j][y] = 0;
			}
		}
		
		// 출력
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
