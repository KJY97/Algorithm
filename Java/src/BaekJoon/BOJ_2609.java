package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2609 {

	/**
	 * 문제
	 *  두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하기
	 *   - 10,000이하의 자연수
	 * => 유클리드 호제법 사용해서 최대공약수 구하기
	 * => 두 개의 자연수 곱은 최대공약수와 최소공배수의 곱의 값과 같다.(AB = LG)
	 * 
	 * 시간 : 76 ms
	 * 메모리 : 11516 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		// 최대공약수 gcd
		System.out.println(gcd(a,b));
		// 최소공배수 lcm
		System.out.println(a*b/gcd(a,b));
	}
	
	public static int gcd(int a, int b) {
		if(b == 0) return a;
		return gcd(b, a % b);
	}

}
