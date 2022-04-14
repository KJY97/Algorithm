package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1927 {

	/**
	 * 문제
	 *  널리 잘 알려진 자료구조 중 최소 힙이 있다. 최소 힙을 이용하여 다음과 같은 연산을 지원하는 프로그램을 작성하시오.
	 *  =================================================
	 *   1. 배열에 자연수 x를 넣는다.
	 *   2. 배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
	 *  =================================================
	 *  프로그램은 처음에 비어있는 배열에서 시작하게 된다.
	 *   - 연산의 개수 N(1 ≤ N ≤ 100,000)
	 *   - 연산에 대한 정보를 나타내는 수 x가 자연수라면 배열에 추가하고, 0이면 가장 작은 값 출력 및 제거 (0 <= x <= 2³¹)
	 *   - 배열이 비어있는데 가장 작은 값을 출력하라고 하면 0을 출력
	 *   - 시간제한 : 1초
	 *   
	 * => 우선순위 큐 활용
	 * 
	 * 시간 : 1364 ms
	 * 메모리 : 32624 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 우선순위큐를 이용
		// 오름차순으로 정렬하여 가장 앞에 있는 값 제거
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine()); // 연산의 개수 
		
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine()); // 연산에 대해 정보를 나타내는 정수
			
			if(x > 0) heap.add(x);
			else if(x == 0 && heap.isEmpty()) System.out.println(0);
			else if(x == 0) System.out.println(heap.poll());
		}
	}

}
