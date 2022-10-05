package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1735 {

	/**
	 * 문제
	 *  분수 A/B는 분자가 A, 분모가 B인 분수를 의미한다. A와 B는 모두 자연수라고 하자.
	 *  두 분수의 합 또한 분수로 표현할 수 있다. 두 분수가 주어졌을 때, 그 합을 기약분수의 형태로 구하는 프로그램을 작성하시오. 
	 *  기약분수란 더 이상 약분되지 않는 분수를 의미한다.
	 *   - 입력되는 네 자연수는 모두 30,000 이하이다.
	 *   - 제한시간 2초
	 *  
	 * 시간: 76 ms
	 * 메모리: 11500 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken()); // 분자
		int b = Integer.parseInt(st.nextToken()); // 분모
		
		st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken()); // 분자
		int d = Integer.parseInt(st.nextToken()); // 분모
		
		int numerator = a*d + b*c; // 분자
		int denominator = b*d; // 분모
		
		// 두 수의 공통 약수를 찾는다.
		int num = gcd(numerator, denominator);
		
		// 기약분수 출력
		System.out.println(numerator/num + " " + denominator/num);
	}
	
	// 최대공약수 구하기
	public static int gcd(int a, int b) {
		 if (a % b == 0) return b;
		 return gcd(b, a%b);
	}

}
