package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273 {

	/**
	 * 문제
	 *  n개의 서로 다른 양의 정수 a1, a2, ..., an으로 이루어진 수열이 있다.
	 *  ai의 값은 1보다 크거나 같고, 1000000보다 작거나 같은 자연수이다.
	 *  자연수 x가 주어졌을 때, ai + aj = x (1 ≤ i < j ≤ n)을 만족하는 (ai, aj)쌍의 수를 구하는 프로그램을 작성하시오.
	 *   - 수열의 크기 n
	 *   - 1 ≤ n ≤ 100000, 1 ≤ x ≤ 2000000
	 *   - 제한시간 1초
	 *   
	 * => 1초 = 1억이므로 이중반복문 사용 시 시간초과 발생 (1000000²)
	 * => 투포인터 알고리즘을 사용한다.
	 *    투포인터의 경우 수열에 연속성이 필요하므로 정렬을 한다!
	 * 
	 * 시간: 300 ms
	 * 메모리: 27272 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine()); // 수열의 크기
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int X = Integer.parseInt(br.readLine()); // 원하는 두 수의 합

		// 투포인터 알고리즘을 사용하기 위해 값이 연속되도록 정렬
		Arrays.sort(arr);
		
		twoPointer(arr, 0, N-1, X);
	}
	
	/**
	 * 투포인터 알고리즘을 활용하여 두 수의 합이 find인 쌍을 찾는다.
	 * @param arr: 크기가 N인 수열
	 * @param right: 수열의 오른쪽부터 접근 
	 * @param left: 수열의 왼쪽부터 접근
	 * @param find: 원하는 두 수의 합
	 */
	public static void twoPointer(int[] arr, int left, int right, int find) {
		int cnt = 0; // 쌍의 수
		
		while(left < right) {
			int sum = arr[left] + arr[right];
			
			// 가장 큰 원소와 더했는데 find보다 크면 감소
			if (find < sum) right--;
			// 가장 큰 원소와 더했는데 find보다 작거나 같으면 증가
			else left++;
			
			if (find == sum) cnt++;
		}
		
		System.out.println(cnt);
	}

}
