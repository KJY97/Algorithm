package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2063 {

	/**
	 * 문제
	 *  입력으로 N 개의 점수가 주어졌을 때, 중간값을 출력하기
	 *   - 중간값: 통계 집단의 수치를 크기 순으로 배열 했을 때 전체의 중앙에 위치하는 수치
	 *   - N은 항상 홀수. 9 ≤ N ≤ 199
	 *  
	 * 시간: 99 MS
	 * 메모리: 19,128 KB
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 배열 크기
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 크기 순으로 정렬
		Arrays.sort(arr);
		
		// 전체 크기의 중앙값 N/2
		System.out.println(arr[N/2]);
	}
}
