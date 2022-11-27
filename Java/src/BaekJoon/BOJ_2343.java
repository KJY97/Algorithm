package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2343 {

	/**
	 * 문제
	 *  강토는 자신의 기타 강의 동영상을 블루레이로 만들어 판매하려고 한다.
	 *  블루레이에는 총 N개의 강의가 들어가는데, 블루레이를 녹화할 때, 강의의 순서가 바뀌면 안 된다.
	 *  순서가 뒤바뀌는 경우에는 강의의 흐름이 끊겨, 학생들이 대혼란에 빠질 수 있기 때문이다. 
	 *  즉, i번 강의와 j번 강의를 같은 블루레이에 녹화하려면 i와 j 사이의 모든 강의도 같은 블루레이에 녹화해야 한다.
	 *  강토는 이 블루레이가 얼마나 팔릴지 아직 알 수 없기 때문에, 블루레이의 개수를 가급적 줄이려고 한다.
	 *  오랜 고민 끝에 강토는 M개의 블루레이에 모든 기타 강의 동영상을 녹화하기로 했다.
	 *  이때, 블루레이의 크기(녹화 가능한 길이)를 최소로 하려고 한다. 단, M개의 블루레이는 모두 같은 크기이어야 한다.
	 *  강토의 각 강의의 길이가 분 단위(자연수)로 주어진다.
	 *  이때, 가능한 블루레이의 크기 중 최소를 구하는 프로그램을 작성하시오.
	 *   - 강의의 수 N (1 ≤ N ≤ 100,000)과 M (1 ≤ M ≤ N)
	 *   - 각 강의의 길이는 10,000분을 넘지 않는다.
	 *   - 제한시간 2초
	 * 
	 * => 이분탐색을 활용하는 문제
	 * => 무엇을 탐색할 것인지를 생각한다!
	 *    문제에서 정렬 없이 블루레이의 최소 크기를 구하라 했으므로 블루레이에 들어가는 강의 길이 주의하기
	 * 
	 * 시간: 256 ms
	 * 메모리: 22668 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 강의 수
		int M = Integer.parseInt(st.nextToken()); // 블루레이 개수
		int[] lecture = new int[N];
		
		// 블루레이 최소 길이 찾기
		int start = 0, end = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			lecture[i] = Integer.parseInt(st.nextToken());
			end += lecture[i];
			start = Math.max(start, lecture[i]);
		}
		
		// 이분 탐색 시작
		while(start <= end) {
			int mid = (start + end) / 2; // 블루레이 최소 크기 후보
			
			// mid 기준으로 몇 개의 블루레이가 만들어지는가?
			int cnt = 1; // 만들어지는 블루레이 수
			int sum = 0; // 블루레이 크기 합
			for (int i = 0; i < N; i++) {
				sum += lecture[i];
				
				// 임시 최소 크기보다 크면 새로운 블루레이 생성
				if (sum > mid) {
					sum = lecture[i];
					cnt++;
				}
			}
			
			// mid 기준으로 만들어진 블루레이 수와 강토가 만들고자 한 M개의 블루레이 수 비교 
			if (cnt > M) start = mid + 1;
			else end = mid - 1;
		}

		System.out.println(start);
	}

}
