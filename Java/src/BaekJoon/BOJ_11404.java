package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11404 {

	/**
	 * 문제
	 *  n(2 ≤ n ≤ 100)개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 m(1 ≤ m ≤ 100,000)개의 버스가 있다. 
	 *  각 버스는 한 번 사용할 때 필요한 비용이 있다.
	 *  모든 도시의 쌍 (A, B)에 대해서 도시 A에서 B로 가는데 필요한 비용의 최솟값을 구하는 프로그램을 작성하시오.
	 *   - 버스의 정보는 버스의 시작 도시 a, 도착 도시 b, 한 번 타는데 필요한 비용 c로 이루어져 있다.
	 *   - 시작 도시와 도착 도시가 같은 경우는 없다. 
	 *   - 비용은 100,000보다 작거나 같은 자연수이다.
	 *   - 시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있다.
	 *   -  i에서 j로 갈 수 없는 경우에는 그 자리에 0을 출력
	 *  
	 * => 플로이드 와샬 사용하기
	 * => 한 번 나온 도시쌍은 또 나올 수 있다! (중복 가능)
	 *    중복되는 값을 비교하여 최솟값을 저장한다.
	 * 
	 * 시간: 576 ms
	 * 메모리: 45760 kb
	 */
	
	private static int INF = 100 * 100_000;
	private static int[][] matrix;
	private static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine()); // 도시의 개수
		M = Integer.parseInt(br.readLine()); // 버스의 개수
		
		// ===== 인접행렬 INF로 초기화 =====
		matrix = new int[N+1][N+1]; // 1번 인덱스부터 사용
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				// 시작 도시와 도착 도시는 같지 않다 (= 0으로 처리)
				if (i != j) matrix[i][j] = INF;
			}
		}

		// ===== 인접행렬 입력 =====
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken()); // 시작 도시
			int b = Integer.parseInt(st.nextToken()); // 도착 도시
			int c = Integer.parseInt(st.nextToken()); // 한 번 타는데 필요한 비용
			
			matrix[a][b] = Math.min(matrix[a][b], c); // 중복값이 나오기 때문에 최소값 저장하기
		}
		
		// ===== 플로이드 와샬 =====
		floydWarshall();
		
		// ===== 출력 =====
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void floydWarshall() {
		// 경유 도시
		for (int tmp = 1; tmp <= N; tmp++) {
			// 시작 도시
			for (int from = 1; from <= N; from++) {
				// 시작 도시와 경유 도시가 같으면 pass
				if (from == tmp) continue;
				
				// 도착 도시
				for (int to = 0; to <= N; to++) {
					// 도착 도시와 시작 도시가 같거나, 경유 도시가 같은 경우 pass
					if(from == to || to == tmp) continue;
					
					// tmp번째 노드를 거쳐가는 비용이 기존 비용보다 더 작은 경우 갱신
					// 또는 연결이 안되어있는 경우(INF) 연결 비용 갱신
					matrix[from][to] = Math.min(matrix[from][to], matrix[from][tmp] + matrix[tmp][to]);
				}
			}
		}
		
		// i에서 j로 연결이 안되어있다면(INF) 0으로 수정
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(matrix[i][j] == INF) matrix[i][j] = 0;
			}
		}
	}

}
