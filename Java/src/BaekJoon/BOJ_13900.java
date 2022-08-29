package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13900 {

	/**
	 * 문제
	 *  N개의 정수 중 서로 다른 위치의 두 수를 뽑는 모든 경우의 두 수의 곱의 합을 구하라.
	 *  예를 들어 N = 3이고 주어진 정수가 2, 3, 4일 때, 두 수를 뽑는 모든 경우는 (2, 3), (2, 4), (3, 4)이며 이때 각각의 곱은 6, 8, 12이다. 따라서 총합은 26이다.
	 *   - 정수의 개수 N(2 ≤ N ≤ 100,000)
	 *   - 입력 받는 정수들의 범위는 0이상 10,000 이하이다.
	 *   - 제한시간 1초
	 * 
	 * => 합을 나타내는 sum의 자료형은 long으로 한다.
	 *    값이 10,000인 정수가 N개이고 이것을 경우의 수로 모두 더할 경우, int의 범위를 넘기 때문이다.
	 * => 100,000 x 100,000 = 10,000,000,000
	 *    즉, 1억  = 1초를 넘기 때문에 이중반복문으로 할 경우 O(N²)이 되어 시간초과 발생
	 * => (1*2)+(1*3)+(1*4)+(2*3)+(2*4)+(3*4)
	 *     = (1*(2+3+4))+(2(3*4))+(3*4)
	 *    앞의 항이 하나씩 커질수록 뒤의 항에 곱해지는 값은 하나씩 적어진다.
	 * 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		long sum = 0;
		for (int i = 0; i < N-1; i++) {
			int tmp = 0;
			for (int j = i+1; j < N; j++) {
				tmp += arr[j];
			}
			sum += tmp * arr[i];
		}
		
		System.out.println(sum);
	}

}
