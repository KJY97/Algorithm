package CodeUp;

import java.util.Scanner;

public class 기초100제_1096 {

	public static void main(String[] args) {
		// [기초-2차원배열] 바둑판에 흰 돌 놓기
		Scanner sc = new Scanner(System.in);
		int[][] board = new int[20][20]; // (0,0) 사용안함
		
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			board[x][y] = 1;
		}
		
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
