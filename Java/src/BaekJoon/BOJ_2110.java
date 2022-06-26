package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {

	/**
	 * 문제
	 *  도현이의 집 N개가 수직선 위에 있다. 각각의 집의 좌표는 x1, ..., xN이고, 집 여러개가 같은 좌표를 가지는 일은 없다.
	 *  도현이는 언제 어디서나 와이파이를 즐기기 위해서 집에 공유기 C개를 설치하려고 한다. 
	 *  최대한 많은 곳에서 와이파이를 사용하려고 하기 때문에, 한 집에는 공유기를 하나만 설치할 수 있고, 가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치하려고 한다.
	 *  C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램을 작성하시오.
	 *   - 집의 개수 N (2 ≤ N ≤ 200,000)과 공유기의 개수 C (2 ≤ C ≤ N)
	 *   - 집의 좌표를 나타내는 xi (0 ≤ xi ≤ 1,000,000,000)
	 *   
	 * => 이진탐색 활용
	 * => 거리를 기준으로 탐색을 진행해야 한다.
	 * 
	 * 시간: 276 ms
	 * 메모리: 28368 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 집의 개수
		int C = Integer.parseInt(st.nextToken()); // 공유기의 개수
		
		int[] home = new int[N];
		
		for (int i = 0; i < N; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}
		
		// 이분탐색을 하기 위해서는 정렬이 필요하다.
		Arrays.sort(home);
		
		int answer = 0;
		
		// 이진탐색 진행
		int start = 0, end = home[N-1];
		while(start <= end) {
			int mid = (start+end)/2; // 공유기 설치 간격
			
			// 첫번째 집은 무조건 설치한다고 가정
			int cnt = 1, prev = home[0];
			for (int i = 1; i < N; i++) {
				// 현재 탐색하는 집의 위치와 이전 집의 위치간 거리가 mid보다 크거나 같을 때
				// 공유기 설치 개수 증가 및 마지막 설치 위치를 갱신한다.
				if (home[i] - prev >= mid) {
					cnt++;
					prev = home[i];
				}
			}
			
			if (cnt < C) end = mid - 1;
			else {
				answer = mid;
				start = mid + 1;
			}
		}
		
		System.out.println(answer);
	}

}
