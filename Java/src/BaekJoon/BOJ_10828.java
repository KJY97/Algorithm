package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10828 {

	/**
	 * 문제
	 *  정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하기
	 *   - push X: 정수 X를 스택에 넣는 연산
	 *   - pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력. 정수가 없으면 -1 출력
	 *   - size: 스택에 들어있는 정수의 개수를 출력
	 *   - empty: 스택이 비어있으면 1, 아니면 0을 출력
	 *   - top: 스택의 가장 위에 있는 정수를 출력. 정수가 없으면 -1 출력
	 * 
	 * 시간 : 420 ms
	 * 메모리 : 17352 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 명령의 수. 1 ≤ N ≤ 10,000
		Stack<Integer> stack = new Stack<>(); // 정수 저장하는 스택
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch (command) {
			case "push":
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(stack.isEmpty()) System.out.println("-1");
				else System.out.println(stack.pop());
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				if(stack.isEmpty()) System.out.println(1);
				else System.out.println(0);
				break;
			case "top":
				if(stack.isEmpty()) System.out.println("-1");
				else System.out.println(stack.peek());
				break;
			}
		}

	}

}
