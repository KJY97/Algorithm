package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1966 {

	/**
	 * 문제
	 *  주어진 N 길이의 숫자열을 오름차순으로 정렬하여 출력하라
	 *   - 5 <= N <= 50
	 * 
	 * 시간: 114 ms
	 * 메모리: 18,392 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[] num = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			// 오름차순 정렬
			Arrays.sort(num);
			
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < N; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
		}
	}
}
