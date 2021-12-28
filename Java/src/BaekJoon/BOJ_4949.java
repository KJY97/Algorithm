package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949 {

	/**
	 * 문제
	 *  문자열이 주어졌을 때, 균형잡힌 문자열인지 아닌지 판단하기
	 *   - 모든 왼쪽 소괄호 (, 대괄호 [는 오른쪽 소괄호 ) 대괄호 ]와만 짝을 이룬다
	 *   - 모든 오른쪽 괄호는 짝을 이룰 수 있는 왼쪽 괄호 존재(1:1 매칭)
	 *   - 짝을 이루는 두 괄호가 있을 때, 그 사이에 있는 문자열도 균형 잡혀야 한다
	 *   - 점 하나(.) 들어오면 종료
	 *   
	 * 시간: 308 ms
	 * 메모리: 17328 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		while(!str.equals(".")) {
			if(match(str)) System.out.println("yes");
			else System.out.println("no");
			
			str = br.readLine();
		}
	}
	
	// 짝이 맞는 괄호인가?
	public static boolean isPair(char item, char tmp) {
		if( (item == ')' && tmp == '(') || (item == ']' && tmp == '[')) return true;
		return false;
	}
	
	// 균형을 이룬 문자열인지 검사
	public static boolean match(String str) {
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			char item = str.charAt(i);
			
			if(item == '(' || item == '[') {
				stack.push(item); 
			}
			else if (item == ')' || item == ']') {
				if(stack.isEmpty()) return false;
					
				char tmp = stack.peek();
				
				if(isPair(item, tmp)) stack.pop();
				else return false;
			}
		}
		
		if(stack.isEmpty()) return true;
		else return false;
	}

}
