package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1541 {

	/**
	 * 문제
	 *  세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.
	 *  그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
	 *  괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.
	 *   - 식은  ‘0’~‘9’, ‘+’, ‘-’ 만으로 이루어짐
	 *   - 가장 처음과 마지막 문자는 숫자이다.
	 *   - 연속해서 2개 이상의 연산자 나오지 않음
	 *   - 5자리보다 많이 연속되는 숫자 X
	 *   - 수는 0으로 시작할 수 있다.
	 *   - 식의 길이는 50보다 작거나 같다.
	 * 
	 * => Dangling meta character '+' near index 0 이 발생
	 * => 특수문자 \\ 를 추가하기 
	 * 
	 * 시간 : 80 ms
	 * 메모리 : 11532 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//식 저장
		String expression = br.readLine();
		
		// -를 기준으로 식을 쪼갠다.
		String[] exp_minus= expression.split("-");
		
		int answer = 0;
		for (int i = 0; i < exp_minus.length; i++) {
			
			// +를 기준으로 식을 자른다. -> 이제 숫자만 얻을 수 있다.
			String[] exp_plus = exp_minus[i].split("\\+");
			
			int sum = 0;
			for (int j = 0; j < exp_plus.length; j++) {
				sum += Integer.parseInt(exp_plus[j]);
			}
			
			if(i == 0) answer += sum;
			else answer -= sum;
		}
		
		System.out.println(answer);
	}

}
