package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3184 {

	/**
	 * 문제
	 *  미키의 뒷마당에는 특정 수의 양이 있다. 그가 푹 잠든 사이에 배고픈 늑대는 마당에 들어와 양을 공격했다.
	 *  마당은 행과 열로 이루어진 직사각형 모양이다. 글자 '.' (점)은 빈 필드를 의미하며, 글자 '#'는 울타리를, 'o'는 양, 'v'는 늑대를 의미한다.
	 *  한 칸에서 수평, 수직만으로 이동하며 울타리를 지나지 않고 다른 칸으로 이동할 수 있다면, 두 칸은 같은 영역 안에 속해 있다고 한다.
	 *  마당에서 "탈출"할 수 있는 칸은 어떤 영역에도 속하지 않는다고 간주한다.
	 *  다행히 우리의 양은 늑대에게 싸움을 걸 수 있고 영역 안의 양의 수가 늑대의 수보다 많다면 이기고, 늑대를 우리에서 쫓아낸다.
	 *  그렇지 않다면 늑대가 그 지역 안의 모든 양을 먹는다.
	 *  맨 처음 모든 양과 늑대는 마당 안 영역에 존재한다.
	 *  아침이 도달했을 때 살아남은 양과 늑대의 수를 출력하는 프로그램을 작성하라.
	 *   - 첫 줄에는 두 정수 R과 C가 주어지며(3 ≤ R, C ≤ 250), 각 수는 마당의 행과 열의 수를 의미한다.
	 *   - 다음 R개의 줄은 C개의 글자를 가진다. 이들은 마당의 구조(울타리, 양, 늑대의 위치)를 의미한다.
	 *   
	 * => 너비 우선 탐색(BFS)을 활용해 해당 구역에서의 양과 늑대의 수 찾기
	 * 
	 * 시간: 168 ms
	 * 메모리: 17848 kb
	 */
	
	private static int R, C;
	private static int Wolf, Sheep;
	private static char map[][];
	private static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 수평, 수직으로만 이동
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		
		// 마당의 구조 초기화
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		Wolf = 0; Sheep = 0; // 아침까지 살아있는 양과 늑대의 수
		
		boolean[][] visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				// 이미 확인한 구역 or 울타리라면 skip
				if (visited[i][j] || map[i][j] == '#') continue;
				
				BFS(i, j, visited);
			}
		}
		
		// 아침까지 살아있는 양과 늑대의 수 출력
		System.out.println(Sheep + " " + Wolf);
	}
	
	private static void BFS(int x, int y, boolean[][] visited) {
		Queue<Point> queue = new LinkedList<>();
		
		visited[x][y] = true;
		queue.add(new Point(x, y));
		
		int wolf = 0, sheep = 0;
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			if (map[cur.x][cur.y] == 'v') wolf++;
			else if (map[cur.x][cur.y] == 'o') sheep++;
			
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + deltas[d][0];
				int ny = cur.y + deltas[d][1];
				
				// 범위 밖 or 울타리 or 이미 확인한 구역이라면 skip
				if (!isRange(nx, ny) || map[nx][ny] == '#' || visited[nx][ny]) continue;
				
				queue.add(new Point(nx, ny));
				visited[nx][ny] = true;
			}
		}
		
		// 늑대의 수가 양보다 많거나 같다면 모든 양을 먹는다. 그렇지 않다면 양은 늑대를 우리에서 모두 쫓아낸다.
		if (wolf >= sheep) sheep = 0;
		else wolf = 0;
		
		Wolf += wolf;
		Sheep += sheep;
	}
	
	// 범위 안인가?
	private static boolean isRange(int x, int y) {
		return 0 <= x && x < R && 0 <= y && y < C;
	}
	
	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}

}
