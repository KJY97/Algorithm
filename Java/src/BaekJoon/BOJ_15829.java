package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15829 {

	/**
	 * 문제
	 *  ~생략~ 
	 *  어떻게 하면 순서가 달라졌을때 출력값도 달라지게 할 수 있을까? 
	 *  머리를 굴리면 수열의 각 항마다 고유한 계수를 부여하면 된다는 아이디어를 생각해볼 수 있다. 
	 *  항의 번호에 해당하는 만큼 특정한 숫자(=r)를 거듭제곱해서 곱해준 다음 더하는 것이다.
	 *  보통 r과 M은 서로소인 숫자로 정하는 것이 일반적이다. 
	 *  r의 값은 26보다 큰 소수인 31로 하고 M의 값은 1234567891(놀랍게도 소수이다!!)로 하자.
	 *  할 일은 위 식을 통해 주어진 문자열의 해시 값을 계산하기
	 *   - 영문 소문자마다 번호를 부여함(1번 부터 시작)
	 *   
	 * => Math.pow()는 31⁴⁹를 계산하면 값이 너무 커져서 오버플로우 발생. 그냥 계속 곱해주기
	 * => M으로 나눠줘도 값의 범위가 int를 벗어나므로 long형 사용
	 * => 해시값은 소수로 나눴을 때 가장 효율적
	 * => (a + b) mod M = {(a mod M) + (b mod M)} mod M 
	 * 
	 * 시간: 76 ms
	 * 메모리: 11512 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int L = Integer.parseInt(br.readLine()); // 문자열 길이. 1 ≤ L ≤ 50
		String str = br.readLine(); // 영문 소문자로 이루어진 문자열
		
		long pow_r = 1L;
		int M = 1234567891;
		
		long hash_value = 0L;
		for (int i = 0; i < L; i++) {
			hash_value = (hash_value + (str.charAt(i) - 'a' + 1) * pow_r) % M;
			pow_r = (pow_r * 31) % M; // Math.pow() 하면 범위 벗어나서
		}
		
		System.out.println(hash_value % M);
	}

}
