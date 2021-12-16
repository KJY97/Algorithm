package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2475 {

	/**
	 * 문제
	 *  6자리의 고유번호가 주어질 때, 6번째 자리에 있는 검증수 구하기
	 *   - 처음 5자리에는 00000 ~ 99999 수가 빈칸을 사이에 두고 하나씩 주어짐
	 *   - 검증수 = 처음 5자리 숫자를 각각 제곱한 수의 합 % 10
	 *   
	 * 시간 : 76 ms
	 * 메모리 : 11480 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			sum += Math.pow(Integer.parseInt(st.nextToken()), 2);
		}
		
		System.out.println(sum % 10);
	}

}
