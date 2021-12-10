package CodeUp;

import java.util.Scanner;

public class 기초100제_1099 {

	public static void main(String[] args) {
		// [기초-2차원배열] 성실한 개미
		Scanner sc = new Scanner(System.in);
		int[][] board = new int[10][10]; // (0,0) 사용안함
		
		// 보드 초기화
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		int[][] deltas = {{0,1}, {1,0}}; // 오른쪽, 아래로 개미 이동
		
		// 개미 시작 위치
		int x = 1, y = 1;
		int nx = 0, ny = 0;
		
		// 벽의 값은 변하면 안됨
		while(x < 9 && y < 9) {
			
			// 먹이에 도착
			if(board[x][y] == 2) {
				board[x][y] = 9;
				break;
			}
						
			board[x][y] = 9; // 이동 체크
			
			for (int d = 0; d < 2; d++) {
				nx = x + deltas[d][0];
				ny = y + deltas[d][1];
				
				// 범위 벗어나거나 벽을 만나면 pass
				if(nx >= 10 || ny >= 10 || board[nx][ny] == 1) continue;
				// 이동했으면 반복문 탈출
				break;
			}
			// 개미 이동
			x = nx;
			y = ny;
		}
		
		// 출력
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}
