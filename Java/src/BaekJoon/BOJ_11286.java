package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_11286 {

	/**
	 * 문제
	 *  절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.
	 *    1. 배열에 정수 x (x ≠ 0)를 넣는다.
	 *    2. 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다. 
	 *       절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
	 *  프로그램은 처음에 비어있는 배열에서 시작하게 된다.
	 *   - 연산의 개수 N. 1≤N≤100,000
	 *   - 연산에 대한 정보를 나타내는 정수 x. (-2³¹ <= x < 2³¹)
	 *   - x가 자연수면 추가하고 0이면 배열에서 가장 큰 값을 출력 및 제거한다.
	 * 
	 * => 우선순위 큐 + 객체 정렬
	 * 
	 * 시간 : 684 ms
	 * 메모리 : 29248 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 오름차순으로 정렬
		PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] abs1, int[] abs2) {
				if(abs1[1] == abs2[1]) // 절대값이 같으면 원래 값 비교 (오름차순)
					return abs1[0] - abs2[0];
				return abs1[1] - abs2[1];
			}
		});
		
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x != 0) heap.add(new int[] {x, Math.abs(x)});
			else {
				
				if(heap.isEmpty()) 
					System.out.println(0);
				else {
					int[] res = heap.poll();
					System.out.println(res[0]);
				}
			}
		}

	}

}
