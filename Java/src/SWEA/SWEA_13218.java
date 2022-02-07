package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_13218 {

	/**
	 * 문제
	 *  매주 월요일과 수요일 오전 9시부터 10시 30분까지 진행되는 당신의 수업에는 N명의 수강생이 있다.
	 *  당신은 학생들에게 조별과제를 부여하기 위해 학생들을 몇 개의 조로 나누려고 한다.
	 *  당신은 한 조가 2명 이하의 학생으로 구성되면 토론이나 업무 배분 등이 제대로 이루어지지 않아 팀워크를 평가할 기회를 박탈당한다고 생각한다.
	 *  따라서, 당신은 3명 이상의 학생으로 구성된 조의 수를 최대화하려고 한다. 각 학생은 정확히 한 개의 조에만 속할 수 있다.
	 *  학생들을 조로 적당히 나누었을 때, 3명 이상의 학생으로 구성된 조의 수의 최댓값이 얼마인지를 구하기
	 *   - 학생 수 : 1 ≤ N ≤ 1000
	 *   
	 * 시간: 112 ms
	 * 메모리: 20,436 kb
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 학생 수. 1 ≤ N ≤ 1000
			int ans = 0; // 2명 이하로는 조를 구성할 수 없다.
			
			// 3명 이상부터 조 구성 가능
			if(N >= 3) ans = N / 3;
			
			System.out.println("#" + test_case + " " + ans);
		}
	}
}
