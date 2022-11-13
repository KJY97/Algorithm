package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1037 {

	/**
	 * 문제
	 *  양수 A가 N의 진짜 약수가 되려면, N이 A의 배수이고, A가 1과 N이 아니어야 한다. 
	 *  어떤 수 N의 진짜 약수가 모두 주어질 때, N을 구하는 프로그램을 작성하시오.
	 *   - N의 진짜 약수의 개수 M(1 <= M <= 50)
	 *   - N의 진짜 약수는 1,000,000보다 작거나 같고, 2보다 크거나 같은 자연수이고, 중복되지 않는다.
	 *   - N은 항상 32비트 부호있는 정수로 표현할 수 있다.
	 *   - 시간제한 2초
	 *   
	 * => 약수가 모두 주어지기 때문에, 약수 중 가장 큰 수와 작은 수를 곱하면 N을 구할 수 있다.
	 * 
	 * 시간: 76 ms
	 * 메모리: 11588 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int M = Integer.parseInt(br.readLine()); // N의 진짜 약수의 개수
		int[] num = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		System.out.println(num[0] * num[M-1]);

	}

}
