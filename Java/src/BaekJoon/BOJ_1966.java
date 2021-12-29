package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966 {

	/**
	 * 문제
	 *  현재 큐에 있는 문서의 수와 중요도가 주어졌을 때, 어떤 한 문서가 몇 번째로 인쇄되는지 알아내기
	 *   - 현재 큐의 가장 앞에 있는 문서의 중요도 확인
	 *   - 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면 인쇄하지 않고 가장 뒤로 배치
	 *   - 그렇지 않다면 바로 인쇄
	 *   - 중요도는 1 ~ 9. 중요도가 같은 문서 여러개 존재 가능
	 * 
	 * => 큐로 풀이
	 * => 그러나 큐 안에는 객체가 들어가야 하므로 Paper 클래스 생성
	 * => 큐 라이브러리가 아닌 LinkedList로 생성. Queue는 인덱스별 접근이 불가하기 때문
	 * 
	 * 시간: 112 ms
	 * 메모리: 12764 kb
	 */
	
	private static class Paper {
		int impo, idx; // 문서 중요도와 번호(위치)

		public Paper(int impo, int idx) {
			this.impo = impo;
			this.idx = idx;
		}
	}
	
	private static LinkedList<Paper> queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); // 문서의 수. 1 ≤ N ≤ 100
			int M = Integer.parseInt(st.nextToken()); // 궁금한 문서의 큐의 위치 인덱스. 0 ≤ M < N
			
			queue = new LinkedList<>();
			
			// 큐 초기화
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int impo = Integer.parseInt(st.nextToken());
				queue.offer(new Paper(impo, i));
			}		
			
			int cnt = 0;
			while(!queue.isEmpty()) {
				Paper cur = queue.poll();
				
				if(isBigThanMe(cur.impo)) queue.offer(cur);
				else {
					cnt++;
					
					if(cur.idx == M) {
						System.out.println(cnt);
						break;
					}
				}
			}
		}
	}
	
	// 큐 안에 자신보다 중요도가 큰 문서가 있는지 확인
	public static boolean isBigThanMe(int impo) {
		for (int i = 0; i < queue.size(); i++) {
			if(impo < queue.get(i).impo) {
				return true;
			}
		}
		return false;
	}

}
