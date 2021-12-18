package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10866 {

	/**
	 * 문제
	 *  정수를 저장하는 덱(Deque)을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하기
	 *   - push_front X: 정수 X를 덱의 앞에 넣는다.
	 *   - push_back X: 정수 X를 덱의 뒤에 넣는다.
	 *   - pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력. 정수가 없으면 -1 출력
	 *   - pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력. 정수가 없으면 -1 출력
	 *   - size: 덱에 들어있는 정수의 개수를 출력
	 *   - empty: 덱이 비어있으면 1, 아니면 0을 출력
	 *   - front: 덱의 가장 앞에 있는 정수를 출력. 정수가 없으면 -1 출력
	 *   - back: 덱의 가장 뒤에 있는 정수를 출력. 정수가 없으면 -1 출력
	 *    - 주어지는 정수 범위는 1 <= n <= 100,000
	 * => 덱 라이브러리 이용
	 * 
	 * 시간 : 404 ms
	 * 메모리 : 18504 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 명령의 수. 1 ≤ N ≤ 10,000
		Deque<Integer> deque = new LinkedList<>(); // 정수 저장하는 덱
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch (command) {
			case "push_front":
				deque.offerFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				deque.offerLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if(deque.isEmpty()) System.out.println("-1");
				else System.out.println(deque.pollFirst());
				break;
			case "pop_back":
				if(deque.isEmpty()) System.out.println("-1");
				else System.out.println(deque.pollLast());
				break;
			case "size":
				System.out.println(deque.size());
				break;
			case "empty":
				if(deque.isEmpty()) System.out.println(1);
				else System.out.println(0);
				break;
			case "front":
				if(deque.isEmpty()) System.out.println("-1");
				else System.out.println(deque.peekFirst());
				break;
			case "back":
				if(deque.isEmpty()) System.out.println("-1");
				else System.out.println(deque.peekLast());
				break;
			}
		}
	}

}
