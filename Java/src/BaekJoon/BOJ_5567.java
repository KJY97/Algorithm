package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5567 {

	/**
	 * 문제
	 *  상근이는 자신의 결혼식에 학교 동기 중 자신의 친구와 친구의 친구를 초대하기로 했다. 
	 *  상근이의 동기는 모두 N명이고, 이 학생들의 학번은 모두 1부터 N까지이다. 상근이의 학번은 1이다.
	 *  상근이는 동기들의 친구 관계를 모두 조사한 리스트를 가지고 있다. 이 리스트를 바탕으로 결혼식에 초대할 사람의 수를 구하는 프로그램을 작성하시오.
	 *   - 상근이의 동기의 수 n (2 ≤ n ≤ 500)
	 *   - 리스트의 길이 m (1 ≤ m ≤ 10000)
	 *   - 친구 관계 ai bi (1 ≤ ai < bi ≤ n)
	 *     ai와 bi가 친구라는 뜻이며, bi와 ai도 친구관계이다.
	 * 
	 * 시간: 168 ms
	 * 메모리: 16860 kb
	 */
	
	private static List<Integer> list[];
	private static int N, M;
	
	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine()); // 동기 수
		M = Integer.parseInt(br.readLine()); // 리스트 길이
		
		// 각 동기 별 친구 관계 리스트 초기화
		list = new List[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		// 양방향 그래프 초기화
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b); // a와 b는 친구
			list[b].add(a); // b와 a는 친구
		}
		
		BFS();
	}
	
	private static void BFS() {
		Queue<Integer> queue = new LinkedList<>();
		int[] relation = new int[N+1];
		int cnt = 0; // 초대할 사람 수 카운트
		
		// 상근이(=1번)부터 탐색 시작
		queue.add(1);
		relation[1] = 1;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			cnt++;
			
			for (Integer friend : list[cur]) {
				// 이미 확인한 친구이거나 친구의 친구의 친구인 경우 skip
				if (relation[friend] != 0 || relation[cur] >= 3) continue;
				
				queue.add(friend);
				relation[friend] = relation[cur] + 1;
			}
		}
		
		// 자기 자신 빼기
		System.out.println(cnt-1);
	}

}
