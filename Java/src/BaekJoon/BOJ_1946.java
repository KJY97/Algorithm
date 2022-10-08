package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1946 {

	/**
	 * 문제
	 *  언제나 최고만을 지향하는 굴지의 대기업 진영 주식회사가 신규 사원 채용을 실시한다. 인재 선발 시험은 1차 서류심사와 2차 면접시험으로 이루어진다.
	 *  최고만을 지향한다는 기업의 이념에 따라 그들은 최고의 인재들만을 사원으로 선발하고 싶어 한다.
	 *  그래서 진영 주식회사는, 다른 모든 지원자와 비교했을 때 서류심사 성적과 면접시험 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발한다는 원칙을 세웠다.
	 *  즉, 어떤 지원자 A의 성적이 다른 어떤 지원자 B의 성적에 비해 서류 심사 결과와 면접 성적이 모두 떨어진다면 A는 결코 선발되지 않는다.
	 *  이러한 조건을 만족시키면서, 진영 주식회사가 이번 신규 사원 채용에서 선발할 수 있는 신입사원의 최대 인원수를 구하는 프로그램을 작성하시오. 
	 *   - 테스트 케이스의 개수 T(1 ≤ T ≤ 20)
	 *   - 지원자의 숫자 N(1 ≤ N ≤ 100,000)
	 *   - 서류심사 성적, 면접 성적의 순위는 모두 1위부터 N위까지 동석차 없이 결정된다고 가정한다.
	 *   - 시간제한 2초
	 *   
	 * 시간: 2420 ms
	 * 메모리: 308596 kb
	 */
	
	private static class Person implements Comparable<Person> {
		int document, interview;

		public Person(int document, int interview) {
			this.document = document;
			this.interview = interview;
		}

		@Override
		public int compareTo(Person o) {
			// 서류 기준 오름차순 정렬
			return this.document - o.document;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수
		
		for (int test_case = 0; test_case < T; test_case++) {
			int N = Integer.parseInt(br.readLine()); // 지원자 개수
			
			Person[] apply = new Person[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				int document = Integer.parseInt(st.nextToken()); // 서류 심사 성적 순위
				int interview = Integer.parseInt(st.nextToken()); // 면접 심사 성적 순위
				
				apply[i] = new Person(document, interview);
			}
			
			// 서류 기준 오름차순 정렬
			Arrays.sort(apply);
			
			int flag = apply[0].interview; // 서류 기준 1순위의 면접 성적
			int cnt = 1; // 서류 1등은 무조건 선발이기 때문
			
			for (int i = 1; i < N; i++) {
				// 다른 지원자와 비교해서 면접 성적이 더 좋은 지원자가 나오면 카운트 증가
				if (apply[i].interview < flag) {
					flag = apply[i].interview;
					cnt++;
				}
			}
			
			System.out.println(cnt);
		}
	}
}
