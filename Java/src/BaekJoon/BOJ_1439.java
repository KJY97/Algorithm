package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1439 {

	/**
	 * 문제
	 *  다솜이는 0과 1로만 이루어진 문자열 S를 가지고 있다. 다솜이는 이 문자열 S에 있는 모든 숫자를 전부 같게 만들려고 한다. 
	 *  다솜이가 할 수 있는 행동은 S에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것이다. 뒤집는 것은 1을 0으로, 0을 1로 바꾸는 것을 의미한다.
	 *  예를 들어 S=0001100 일 때,
	 *    1. 전체를 뒤집으면 1110011이 된다.
	 *    2. 4번째 문자부터 5번째 문자까지 뒤집으면 1111111이 되어서 2번 만에 모두 같은 숫자로 만들 수 있다.
	 *  하지만, 처음부터 4번째 문자부터 5번째 문자까지 문자를 뒤집으면 한 번에 0000000이 되어서 1번 만에 모두 같은 숫자로 만들 수 있다.  
	 *  문자열 S가 주어졌을 때, 다솜이가 해야하는 행동의 최소 횟수를 출력하시오.
	 *   - 문자열 S (S의 길이는 100만보다 작다)
	 *   - 제한시간 1초
	 * 
	 * 시간: 76 ms
	 * 메모리: 11480 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine(); // 문자열 S
		char[] chr = S.toCharArray();
		
		int cnt = 0; // 뒤집는 횟수
		
		// 문자 간 비교하여 서로 다른 문자인 경우 카운트 증가
		for (int i = 1; i < chr.length; i++) {
			if (chr[i-1] != chr[i]) cnt++;
		}
		
		// 011101과 같이 '01'과 '10'은 결국 같은 숫자를 뒤집는 것을 의미하므로 /2
		// 마지막 '01'과 같이 맨 처음과 맨 끝은 1번만 뒤집기 때문에 나머지로 해당 횟수를 더해준다.
		System.out.println(cnt/2 + cnt%2);
	}

}
