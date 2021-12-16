package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2908 {
	
	/**
	 * 문제
	 *  상수는 수를 거꾸로 읽는다. 두 수가 주어졌을 때, 두 수 중 큰 수를 말하는 상수의 대답 구하기 
	 *   - 예를 들어 734와 893가 주어진다면, 상수는 437과 398로 읽고, 437이 큰 수라 말한다.
	 *   - 두 수는 같지 않은 3자리 수. 0은 포함되지 않는다.
	 *   
	 * 시간 : 76 ms
	 * 메모리 : 11520 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String num1 = st.nextToken();
		String num2 = st.nextToken();
		
		int reverse1 = reverse(num1);
		int reverse2 = reverse(num2);

		System.out.println(reverse1 > reverse2 ? reverse1 : reverse2);
	}
	
	public static int reverse(String str) {
		String tmp = "";
		for (int i = str.length()-1; i >= 0; i--) {
			tmp += str.charAt(i);
		}
		return Integer.parseInt(tmp);
	}

}
