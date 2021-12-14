package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10818 {

	/**
	 * 문제
	 *  N개의 정수 중 최대값, 최소값 찾기
	 *   - 모든 정수의 범위. -1,000,000 <= n <= 1,000,000
	 *   
	 * 시간 : 448 ms
	 * 메모리 : 116944 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine()); // 정수의 개수. 1 ≤ N ≤ 1,000,000
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = -1_000_000, min = 1_000_000;
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(max < num) max = num;
			if(min > num) min = num;
		}
		System.out.println(min + " " + max);

	}

}
