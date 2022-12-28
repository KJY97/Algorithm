package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_5800 {

	/**
	 * 문제
	 *  한상덕은 이번에 중덕 고등학교에 새로 부임한 교장 선생님이다. 
	 *  교장 선생님으로서 첫 번째 일은 각 반의 수학 시험 성적의 통계를 내는 일이다.
	 *  중덕 고등학교 각 반의 학생들의 수학 시험 성적이 주어졌을 때, 최대 점수, 최소 점수, 점수 차이를 구하는 프로그램을 작성하시오.
	 *  각 반에 대한 출력은 다음과 같이 두 줄로 이루어져 있다.
	 *  첫째 줄에는 "Class X"를 출력한다. X는 반의 번호이며 입력으로 주어진 순서대로 1부터 증가한다.
	 *  둘째 줄에는 가장 높은 점수, 낮은 점수, 성적을 내림차순으로 정렬했을 때 가장 큰 인접한 점수 차이를 예제 출력과 같은 형식으로 출력한다.
	 *   - 중덕 고등학교에 있는 반의 수 K (1 ≤ K ≤ 100)
	 *   - K개 줄에는 각 반의 학생수 N (2 ≤ N ≤ 50)과 각 학생의 수학 성적이 주어진다. 
	 *   - 시험 성적은 0보다 크거나 같고, 100보다 작거나 같은 정수이고, 공백으로 나누어져 있다. 
	 *   - 시간제한 1초
	 * 
	 * => 주의!!
	 *    Collections.reverseOrder()를 사용하려면 객체로 다뤄야 한다.
	 *    즉, 기본형 int를 객체로 다룰 수 있는 래퍼클래스(wrapper class)인 Integer 로 배열 선언 필수!
	 *    
	 * 시간: 96 ms
	 * 메모리: 12196 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int K = Integer.parseInt(br.readLine()); // 반의 수
		
		for (int classNum = 1; classNum <= K; classNum++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); // 학생 수
			Integer[] student = new Integer[N]; // 래퍼 클래스로 선언
			
			// 반의 학생 점수 초기화
			for (int i = 0; i < N; i++) {
				student[i] = Integer.parseInt(st.nextToken());
			}
			
			// 내림차순 정렬
			Arrays.sort(student, Collections.reverseOrder());
			
			int L_Gap = 0;
			for (int i = 1; i < N; i++) {
				L_Gap = Math.max(L_Gap, student[i-1] - student[i]);
			}
			
			System.out.println("Class " + classNum);
			System.out.println("Max " + student[0] + ", Min " + student[N-1] + ", Largest gap " + L_Gap);
		}
	}

}
