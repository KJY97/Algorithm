package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10815 {

	/**
	 * 문제
	 *  숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 
	 *  정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지를 구하는 프로그램을 작성하시오.
	 *  각 수가 적힌 숫자 카드를 상근이가 가지고 있으면 1을, 아니면 0을 공백으로 구분해 출력한다.
	 *   - 숫자 카드의 개수 N(1 ≤ N ≤ 500,000), 상근이가 가지고 있는 숫자 카드 개수 M(1 ≤ M ≤ 500,000)
	 *   - 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다. 
	 *   - 두 숫자 카드에 같은 수가 적혀있는 경우는 없다.
	 *  
	 * => 그리디 알고리즘으로 할 시 시간초과 발생 
	 * => 이진 탐색 사용
	 *   => 1. 직접 정의한 이진 탐색 함수 사용 (반복문으로 구현)
	 *   => 2. 자바에서 제공하는 Collections.binarySearch 함수 사용
	 * 
	 * 1번의 경우
	 *  시간: 3524 ms
	 *  메모리: 174208 kb
	 *  
	 * 2번의 경우
	 *  시간: 3532 ms
	 *  메모리: 182932 kb
	 */
	
	private static int N, M;
	private static List<Integer> cards;
	private static int[] nums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine()); // 숫자 카드 개수
		cards = new ArrayList<>();
		
		// 숫자 카드에 적혀있는 정수 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards.add(Integer.parseInt(st.nextToken()));
		}
		
		M = Integer.parseInt(br.readLine()); // 상근이가 가지고 있는 카드 개수
		nums = new int[M];
		
		// 상근이가 가지고 있는 숫자 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// binarySearch (이진 탐색)을 하기 위해서는 반드시 정렬된 상태여야 한다.
		Collections.sort(cards);
		
		// 상근이가 가지고 있는 숫자 카드가 cards에 포함된 숫자인지 출력 (방법 2가지)
		useDefindedMethod(); // 1. 반복문으로 직접 정의한 메소드 사용
//		useCollectionsMethod(); // 2. 자바에서 제공하는 메소드 사용
	}
	
	// 1. 직접 정의한 binarySearch 메소드 사용
	public static void useDefindedMethod() {
		for (int i = 0; i < M; i++) {
			int idx = binarySearch(nums[i]);
			
			if(idx < 0) System.out.print("0 ");
			else System.out.print("1 ");
		}
	}
	
	// 2. 자바에서 제공하는 Collections.binarySearch 메소드 사용
	public static void useCollectionsMethod() {
		for (int i = 0; i < M; i++) {
			int idx = Collections.binarySearch(cards, nums[i]);
			
			if(idx < 0) System.out.print("0 ");
			else System.out.print("1 ");
		}
	}
		
	// 반복문으로 구현한 이진 탐색 알고리즘
	public static int binarySearch(int target) {
		int start = 0, end = N-1, mid;
		
		while(start <= end) {
			mid = (start + end) / 2;
			
			// 원하는 값을 찾은 경우
			if(cards.get(mid) == target) {
				return mid;
			} 
			// 원하는 값이 중간점의 값보다 작은 경우 왼쪽 부분 확인
			else if(cards.get(mid) > target) {
				end = mid - 1;
			}
			// 원하는 값이 중간점의 값보다 큰 경우 오른쪽 부분 확인
			else {
				start = mid + 1;
			}
		}
		
		return -1;
	}
	
}
