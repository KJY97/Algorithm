package Programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class PG_여행경로 {

	/**
	 * 문제
	 *  주어진 항공권을 모두 이용하여 여행경로를 짜려고 합니다. 항상 "ICN" 공항에서 출발합니다.
	 *  항공권 정보가 담긴 2차원 배열 tickets가 매개변수로 주어질 때, 방문하는 공항 경로를 배열에 담아서 출력하라
	 *   - 모든 공항은 알파벳 대문자 3글자로 이루어집니다.
	 *   - 주어진 공항 수는 3개 이상 10,000개 이하입니다.
	 *   - tickets의 각 행 [a, b]는 a 공항에서 b 공항으로 가는 항공권이 있다는 의미
	 *   - 주어진 항공권은 모두 사용해야 합니다.
	 *   - 만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
	 *   - 모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.
	 *   
	 * => tickets3과 같은 경우 유의하기
	 * => 모든 경우의 수를 구하고 그 중 알파벳 순서가 앞서는 경로로 return
	 */
	
	public static void main(String[] args) {
		String[][] tickets1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"},{"ATL", "ICN"}, {"ATL","SFO"}};
		String[][] tickets3 = {{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}};
		System.out.println(Arrays.toString(solution(tickets1)));
		System.out.println(Arrays.toString(solution(tickets2)));
		System.out.println(Arrays.toString(solution(tickets3)));
	}
	
	private static LinkedList<String> allRoute;
	private static boolean[] visited;
	public static String[] solution(String[][] tickets) {
		allRoute = new LinkedList<>();
        visited = new boolean[tickets.length];
        
        // 모든 경우의 수를 구한다.
        // 모든 경로는 ICN에서 출발
		DFS("ICN", "ICN" , 0, tickets);
		
		// 알파벳 순서가 앞서는 경로로 return 해야 하므로 오름차순 정렬
		Collections.sort(allRoute);
		
		// 가장 앞에 있는 경로를 배열 형태로 return
        return allRoute.get(0).split(" ");
    }
	
	/**
	 * @param current : 현재 위치의 공항. 
	 * @param route : 경로를 저장하기 위한 변수
	 * @param cnt : 모든 도시를 방문했는지 체크하기 위한 용도
	 */
	public static void DFS(String current, String route, int cnt, String[][] tickets) {
		// 모든 도시를 방문해야 한다.
		if(cnt == tickets.length) {
			allRoute.add(route);
			return ;
		}
		
		for (int i = 0; i < visited.length; i++) {
			// 이미 방문했거나 current가 출발공항이 아니라면 pass
			if(visited[i] || !tickets[i][0].equals(current)) continue;
			
			visited[i] = true;
			DFS(tickets[i][1], route + " " + tickets[i][1], cnt+1, tickets);
			visited[i] = false;
		}
	}
	
}
