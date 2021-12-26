package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773 {

	/**
	 * 문제
	 *  부르는 모든 수를 받아 적은 후 그 수의 합 구하기
	 *   - 잘못된 수를 부를 때마다 0을 외쳐서 가장 최근에 쓴 수를 지운다.
	 *   - 정수 0는 지울 수 있는 수가 있음을 보장 -> 즉 맨 처음에 나오지 않는다
	 *   
	 * => 합의 범위가 2³¹-1 이라 하더라도 중간 과정에서는 넘을 수 있으므로 long 사용
	 * 
	 * 시간: 208 ms
	 * 메모리: 21588 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine()); // 입력할 정수 개수. 1 ≤ K ≤ 100,000
		
		Stack<Integer> stack = new Stack<>();
		long sum = 0L; // 최종 합. 0 <= sum <= 2³¹-1
		
		for (int i = 0; i < K; i++) {
			String num = br.readLine(); // 0 <= tmp <= 1,000,000
			if(num.equals("0")) {
				sum -= stack.peek();
				stack.pop();
			}
			else {
				stack.add(Integer.parseInt(num));
				sum += stack.peek();
			}
		}
		
		System.out.println(sum
				);
	}

}
