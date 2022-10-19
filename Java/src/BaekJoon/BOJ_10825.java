package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10825 {

	/**
	 * 문제
	 *  도현이네 반 학생 N명의 이름과 국어, 영어, 수학 점수가 주어진다. 
	 *  이때, 다음과 같은 조건으로 학생의 성적을 정렬하는 프로그램을 작성하시오.
	 *  =================================================
	 *   1. 국어 점수가 감소하는 순서로
	 *   2. 국어 점수가 같으면 영어 점수가 증가하는 순서로
	 *   3. 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
	 *   4. 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 
	 *      (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
	 *  =================================================
	 *   - 반의 학생의 수 N (1 ≤ N ≤ 100,000)
	 *   - 점수는 1보다 크거나 같고, 100보다 작거나 같은 자연수
	 *   - 이름은 알파벳 대소문자로 이루어진 문자열이고, 길이는 10자리를 넘지 않는다.
	 *   - 제한시간 1초
	 * 
	 * => Comparable을 이용하여 사용자정의 정렬을 만든다.
	 * 
	 * 시간: 1868 ms
	 * 메모리: 68836 kb
	 */
	public static class Student implements Comparable<Student> {
		String name;
		int kor, math, eng;
		
		public Student(String name, int kor, int math, int eng) {
			super();
			this.name = name;
			this.kor = kor;
			this.math = math;
			this.eng = eng;
		}

		@Override
		public int compareTo(Student st) {
			if (this.kor != st.kor) {
				// 국어 점수가 감소하는 순서 = 내림차순
				return st.kor - this.kor;
			} else if (this.eng != st.eng) {
				// 국어 점수가 같으면 영어 점수가 증가하는 순서 = 오름차순
				return this.eng - st.eng;
			} else if (this.math != st.math) {
				// 국어, 영어 점수가 같으면 수학 점수가 감소하는 순서 = 내림차순
				return st.math - this.math;
			} else {
				// 국영수 점수가 모두 같으면 이름을 사전 순으로 정렬
				return this.name.compareTo(st.name);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine()); // 학생 수
		
		Student[] group = new Student[N];
		
		// 학생 이름, 국영수 점수 초기화
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			
			group[i] = new Student(name, kor, math, eng);
		}
		
		// 정렬
		Arrays.sort(group);
		
		for (Student student : group) {
			System.out.println(student.name);
		}
	}
}
