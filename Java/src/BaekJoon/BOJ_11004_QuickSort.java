package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11004_QuickSort {

	/**
	 * 문제
	 *  수 N개 A1, A2, ..., AN이 주어진다. A를 오름차순 정렬했을 때, 앞에서부터 K번째 있는 수를 구하는 프로그램을 작성하시오.
	 *   - N(1 ≤ N ≤ 5,000,000)과 K (1 ≤ K ≤ N)
	 *   - -10⁹ ≤ Ai ≤ 10⁹
	 *   - 시간제한 2초
	 *   
	 * => Arrays.sort(int[])를 사용하면 시간 초과 발생
	 *   왜냐하면 최악의 경우 시간이 O(N²) 걸리기 때문이다.
	 * => 래퍼 클래스를 사용한 Integer 정렬은 Collections.sort의 병합정렬을 사용하여 O(N log N) 시간이 걸린다.
	 * 
	 * => Quick Sort(퀵 정렬)의 시간 복잡도는  O(N log N)
	 * 
	 * 시간: 1912 ms
	 * 메모리: 502216 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 총 개수
		int K = Integer.parseInt(st.nextToken()); // 구해야 하는 수 위치
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		quickSort(arr, 0, N-1);
		
		System.out.println(arr[K-1]);
	}
	
	// 분할 정복 알고리즘 중 하나인 퀵 정렬을 사용한다
	public static void quickSort(int[] arr, int start, int end) {
		// 오른쪽 파티션의 시작점
		int part = partition(arr, start, end);
		
		// 시작점이 오른쪽 시작점보다 둘 이상 차이가 나면 왼쪽 파티션 퀵정렬
		if (start < part-1) {
			quickSort(arr, start, part-1);
		}
		
		// 오른쪽 시작점이 끝점보다 작을 때 오른쪽 파티션 퀵정렬
		if (part < end) {
			quickSort(arr, part, end);
		}
	}
	
	public static int partition(int[] arr, int start, int end) {
		int pivot = arr[(start+end)/2];
		
		while(start <= end) {
			while(arr[start] < pivot) start++;
			while(arr[end] > pivot) end--;
			
			if (start <= end) {
				swap(arr, start, end);
				start++;
				end--;
			}
		}
		
		return start;
	}
	
	public static void swap(int[] arr, int start, int end) {
		int tmp = arr[start];
		arr[start] = arr[end];
		arr[end] = tmp;
	}

}
