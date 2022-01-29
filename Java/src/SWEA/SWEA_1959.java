package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1959 {

	/**
	 * 문제
	 *  N 개의 숫자로 구성된 숫자열 Ai (i=1~N) 와 M 개의 숫자로 구성된 숫자열 Bj (j=1~M) 가 있다.
	 *  Ai 나 Bj 를 자유롭게 움직여서 숫자들이 서로 마주보는 위치를 변경할 수 있다.
	 *  단, 더 긴 쪽의 양끝을 벗어나서는 안 된다.
	 *  서로 마주보는 숫자들을 곱한 뒤 모두 더할 때 최댓값을 구하라.
	 *   - 3 <= N, M <= 20
	 *   
	 * 시간: 109 ms
	 * 메모리: 19,788 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // A의 크기
			int M = Integer.parseInt(st.nextToken()); // B의 크기
			
			int[] Arr = new int[N];
			int[] Brr = new int[M];
			
			// A의 초기화
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				Arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// B의 초기화
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				Brr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			if(N > M) {
				for (int i = 0; i < N-M+1; i++) {
					int tmp = 0;
					for (int j = 0; j < M; j++) {
						tmp += Arr[j+i] * Brr[j];
					}
					max = Math.max(max, tmp);
				}
			}
			else if(N < M) {
				for (int i = 0; i < M-N+1; i++) {
					int tmp = 0;
					for (int j = 0; j < N; j++) {
						tmp += Arr[j] * Brr[j+i];
					}
					max = Math.max(max, tmp);
				}
			}
			else {
				for (int i = 0; i < N; i++) {
					int tmp = Arr[i] * Brr[i];
					max = Math.max(max, tmp);
				}
			}
			
			System.out.println("#" + test_case + " " + max);
		}

	}

}
