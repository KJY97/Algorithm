package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14496 {

	/**
	 * 문제
	 *  선린에 합격한 대호에게는 큰 고민이 있다. 
	 *  대호는 중학교 3년 내내 공부만 했기 때문에, 요즘 학생들이 사용하는 ‘야민정음’에 대해서는 문외한이다.
	 *  친구들의 대화에 끼고 싶은 대호는 야민정음을 공부하기로 했다.
	 *  야민정음이란, 비슷한 모양의 글자를 원래 문자 대신에 사용하는 것을 일컫는다.
	 *  예를 들어, ‘그대’는 ‘그머’로, ‘팔도비빔면’은 ‘괄도네넴댼’으로, ‘식용유’는 ‘식용윾’으로, ‘대호’는 ‘머호’로 바꿀 수 있다.
	 *  아무 문자나 치환할 수 있는 건 아니며 치환이 가능한 몇 개의 문자들이 정해져있다.
	 *  예를 들어보자. (a, b), (a, c), (b, d), (c, d)가 주어지는 경우, a를 d로 바꾸는 방법은 a-b-d, a-c-d로 2개가 있다.
	 *  (a, b), (b, c), (a, c)가 주어지는 경우, a를 c로 바꾸는 방법은 a-b-c, a-c의 2개가 있다. 하지만 이 경우에는 치환횟수에 차이가 생기게 된다.
	 *  머호는 문자 a를 문자 b로 바꾸려하고, N개의 문자와 치환 가능한 문자쌍 M개가 있다. 
	 *  머호에게 a를 b로 바꾸기 위한 치환의 최소 횟수를 구해서 머호에게 알려주자!
	 *  프로그램 작성의 편의를 위해, 머호가 공부하는 모든 문자는 자연수로 표현되어 주어진다.
	 *  a를 b로 바꾸기 위해 필요한 최소 치환 횟수를 출력한다. 치환이 불가능한 경우는 –1을 출력한다.
	 *   - 첫째 줄에 머호가 바꾸려 하는 문자 a와 b가 주어진다
	 *   - 전체 문자의 수 N과 치환 가능한 문자쌍의 수 M (1 ≤ N ≤ 1,000, 1 ≤ M ≤ 10,000) 
	 *   - M개의 줄에 걸쳐 치환 가능한 문자쌍이 주어진다.
	 *   - 모든 문자는 N이하의 자연수로 표현된다.
	 *   - 제한시간 2초
	 *   
	 * 시간: 168 ms
	 * 메모리: 17572 kb
	 */
	
	private static int N, M;
	private static List<Integer> word[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 대호가 바꾸려는 문자
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 전체 문자 수
		M = Integer.parseInt(st.nextToken()); // 치환 가능한 문자쌍 수
		
		// 문자 수에 맞게 초기화
		word = new List[N+1]; // 1번 인덱스부터 사용
		for (int i = 1; i <= N; i++) {
			word[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			word[s].add(d);
			word[d].add(s);
		}
		
		System.out.println(BFS(a, b));
	}
	
	private static int BFS(int start, int dis) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		int[] count = new int[N+1];
		
		queue.add(start);
		visited[start] = true;
		count[start] = 1;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			if (cur == dis) {
				break;
			}
			
			for (Integer next : word[cur]) {
				// 이미 확인했다면 skip
				if (visited[next] || count[next] != 0) continue;
				
				visited[next] = true;
				count[next] = count[cur] + 1;
				queue.add(next);
			}
		}
		
		if (count[dis] == 0) {
			return -1;
		} else {
			// 처음 시작 시 1을 주고 했으므로 빼준다.
			return count[dis] - 1;
		}
	}
	
}
