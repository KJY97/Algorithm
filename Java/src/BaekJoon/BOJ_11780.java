package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_11780 {
	/**
	 * 문제
	 *  n(1 ≤ n ≤ 100)개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 m(1 ≤ m ≤ 100,000)개의 버스가 있다. 
	 *  각 버스는 한 번 사용할 때 필요한 비용이 있다.
	 *  모든 도시의 쌍 (A, B)에 대해서 도시 A에서 B로 가는데 필요한 비용의 최솟값, 도시의 개수, 경로를 구하라
	 *   - 버스의 정보는 버스의 시작 도시 a, 도착 도시 b, 한 번 타는데 필요한 비용 c로 이루어져 있다.
	 *   - 시작 도시와 도착 도시가 같은 경우는 없다. 
	 *   - 비용은 100,000보다 작거나 같은 자연수이다.
	 *   - i에서 j로 갈 수 없는 경우에는 그 자리에 0을 출력
	 * 
	 * => 플로이드 와샬 사용
	 * => 지나기는 경유 도시들도 출력해야 하므로 따로 저장 필요. 
	 *    path[start][end] = end 도착 직전 도시를 저장해놓은 배열
	 *   
	 * 시간 : 1616 ms
	 * 메모리 : 68664 kb
	 */
	
	private static int INF = 100 * 100_000;
	private static int matrix[][], path[][]; // 최소비용 저장 배열과 거쳐가는 경로 저장 배열
	private static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine()); // 도시의 개수
		M = Integer.parseInt(br.readLine()); // 버스의 개수
		
		Stack<Integer> stack = new Stack<>(); // path 경로 추적용 스택
		matrix = new int[N+1][N+1]; // 1번 인덱스부터 사용
		path = new int[N+1][N+1]; // 경유 경로 저장하는 배열
		
		// ===== 인접행렬 INF로 초기화 =====
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				path[i][j] = INF;
				// 시작도시와 도착도시가 같은 경우는 없다. (=같은 경우 0으로 저장)
				if (i != j) matrix[i][j] = INF;
			}
		}
		
		// 배열 입력 초기화
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken()); // 시작 도시
			int b = Integer.parseInt(st.nextToken()); // 도착 도시
			int c = Integer.parseInt(st.nextToken()); // 필요한 비용
			
			matrix[a][b] = Math.min(matrix[a][b], c);
			path[a][b] = a;
		}
		
		// ===== 플로이드 와샬 =====
		floydWarshall();
		
		// ============= 출력 =============
		// 도시 i에서 j로 가는데 필요한 최소 비용 출력
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				// i에서 j로 갈 수 없으면 0으로 수정
				if(matrix[i][j] == INF) 
					System.out.print(0 + " ");
				else
					System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		// 도시 i에서 도시 j로 가는 최소 비용에 포함되어 있는 도시의 개수 k와 경로 출력
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				// i == j이거나 갈 수 없는 경우에는 0을 출력
				if(path[i][j] == INF) 
					System.out.print(0);
				else {
					stack.clear(); // 스택 비우기
					
					int mid = j;
					stack.push(j); // 도착도시 j 출력하기 위해 스택에 저장
					
					// 경로 역추적 (스택에 push)
					while (i != path[i][mid]) {
						mid = path[i][mid];
						stack.push(mid);
					}
					
					// 최소 비용에 포함되어 있는 도시 개수
					System.out.print((stack.size() + 1) + " ");
					
					// 경로상에 있는 도시 출력(스택에서 pop)
					System.out.print(i + " "); // 출발 도시 i 출력하기
					while(!stack.isEmpty()) {
						System.out.print(stack.pop() + " ");
					}
				}
				System.out.println();
			}
		}
	}
	
	public static void floydWarshall() {
		// 경유 도시
		for (int mid = 1; mid <= N; mid++) {
			// 출발 도시
			for (int start = 1; start <= N; start++) {
				// 도착 도시
				for (int end = 1; end <= N; end++) {
					// mid번째 노드를 거쳐가는 비용이 기존 비용보다 더 작은 경우 갱신
					// 또는 연결이 안되어있는 경우(INF) 연결 비용 갱신
					if (matrix[start][end] > matrix[start][mid] + matrix[mid][end]) {
						matrix[start][end] = matrix[start][mid] + matrix[mid][end];
						// start에서 end로 갈 때, end 도착 직전 도시를 저장
						path[start][end] = path[mid][end];
					}
				}
			}
		}
	}
}
