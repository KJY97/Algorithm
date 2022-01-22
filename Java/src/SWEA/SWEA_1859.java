package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1859 {

	/**
	 * 문제
	 *  다음 조건 하에 사재기를 하여 최대한의 이득을 얻도록 도와주자!
	 *   - 연속된 N일 동안의 물건의 매매가를 예측하여 알고 있다
	 *   	- 2 ≤ N ≤ 1,000,000
	 *   - 당국의 감시망에 걸리지 않기 위해 하루에 최대 1만큼 구입
	 *   - 판매는 얼마든지 할 수 있다.
	 * 
	 * => 1000000 * 10000 = 10,000,000,000 이므로 long 사용하기
	 * 
	 * 시간: 464 ms
	 * 메모리: 129,692 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); 

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 연속된 N일. 2 ≤ N ≤ 1,000,000
			int[] arr = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken()); // 매매가 10,000이하
			}
			
			// 배열 뒤에서부터 가장 큰 값을 찾고 그 뒤 더 큰 값이 나올 때까지 값을 누적한다.
			long ans = 0;
			int max = arr[N-1];
			for (int i = N-2; i >= 0; i--) {
				if(max <= arr[i]) max = arr[i];
				else {
					// 배열 앞에서부터 접근하면 최댓값 이전의 값들의 개수 * 최대값 으로 계산하겠지만
					// 뒤에서부터 접근하므로 일일이 최댓값을 더해준다
					ans += max;
					ans -= arr[i];
				}
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}
}
