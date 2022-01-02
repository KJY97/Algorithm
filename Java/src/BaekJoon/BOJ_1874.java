package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874 {

	/**
	 * 문제
	 *  임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들수 있는지 없는지 판단하기
	 *   - 있다면 어떤 순서로 push, pop 연산 수행해야 하는지 알아내기
	 *   - 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다
	 * 
	 * => 스택의 원리 이해!
	 * => 출력초과 발생. StringBuilder 사용
	 * 
	 * 시간: 304 ms
	 * 메모리: 28892 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 1 ≤ n ≤ 100,000
		
		Stack<Integer> stack = new Stack<>();
		
		// 1이상 n이하 정수 주어짐
		int start = 0; // 스택에 어느 수까지 넣었는지 판단
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num > start) {
				// start+1부터 num까지 stack에 넣기
				for (int idx = start+1; idx <= num; idx++) {
					sb.append("+").append('\n');
					stack.push(idx);
				}
				start = num; // num까지 stack에 넣었다는 표시
			}
			// 수열 만들기가 불가능하다면 No 출력
			else if(num != stack.peek()) {
				System.out.println("NO");
				return ;
			}
			
			sb.append("-").append('\n');
			stack.pop();
		}
		System.out.println(sb);
	}
}
