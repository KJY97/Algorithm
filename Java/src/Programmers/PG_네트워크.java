package Programmers;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class PG_네트워크 {

	/** 
	 * 문제
	 *  네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미한다. 
	 *  예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고, 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 
	 *  컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있다. 
	 *  따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있다.
	 *  컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 출력하기
	 *   - 컴퓨터의 개수 n은 1 이상 200 이하인 자연수
	 *   - 각 컴퓨터는 0부터 n-1인 정수로 표현
	 *   - i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현
	 *   - computer[i][i]는 항상 1
	 */
	public static void main(String[] args) {
		System.out.println(solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
		System.out.println(solution(3, new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
	}
	
	private static List<Integer> list[];
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        
        // 각 컴퓨터 간 거리를 리스트로 나타내기
        // 리스트 초기화
        list = new List[n];
        for (int i = 0; i < n; i++) {
			list[i] = new LinkedList<>();
		}
        
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i == j) continue; // 자기자신은 pass
				if(computers[i][j] == 1) // 연결되어 있는 경우만 저장
					list[i].add(j); 
			}
		}
        
        // BFS를 몇 번 방문하는지 체크 = 네트워크 수 체크
        boolean[] visited = new boolean[n]; // 각 컴퓨터 방문처리
        for (int i = 0; i < n; i++) {
			if(visited[i]) continue;
			BFS(i, visited);
			answer++;
		}
        
        return answer;
    }
	
	// 한 네트워크로 연결되어 있는 컴퓨터는 모두 방문처리한다.
	public static void BFS(int start, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int idx = queue.poll();
			
			for (Integer num : list[idx]) {
				if(visited[num]) continue;
				
				queue.add(num);
				visited[num] = true;
			}
		}
	}

}
