package Programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class PG_주식가격 {

	/**
	 * 문제
	 *  초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 각 초의 주가를 기준으로 가격이 떨어지지 않은 기간은 몇 초인지를 구하라.
	 *   - prices의 각 가격은 1 이상 10,000 이하인 자연수
	 *   - prices의 길이는 2 이상 100,000 이하
	 *   
	 *  => 연속적으로 가격이 유지된 기간. 즉, 주가가 바로 떨어진 시점의 시간을 구한다.
	 *  => 떨어진 이후는 고려하지 않는다.
	 *  => 해결 방법은 2가지(이중for문, stack)
	 */
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution1(new int[] {1, 2, 3, 2, 3}))); // 이중for문
		System.out.println(Arrays.toString(solution2(new int[] {1, 2, 3, 2, 3}))); // stack
	}
	
	// 이중 for문을 활용한 방법. 시간 복잡도는 N²
	// 효율성 테스트 1 〉	통과 (19.31ms, 85.2MB)
	public static int[] solution1(int[] prices) {
		int size = prices.length;
        int[] answer = new int[size];
        
        for (int i = 0; i < size; i++) {
			for (int j = i+1; j < size; j++) {
				// 떨어지기 전까지 1초동안은 prices[i] 값을 유지하고 있다.
				answer[i]++;
				// 떨어진 이후는 고려하지 않음
				if(prices[i] > prices[j]) break;
			}
		}
        return answer;
    }
	
	// stack을 활용한 방법
	public static int[] solution2(int[] prices) {
		int size = prices.length;
        int[] answer = new int[size];
        
		// stack에 시간 저장하기
		Stack<Integer> stack = new Stack<>();
		
        int i = 0;
        stack.push(i);
        
		for (i = 0; i < size; i++) {
			// 스택이 비지 않고, 주가가 떨어진다면
			while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
				int top = stack.pop();
				answer[top] = i - top;
			}
			// 현재 시간 저장. idx값으로 저장한다.
			stack.add(i);
		}
		
		// 스택이 남아있다면..
		while(!stack.isEmpty()) {
			int top = stack.pop();
			// 끝에 도달한 시간(size-1)에서 top만큼 빼기
			answer[top] = size - 1 - top;
		}
		return answer;
	}
}
