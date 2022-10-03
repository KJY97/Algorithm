package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1120 {

	/**
	 * 문제
	 *  길이가 N으로 같은 문자열 X와 Y가 있을 때, 두 문자열 X와 Y의 차이는 X[i] ≠ Y[i]인 i의 개수이다. 
	 *  예를 들어, X=”jimin”, Y=”minji”이면, 둘의 차이는 4이다.
	 *  두 문자열 A와 B가 주어진다. 이때, A의 길이는 B의 길이보다 작거나 같다.
	 *  이제 A의 길이가 B의 길이와 같아질 때 까지 다음과 같은 연산을 할 수 있다.
	 *   1. A의 앞에 아무 알파벳이나 추가한다.
	 *   2. A의 뒤에 아무 알파벳이나 추가한다.
	 *  이때, A와 B의 길이가 같으면서, A와 B의 차이를 최소로 하는 프로그램을 작성하시오.
	 *   - A와 B가 주어진다.
	 *   - A와 B의 길이는 최대 50이고, A의 길이는 B의 길이보다 작거나 같고, 알파벳 소문자로만 이루어져 있다.
	 *   - 제한시간 2초
	 *   
	 * 시간: 76 ms
	 * 메모리: 11512 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// A의 길이는 반드시 B보다 작거나 같다.
		String A = st.nextToken();
		String B = st.nextToken();
		
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i <= B.length() - A.length(); i++) {
			int cnt = 0;
			for (int j = 0; j < A.length(); j++) {
				if (A.charAt(j) != B.charAt(i+j)) cnt++;
			}
			
			min = Math.min(min, cnt);
		}
		
		System.out.println(min);
	}

}
