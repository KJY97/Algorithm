package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17069 {

	/**
	 * 문제
	 *  유현이가 새 집으로 이사했다. 새 집의 크기는 N×N의 격자판으로 나타낼 수 있고, 1×1크기의 정사각형 칸으로 나누어져 있다.
	 *  각각의 칸은 (r, c)로 나타낼 수 있다. 여기서 r은 행의 번호, c는 열의 번호이고, 행과 열의 번호는 1부터 시작한다. 각각의 칸은 빈 칸이거나 벽이다.
	 *  오늘은 집 수리를 위해서 파이프 하나를 옮기려고 한다. 파이프는 아래와 같은 형태이고, 2개의 연속된 칸을 차지하는 크기이다.
	 *   ... 그림 생략 ...
	 *  파이프는 회전시킬 수 있으며, 아래와 같이 3가지 방향이 가능하다.
	 *  파이프는 매우 무겁기 때문에, 유현이는 파이프를 밀어서 이동시키려고 한다. 벽에는 새로운 벽지를 발랐기 때문에, 파이프가 벽을 긁으면 안 된다.
	 *  즉, 파이프는 항상 빈 칸만 차지해야 한다.
	 *  파이프를 밀 수 있는 방향은 총 3가지가 있으며, →, ↘, ↓ 방향이다. 파이프는 밀면서 회전시킬 수 있다. 
	 *  회전은 45도만 회전시킬 수 있으며, 미는 방향은 오른쪽, 아래, 또는 오른쪽 아래 대각선 방향이어야 한다.
	 *  파이프가 가로로 놓여진 경우에 가능한 이동 방법은 총 2가지, 세로로 놓여진 경우에는 2가지, 대각선 방향으로 놓여진 경우에는 3가지가 있다.
	 *  아래 그림은 파이프가 놓여진 방향에 따라서 이동할 수 있는 방법을 모두 나타낸 것이고, 꼭 빈 칸이어야 하는 곳은 색으로 표시되어져 있다.
	 *  가장 처음에 파이프는 (1, 1)와 (1, 2)를 차지하고 있고, 방향은 가로이다. 파이프의 한쪽 끝을 (N, N)로 이동시키는 방법의 개수를 구해보자.
	 *  이동시킬 수 없는 경우에는 0을 출력한다.
	 *   - 집의 크기 N(3 ≤ N ≤ 32)
	 *   - 빈 칸은 0, 벽은 1로 주어진다. 
	 *   - (1, 1)과 (1, 2)는 항상 빈 칸이다.
	 *   - 제한 시간 0.5초
	 * 
	 * => BFS로 풀면 시간 초과 발생하므로 
	 * 	  DP로 풀어보기
	 * => 경우의 수 범위 주의
	 * 
	 * 시간: 80 ms
	 * 메모리: 11848 kb
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine()); // 집의 크기
		
		int[][] map = new int[N+1][N+1]; // (1,1)부터 사용하기 위해
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 도착 위치가 벽이 있다면 이동시킬 수 없다!
		if(map[N][N] == 1) System.out.println(0);
		else {
			// 각 방향으로 갔을 때의 경우의 수 구하기
			long[][][] memo = new long[N+1][N+1][3]; // 가로 0, 세로 1, 대각선 2 를 의미한다.
			
			memo[1][2][0] = 1; // 초기화
			
			// DP, 즉 메모이제이션 방법을 활용한다.
			for (int i = 1; i <= N; i++) {
				for (int j = 3; j <= N; j++) {
					// 벽을 만나면 skip
					if (map[i][j] == 1) continue;
					
					// 가로 방향
					// 가로 -> 가로, 대각선 -> 가로 가는 경우
					memo[i][j][0] = memo[i][j-1][0] + memo[i][j-1][2];
					
					// 맨 윗줄이면 skip
					if (i == 1) continue;
					
					// 세로 방향
					// 세로 -> 세로, 대각선 -> 세로 가는 경우
					memo[i][j][1] = memo[i-1][j][1] + memo[i-1][j][2];
					
					// 위, 옆으로 벽이 있다면 skip
					if (map[i][j-1] == 1 || map[i-1][j] == 1) continue;
					
					// 대각선 방향
					// 가로 -> 대각선, 세로 -> 대각선, 대각선 -> 대각선 가는 경우
					memo[i][j][2] = memo[i-1][j-1][0] + memo[i-1][j-1][1] + memo[i-1][j-1][2];
				}
			}
			
			System.out.println(memo[N][N][0] + memo[N][N][1] + memo[N][N][2]);
		}
	}

}
