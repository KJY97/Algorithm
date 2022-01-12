package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805 {

	/**
	 * 문제
	 *  상근이는 나무 M미터가 필요하다. 목재 절단기를 이용해 높이가 H보다 큰 나무를 모두 절단해서 필요한 만큼만 가져가려고 한다.
	 *  적어도 M미터의 나무를 집에 가져가지 위해서 절단기에 설정할 수 있는 높이의 최댓값 구하기
	 * 
	 * => 이진 탐색 응용
	 * => 1654번과 비슷
	 * => mid = 0이 되는 경우를 방지하기 위해 자연수 탐색 범위를 0 ~ max+1로 늘린다.
	 * 
	 * 시간: 476 ms
	 * 메모리: 167840 kb 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 나무의 수. 1 ≤ N ≤ 1,000,000
		int M = Integer.parseInt(st.nextToken()); // 원하는 나무의 길이. 1 ≤ M ≤ 2,000,000,000
		
		long max = 0;
		
		int[] tree = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken()); // 0 <= tree length <= 1,000,000,000
			if(max < tree[i]) max = tree[i];
		}
		
		max++;
		
		// 이분 탐색 시작
		long min = 0, ans = 0;
		while(min <= max) {
			// 범위 내 중간 길이 구하기
			long mid = (min+max)/2;
			
			// 중간 길이(mid)로 잘라서 남은 나무 길이가 얼마인지 구하기
			long sum = 0;
			for (int i = 0; i < N; i++) {
				// mid보다 낮은 나무는 잘리지 않는다.
				if(tree[i] >= mid)
					sum += tree[i] - mid;
			}

			if(sum >= M) {
				min = mid + 1;
				if(ans < mid) ans = mid;
			}
			else {
				max = mid - 1;
			}
		}
		System.out.println(ans);
	}

}