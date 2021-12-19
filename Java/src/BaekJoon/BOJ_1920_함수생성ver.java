package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1920_함수생성ver {

	/**
	 * 문제
	 *  N개의 정수가 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 구하기
	 * => 순차탐색으로 하니 시간초과 발생
	 * => 이진탐색/검색 사용
	 *  	- 배열은 오름차순으로 정렬되어야 함
	 * => 이진탐색(binarySearch) 함수 작성
	 * 
	 * 시간 : 2280 ms
	 * 메모리 : 98128 kb
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

			if(binarySearch(target)) 
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
	
	public static boolean binarySearch(int target) {
		int start = 0;
		int end = N - 1;
		
		while(start <= end) { // 최소 1개이상일 때
			int mid = (start + end) / 2;
			
			if (num[mid] == target) {
				return true;
			}
			else if (num[mid] < target) {
				start = mid + 1;
			}
			else if (num[mid] > target) {
				end = mid - 1;
			}
		}
		// 값을 찾을 수 없다면..
		return false;
	}

}
