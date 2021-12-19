package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_라이브러리사용ver {

	/**
	 * 문제
	 *  N개의 정수가 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 구하기
	 * => 순차탐색으로 하니 시간초과 발생
	 * => 이진탐색/검색 사용
	 *  	- 배열은 오름차순으로 정렬되어야 함
	 * => 라이브러리(binarySearch) 사용
	 * 
	 * 시간 : 1780 ms
	 * 메모리 : 72636 kb
	 */
	
	private static int N, num[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 1 ≤ N ≤ 100,000
		
		st = new StringTokenizer(br.readLine()); 
		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		// 이진탐색을 하려면 배열은 오름차순으로 정렬되어 있어야 한다!
		Arrays.sort(num);
		
		// 주어지는 M개 수들이 num[] 안에 존재하는가?
		int M = Integer.parseInt(br.readLine()); // 1 ≤ M ≤ 100,000
		st = new StringTokenizer(br.readLine()); 
		for (int i = 0; i < M; i++) {
			
			int target = Integer.parseInt(st.nextToken());

			// 존재하지 않는 값은 음수로 출력
			if(Arrays.binarySearch(num, target) < 0) 
				System.out.println(0);
			else
				System.out.println(1);
		}
	}

}
