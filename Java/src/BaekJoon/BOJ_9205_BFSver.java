package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205_BFSver {

	/**
	 * 문제
	 *  송도에 사는 상근이와 친구들은 송도에서 열리는 펜타포트 락 페스티벌에 가려고 한다. 올해는 맥주를 마시면서 걸어가기로 했다.
	 *  출발은 상근이네 집에서 하고, 맥주 한 박스를 들고 출발한다. 맥주 한 박스에는 맥주가 20개 들어있다. 
	 *  목이 마르면 안되기 때문에 50미터에 한 병씩 마시려고 한다. 즉, 50미터를 가려면 그 직전에 맥주 한 병을 마셔야 한다.
	 *  
	 *  상근이의 집에서 페스티벌이 열리는 곳은 매우 먼 거리이다. 따라서, 맥주를 더 구매해야 할 수도 있다. 미리 인터넷으로 조사를 해보니 다행히도 맥주를 파는 편의점이 있다.
	 *  편의점에 들렸을 때, 빈 병은 버리고 새 맥주 병을 살 수 있다. 하지만, 박스에 들어있는 맥주는 20병을 넘을 수 없다. 
	 *  편의점을 나선 직후에도 50미터를 가기 전에 맥주 한 병을 마셔야 한다.
	 *  
	 *  편의점, 상근이네 집, 펜타포트 락 페스티벌의 좌표가 주어진다. 상근이와 친구들이 행복하게 페스티벌에 도착할 수 있는지 구하라.
	 *  상근이와 친구들이 행복하게 페스티벌에 갈 수 있으면 "happy", 중간에 맥주가 바닥나서 더 이동할 수 없으면 "sad"를 출력한다.
	 *   - 상근이네 집, 편의점, 펜타포트 락 페스티벌 좌표가 주어진다. 각 좌표는 두 정수 x와 y로 이루어져 있다. (두 값 모두 미터, -32768 ≤ x, y ≤ 32767)
	 *   - 송도는 직사각형 모양으로 생긴 도시이다. 두 좌표 사이의 거리는 x 좌표의 차이 + y 좌표의 차이 이다. (맨해튼 거리)
	 * 
	 * => 출발지점(상근이네 집)에서 도착지점(락 페스티벌)에 도착할 수 있는지 확인하는 문제
	 * => 맥주 1개당 50미터 이동이 가능하므로, 즉 최대 1000m까지만 이동 가능
	 * 
	 * => BFS 사용
	 * => 1000m 안에 편의점이 존재하는지 체크하기 (맨하탄 알고리즘 사용)
	 * 
	 * 시간 : 104 ms
	 * 메모리 : 12500 kb
	 */
	
	private static int N; // 편의점 개수. 0 ≤ n ≤ 100
	private static List<Point> list; // 좌표 저장하는 리스트
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수. T <= 50
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine()); 
			list = new ArrayList<>();
			
			// 상근이네 집, 편의점, 펜타포트 락 페스티벌 좌표 입력
			for (int i = 0; i < N+2; i++) {
				st = new StringTokenizer(br.readLine());
				
				// -32768 ≤ x, y ≤ 32767
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				list.add(new Point(x, y));
			}
			
			boolean flag = BFS();

			// 첫번째 입력(상근이네 집)에서 마지막 입력(락 페스티벌)에 도착 가능한가?
			System.out.println(flag ? "happy" : "sad");
		}
	}
	
	public static boolean BFS() {
		Queue<Point> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+2];
				
		queue.add(list.get(0));
		visited[0] = true;
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			// 도착지에 도착했다면
			if (list.get(N+1).equals(cur)) return true;
			
			for (int i = 1; i < N+2; i++) {
				// 미방문 && 1000m 이내 이동 가능하다면
				if (!visited[i] && cur.Manhattan(list.get(i)) <= 1000) {
					visited[i] = true;
					queue.add(list.get(i));
				}
			}
		}
		
		return false;
	}
	
	public static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		// 맨하탄 개념 사용
		public int Manhattan(Point p) {
			return Math.abs(x - p.x) + Math.abs(y - p.y);
		}
	}
}
