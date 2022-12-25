package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_17413 {

	/**
	 * 문제
	 *  문자열 S가 주어졌을 때, 이 문자열에서 단어만 뒤집으려고 한다.
	 *  먼저, 문자열 S는 아래와과 같은 규칙을 지킨다.
	 *   1. 알파벳 소문자('a'-'z'), 숫자('0'-'9'), 공백(' '), 특수 문자('<', '>')로만 이루어져 있다.
	 *   2. 문자열의 시작과 끝은 공백이 아니다.
	 *   3. '<'와 '>'가 문자열에 있는 경우 번갈아가면서 등장하며, '<'이 먼저 등장한다. 또, 두 문자의 개수는 같다.
	 *  태그는 '<'로 시작해서 '>'로 끝나는 길이가 3 이상인 부분 문자열이고, '<'와 '>' 사이에는 알파벳 소문자와 공백만 있다. 
	 *  단어는 알파벳 소문자와 숫자로 이루어진 부분 문자열이고, 연속하는 두 단어는 공백 하나로 구분한다. 
	 *  태그는 단어가 아니며, 태그와 단어 사이에는 공백이 없다.
	 *   - 문자열 S(S의 길이는 100,000 이하이다)
	 *   - 시간제한 1초
	 *   
	 * 시간: 192 ms
	 * 메모리: 23628 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String S = br.readLine();
		Stack<Character> stack = new Stack<>();
		
		boolean isTag = false; // <를 만났는가?
		for (int index = 0; index < S.length(); index++) {
			char ch = S.charAt(index);
			
			// 태그를 만났다면 isTag 변경
			if (ch == '<') isTag = true;
			else if (ch == '>') {
				// 태그를 닫으면서 바로 다음 단어로 넘어가기
				isTag = false;
				sb.append(ch);
				continue;
			}
			
			if (isTag) {
				// 태그 안 단어는 뒤집지 않는다.
				// 태그 단어 시작 전, 저장해둔 단어 뒤집기
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(ch);
			} else {
				// 태그로 시작하지 않는다면 공백을 만나기 전까지의 단어를 뒤집는다.
				// 스택을 이용해서 단어 뒤집기
				if (ch != ' ') stack.add(ch);
				else {
					// 공백이 나오면 stack에 있는 단어 출력
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					sb.append(ch); // 공백 출력
				}
			}
		}
		
		// 스택에 남아있는 단어 모두 출력(뒤집기)
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb.toString());
	}

}
