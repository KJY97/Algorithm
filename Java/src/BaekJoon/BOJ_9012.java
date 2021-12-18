package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012 {

	/**
	 * 문제
	 *  입력으로 주어진 괄호 문자열(Parenthesis String, PS)이 올바른 괄호 문자열(Valid PS, VPS)인지 판단하기
	 *   - 괄호 문자열의 길이는 2 이상 50 이하
	 *   - VPS면 YES, 아니면 NO
	 *   
	 * 시간 : 88 ms
	 * 메모리 : 11704 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 0; test_case < T; test_case++) {
			String PS = br.readLine();
			
			Stack<Character> stack = new Stack<>();
			boolean flag = false; // 중간에 break로 나가는 경우 체크
			for (int i = 0; i < PS.length(); i++) {
				char ch = PS.charAt(i);

				if(ch == '(') stack.push(ch);
				else {
					if(stack.isEmpty()) {
						flag = true;
						break;
					}
					stack.pop();
				}
			}
			
			if(!flag && stack.isEmpty()) System.out.println("YES");
			else System.out.println("NO");
		}
	}

}
