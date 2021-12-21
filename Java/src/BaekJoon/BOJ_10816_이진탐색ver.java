package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_10816_이진탐색ver {

	/**
	 * 문제
	 *  숫자 카드 N개가 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 몇 개 가지고 있는지 구하기
	 * => println으로 하면 시간초과 발생.. StringBuilder로 해결
	 * => target을 cnt해주면 시간초과 발생..
	 * 
	 * 시간 : 1248 ms
	 * 메모리 : 182348 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 숫자 카드 개수. 1 ≤ N ≤ 500,000
		int[] card = new int[N];
		
		// 입력되는 숫자 범위는 -10,000,000 <= n <= 10,000,000
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		// 이진탐색을 위해서는 오름차순으로 정렬 필요
		Arrays.sort(card);
		
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine()); // 몇 개를 가지고있는지 알고자 하는 수의 개수. 1 ≤ M ≤ 500,000
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			int idx = binarySearch(card, target);
			
			if (idx < 0) {
				sb.append('0').append(' ');
			}
			else {
				int cnt = binarySearchFinal(card, target) - binarySearch(card, target);
				sb.append(cnt).append(' ');
			}
		}
		System.out.println(sb);
	}
	
	// 배열 card에서 target이 처음으로 나오는 인덱스 찾기
	public static int binarySearch(int[] card, int target) {
		int start = 0, end = card.length - 1, mid;
		
		while(start < end) {
			mid = (start+end)/2;
			if(card[mid] >= target) end = mid;
			else start = mid + 1;
		}
		
		return end;
	}
	
	
	//  배열 card에서 target보다 큰 값이 처음으로 나오는 인덱스 찾기
	public static int binarySearchFinal(int[] card, int target)  {
		int start = 0, end = card.length - 1, mid;
		
		while(start < end) {
			mid = (start+end)/2;
			if(card[mid] > target) end = mid;
			else start = mid + 1;
		}
		
		if(card[end] == target) end++;
		return end;
	}
	
}
