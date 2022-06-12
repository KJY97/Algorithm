package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644 {

	/**
	 * 문제
	 *  우리 나라는 가족 혹은 친척들 사이의 관계를 촌수라는 단위로 표현하는 독특한 문화를 가지고 있다. 이러한 촌수는 다음과 같은 방식으로 계산된다. 
	 *  기본적으로 부모와 자식 사이를 1촌으로 정의하고 이로부터 사람들 간의 촌수를 계산한다.
	 *  예를 들면 나와 아버지, 아버지와 할아버지는 각각 1촌으로 나와 할아버지는 2촌이 되고, 아버지 형제들과 할아버지는 1촌, 나와 아버지 형제들과는 3촌이 된다.
	 *  여러 사람들에 대한 부모 자식들 간의 관계가 주어졌을 때, 주어진 두 사람의 촌수를 계산하는 프로그램을 작성하시오.
	 *  어떤 경우에는 두 사람의 친척 관계가 전혀 없어 촌수를 계산할 수 없을 때가 있다. 이때에는 -1을 출력해야 한다.
	 *   - 사람들은 1, 2, 3, …, n (1 ≤ n ≤ 100)의 연속된 번호로 각각 표시된다
	 *   - 전체 사람의 수 n, 부모 자식들 간의 관계의 개수 m
	 *   - 부모 자식간의 관계를 나타내는 두 번호 x,y
	 *   - 이때 앞에 나오는 번호 x는 뒤에 나오는 정수 y의 부모 번호를 나타낸다.
	 *   - 각 사람의 부모는 최대 한 명만 주어진다.
	 *   
	 * 시간: 76 ms
	 * 메모리: 11684 kb
	 */

	private static List<Integer> family[]; 
	private static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine()); // 전체 사람의 수
		
		// 가계도 초기화
		family = new List[N+1];
		for (int i = 1; i <= N; i++) {
			family[i] = new LinkedList<>();
		}
		
		// 촌수를 계산해야 하는 서로 다른 사람의 번호 입력
		st = new StringTokenizer(br.readLine());
		int person1 = Integer.parseInt(st.nextToken());
		int person2 = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine()); // 부모 자식들 간의 관계의 개수
		
		// 부모 자식간의 관계 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken()); // 부모 번호
			int y = Integer.parseInt(st.nextToken()); // 자식 번호
			
			family[x].add(y);
			family[y].add(x);
		}
		
		System.out.println(BFS(person1, person2));
	}
	
	private static int BFS(int start, int end) {
		Queue<Integer> queue = new LinkedList<>();
		int[] distance = new int[N+1]; // start번 사람으로부터의 각 사람들의 촌수 계산
		
		queue.add(start);
		distance[start] = 1;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (Integer next : family[cur]) {
				// 이미 확인한 사람은 skip
				if(distance[next] != 0) continue;
				
				queue.add(next);
				distance[next] = distance[cur] + 1;
			}
		}
		
		// 처음 자기 자신과의 촌수 계산을 1로 시작했으므로 -1을 해준다.
		return distance[end] - 1;
	}

}
