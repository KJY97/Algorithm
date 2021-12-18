package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_10845 {

	/**
	 * 문제
	 *  정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하기
	 *   - push X: 정수 X를 큐에 넣는 연산
	 *   - pop: 큐에서 가장 위에 있는 정수를 빼고, 그 수를 출력. 정수가 없으면 -1 출력
	 *   - size: 큐에 들어있는 정수의 개수를 출력
	 *   - empty: 큐가 비어있으면 1, 아니면 0을 출력
	 *   - front: 큐의 가장 앞에 있는 정수를 출력. 정수가 없으면 -1 출력
	 *   - back: 큐의 가장 뒤에 있는 정수를 출력. 정수가 없으면 -1 출력
	 *   - 주어지는 정수 범위는 1 <= n <= 100,000
	 * => 큐 라이브러리 이용
	 * 
	 * 시간 : 364 ms
	 * 메모리 : 17276 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 명령의 수. 1 ≤ N ≤ 10,000
		LinkedList<Integer> queue = new LinkedList<>(); // 정수 저장하는 큐
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch (command) {
			case "push":
				queue.add(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(queue.isEmpty()) System.out.println("-1");
				else System.out.println(queue.removeFirst());
				break;
			case "size":
				System.out.println(queue.size());
				break;
			case "empty":
				if(queue.isEmpty()) System.out.println(1);
				else System.out.println(0);
				break;
			case "front":
				if(queue.isEmpty()) System.out.println("-1");
				else System.out.println(queue.getFirst());
				break;
			case "back":
				if(queue.isEmpty()) System.out.println("-1");
				else System.out.println(queue.getLast());
				break;
			}
		}
	}

}
