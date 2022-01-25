package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SWEA_1983 {

	/**
	 * 문제
	 *  10개의 평점을 총점이 높은 순서대로 부여하는데, 각각의 평점은 같은 비율로 부여할 수 있다
	 *  예를 들어, N명의 학생이 있을 경우 N/10명의 학생들에게 동일한 평점을 부여할 수 있다.
	 *  입력으로 각각의 학생들의 중간, 기말, 과제 점수가 주어지고, 
	 *  학점을 알고싶은 K 번째 학생의 번호가 주어졌을 때, K 번째 학생의 학점을 출력하는 프로그램 작성하기
	 *   - N은 항상 10의 배수
	 *   - 10 ≤ N ≤ 100
	 *   - 1 ≤ K ≤ N
	 *   - K 번째 학생의 총점과 다른 학생의 총점이 동일한 경우는 입력으로 주어지지 않는다.
	 * 
	 * => 중요 포인트! N/10명에게 동일한 평점 부여
	 * => 학생들의 정확한 점수가 중요한 게 아니다! (학점이 중요!)
	 *   그러므로 totalSocre는 int형 사용
	 *  
	 * 시간: 106 ms
	 * 메모리: 18,836 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); // 학생 수
			int K = Integer.parseInt(st.nextToken()); // 학점 알고싶은 학생 번호

			String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"}; 
			Student[] students = new Student[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				int midScore = Integer.parseInt(st.nextToken());
				int finalScore = Integer.parseInt(st.nextToken());
				int homework = Integer.parseInt(st.nextToken());
				
				students[i] = new Student(i+1, midScore, finalScore, homework);
			}
			
			Arrays.sort(students); // 내림차순 정렬
			
			String ans = "";
			for (int i = 0; i < N; i++) {
				if(students[i].idx == K) {
					// N/10명에게 동일한 평점 부여
					// K번 학생
					ans = grade[i / (N/10)]; 
					break;
				}
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}
	
	public static class Student implements Comparable<Student> {
		int idx; // 학생 번호
		int midScore, finalScore, homework;
		int totalScore; 
		
		public Student(int idx, int midScore, int finalScore, int homework) {
			this.idx = idx;
			this.midScore = midScore;
			this.finalScore = finalScore;
			this.homework = homework;
			// 총 점수가 중요한게 아니므로 /100는 생략
			this.totalScore = midScore * 35 + finalScore * 45 + homework * 20; 
		}

		@Override
		public int compareTo(Student o) {
			return o.totalScore - this.totalScore;
		}
		
	}

}
