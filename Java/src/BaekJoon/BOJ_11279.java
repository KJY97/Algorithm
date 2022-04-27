package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_11279 {

	/**
	 * 문제
	 *  널리 잘 알려진 자료구조 중 최대 힙이 있다. 최대 힙을 이용하여 다음과 같은 연산을 지원하는 프로그램을 작성하시오.
	 *    1. 배열에 자연수 x를 넣는다.
	 *    2. 배열에서 가장 큰 값을 출력하고, 그 값을 배열에서 제거한다.
	 *  프로그램은 처음에 비어있는 배열에서 시작하게 된다.
	 *   - 1 ≤ N ≤ 100,000
	 *   - 연산에 대한 정보를 나타내는 정수 x. (1 <= x < 2³¹)
	 *   - x가 자연수면 추가하고 0이면 배열에서 가장 큰 값을 출력 및 제거한다.
	 *  
	 * => 우선순위큐 사용하기
	 * 
	 * 시간 : 1420 ms
	 * 메모리 : 32744 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 내림차순 정렬
		PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x != 0) heap.add(x);
			else {
				
				if(heap.isEmpty()) 
					System.out.println(0);
				else
					System.out.println(heap.poll());
			}
		}
	}

}
