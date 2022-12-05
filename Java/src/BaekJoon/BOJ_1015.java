package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1015 {

	/**
	 * 문제
	 *  P[0], P[1], ...., P[N-1]은 0부터 N-1까지(포함)의 수를 한 번씩 포함하고 있는 수열이다. 
	 *  수열 P를 길이가 N인 배열 A에 적용하면 길이가 N인 배열 B가 된다. 적용하는 방법은 B[P[i]] = A[i]이다.
	 *  배열 A가 주어졌을 때, 수열 P를 적용한 결과가 비내림차순이 되는 수열을 찾는 프로그램을 작성하시오.
	 *  비내림차순이란, 각각의 원소가 바로 앞에 있는 원소보다 크거나 같을 경우를 말한다.
	 *  만약 그러한 수열이 여러개라면 사전순으로 앞서는 것을 출력한다.
	 *   - 배열 A의 크기 N (1 <= N <= 50)
	 *   - 배열 A의 원소가 0번부터 차례대로 주어진다.
	 *   - 배열의 원소는 1,000보다 작거나 같은 자연수이다.
	 *   - 제한시간 2초
	 *   
	 * 시간: 88 ms
	 * 메모리: 11764 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine()); // 배열의 크기
		
		int[] arr = new int[N];
		int[] brr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			brr[i] = arr[i];
		}
		
		// arr에 수열 p가 적용된 모습 = arr의 오름차순 모습
		Arrays.sort(brr);
		
		// 2중 반복문의 시간복잡도는 O(N²) = 50² 이므로 1초 안 가능
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// B[P[i]] = A[i] 이므로, P[i]는 brr의 인덱스가 된다.
				// brr은 arr의 오름차순 모습이므로, 두 값이 일치할 경우 brr의 인덱스는 P[i]가 된다.
				if (arr[i] == brr[j]) {
					// 같은 값이 저장되어 있으므로 처리한 값 제거
					brr[j] = -1;
					System.out.print(j + " ");
					break;
				}
			}
		}
		
	}

}
