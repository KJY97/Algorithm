package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_11736 {

	/**
	 * 문제
	 *  1 이상 N 이하의 정수가 적혀 있는 길이 N의 순열 p1, p2, …, pN이 있다. 수열에 있는 모든 숫자는 서로 다르다.
	 *  2 ≤ i ≤ N-1이며, pi-1, pi, pi+1 중 pi가 최솟값도, 최댓값도 아니라면 pi를 평범한 숫자라고 정의한다.
	 *  주어진 순열에서 평범한 숫자의 개수는 몇 개인가? 
	 *   - 3 ≤ N ≤ 20
	 *   - 3 ≤ pi ≤ N. 모든 pi는 서로 다르다.
	 *   
	 * 시간: 114 ms
	 * 메모리: 19,500 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 3 ≤ N ≤ 20
			
			// N개 숫자 입력
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 평범한 숫자는 몇 개?
			int cnt = 0;
			for (int i = 1; i < N-1; i++) {
				int min = arr[i-1], max = arr[i-1];
				
				max = Math.max(Math.max(max, arr[i]), arr[i+1]);
				min = Math.min(Math.min(min, arr[i]), arr[i+1]);
				
				// 평범한 숫자는 최대값도 최소값도 아니다.
				if(max != arr[i] && min != arr[i]) cnt++;
			}
			
			System.out.println("#" + test_case + " " + cnt);
		}

	}

}
