package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654 {

	/**
	 * 문제
	 *  길이가 제각각인 K개의 랜선을 같은 길이의 N개의 랜선으로 만들 때, 만들 수 있는 최대 랜선의 길이 구하기
	 *   - 자르거나 만들 때 손실되는 길이 없음
	 *   - 만들 수 없는 경우는 없음
	 *   - 센티미터 단위로 정수길이만큼 자름
	 *   - N개보다 많이 만드는 거 가능
	 *   - 랜선 길이는 1 <= length <= 2³¹-1
	 * 
	 * => 이진 탐색 응용 문제
	 * => 이진 탐색 범위가 곧 랜선의 길이
	 * => 랜선 길이가 ing형 최대값까지 주어지므로 long 타입 사용
	 * => mid = 0이 되는 경우를 방지하기 위해 자연수 탐색 범위를 0 ~ max+1로 늘린다.
	 * 
	 * 시간: 140 ms
	 * 메모리: 15344 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 항상 K ≦ N. 
		int K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선의 개수 K. 1 <= K <= 10,000
		int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수 N. 1 <= N <= 1,000,000
		
		// 초기화
		long max = 0;
		
		int[] arr = new int[K];
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(max < arr[i]) max = arr[i];
		}
		
		// 반드시 max에 +1 해주기!
		max++;
		
		long min = 0, ans = 0;
		while(min < max) {
			// 범위 내 중간 길이 구하기
			long mid = (min + max) / 2;
			
			// 중간 길이로 잘라서 총 몇 개가 만들어지는지 구하기
			long cnt = 0;
			for (int i = 0; i < K; i++) {
				cnt += (arr[i]/mid);
			}
			
			if(cnt >= N) {
				min = mid + 1;
				
				if(ans < mid) ans = mid;
			}
			else { // cnt < N
				max = mid;
			}
		}
		System.out.println(ans);
	}
}
