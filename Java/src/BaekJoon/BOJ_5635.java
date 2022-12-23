package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_5635 {

	/**
	 * 문제
	 *  어떤 반에 있는 학생들의 생일이 주어졌을 때, 가장 나이가 적은 사람과 가장 많은 사람을 구하는 프로그램을 작성하시오.
	 *   - 학생의 수 n(1 ≤ n ≤ 100)
	 *   - n개 줄에는 각 학생의 이름과 생일이 "이름 dd mm yyyy"와 같은 형식으로 주어진다. 
	 *   - 이름은 그 학생의 이름이며, 최대 15글자로 이루어져 있다.
	 *   - dd mm yyyy는 생일 일, 월, 연도이다. (1990 ≤ yyyy ≤ 2010, 1 ≤ mm ≤ 12, 1 ≤ dd ≤ 31)
	 *   - 주어지는 생일은 올바른 날짜이며, 연, 월 일은 0으로 시작하지 않는다.
	 *   - 이름이 같거나, 생일이 같은 사람은 없다.
	 *   - 시간제한 1초
	 *   
	 * 시간: 72 ms
	 * 메모리: 11588 kb
	 */
	private static class Student implements Comparable<Student> {
		String name;
		int day, month, year;
		
		public Student(String name, int day, int month, int year) {
			this.name = name;
			this.day = day;
			this.month = month;
			this.year = year;
		}

		// 나이 순으로 오름차순 정렬
		@Override
		public int compareTo(Student o) {
			if (this.year != o.year) {
				return o.year - this.year;
			} else if (this.month != o.month) {
				return o.month - this.month;
			} else if (this.day != o.day) {
				return o.day - this.day;
			} else {
				return this.name.compareTo(o.name);
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine()); // 학생 수
		Student[] students = new Student[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			
			students[i] = new Student(name, day, month, year);
		}
		
		// 나이순 오름차순 정렬
		Arrays.sort(students);
		
		// 나이가 가장 적은 사람
		System.out.println(students[0].name);
		// 나이가 가장 많은 사람
		System.out.println(students[N-1].name);
	}

}
