package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2075 {

	/**
	 * 문제
	 *  N×N의 표에 수 N2개 채워져 있다. 채워진 수에는 한 가지 특징이 있는데, 모든 수는 자신의 한 칸 위에 있는 수보다 크다는 것이다. 
	 *  N=5일 때의 예를 보자.
	 *   ... 그림 생략 ...
	 *  이러한 표가 주어졌을 때, N번째 큰 수를 찾는 프로그램을 작성하시오. 표에 채워진 수는 모두 다르다.
	 *   - N(1 ≤ N ≤ 1,500)
	 *   - 표에 적힌 수는 -10억보다 크거나 같고, 10억보다 작거나 같은 정수이다.
	 *   
	 * => 우선순위 큐 활용하여 큰 수대로 나열하기 (내림차순 정렬)
	 * 
	 * 시간: 872 ms
	 * 메모리: 334240 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		// 내림차순으로 정렬
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		// NxN개의 수 큐에 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		// 앞에 있는 N-1번째 수 제거
		while(N-- != 1) {
			pq.poll();
		}
		
		System.out.println(pq.poll());
	}

}
