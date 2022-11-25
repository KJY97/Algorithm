package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4344 {

	/**
	 * 문제
	 *  대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.
	 *  각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.
	 *   - 테스트 케이스의 개수 C
	 *   - 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)
	 *   - N명의 점수가 주어진다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
	 *   - 제한시간 1초
	 *   
	 * 시간: 116 ms
	 * 메모리: 13272 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int C = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		for (int test_case = 0; test_case < C; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); // 학생 수
			
			int[] student = new int[N];
			double avg = 0.0; // 평균
			
			for (int i = 0; i < N; i++) {
				student[i] = Integer.parseInt(st.nextToken());
				avg += student[i];
			}
			
			// 평균 구하기
			avg /= N;
			
			double ans = 0; // 평균 넘는 학생 수
			for (int i = 0; i < N; i++) {
				if (avg < student[i]) ans++;
			}
			
			// 평균 넘는 학생의 비율
			ans = ans * 100 / N;
			
			System.out.printf("%.3f%%\n", ans);
		}
	}

}
