package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11060 {

	/**
	 * 문제
	 *  재환이가 1×N 크기의 미로에 갇혀있다. 미로는 1×1 크기의 칸으로 이루어져 있고, 각 칸에는 정수가 하나 쓰여 있다. 
	 *  i번째 칸에 쓰여 있는 수를 Ai라고 했을 때, 재환이는 Ai이하만큼 오른쪽으로 떨어진 칸으로 한 번에 점프할 수 있다.
	 *  예를 들어, 3번째 칸에 쓰여 있는 수가 3이면, 재환이는 4, 5, 6번 칸 중 하나로 점프할 수 있다.
	 *  재환이는 지금 미로의 가장 왼쪽 끝에 있고, 가장 오른쪽 끝으로 가려고 한다.
	 *  이때, 최소 몇 번 점프를 해야 갈 수 있는지 구하는 프로그램을 작성하시오.
	 *  만약, 가장 오른쪽 끝으로 갈 수 없는 경우에는 -1을 출력한다.
	 *   - N(1 ≤ N ≤ 1,000)
	 *   - Ai (0 ≤ Ai ≤ 100)
	 *   - 제한시간 1초
	 *   
	 * 시간: 88 ms
	 * 메모리: 11948 kb
	 */
	
	private static int N;
	private static int[] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1]; // 1번 인덱스부터 사용
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		BFS(1);
	}
	
	private static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		int[] jumpCnt = new int[N+1]; // 1번 인덱스부터 사용
		
		queue.add(start);
		jumpCnt[start] = 1;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int i = 1; i <= map[cur]; i++) {
				int next = cur + i;
				
				// 범위를 벗어나거나 이미 접근했다면 skip
				if (next > N || jumpCnt[next] != 0) continue;
				
				queue.add(next);
				jumpCnt[next] = jumpCnt[cur] + 1;
			}
		}
		
		// 처음 1을 주고 시작했으므로 -1 해준다.
		System.out.println(jumpCnt[N] - 1);
	}

}
