package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_2776 {

	/**
	 * 문제
	 *  연종이는 엄청난 기억력을 가지고 있다. 그래서 하루 동안 본 정수들을 모두 기억 할 수 있다.
	 *  하지만 이를 믿을 수 없는 동규는 그의 기억력을 시험해 보기로 한다.
	 *  동규는 연종을 따라 다니며, 연종이 하루 동안 본 정수들을 모두 ‘수첩1’에 적어 놓았다. 
	 *  그것을 바탕으로 그가 진짜 암기왕인지 알아보기 위해, 동규는 연종에게 M개의 질문을 던졌다.
	 *  질문의 내용은 “X라는 정수를 오늘 본 적이 있는가?” 이다. 연종은 막힘없이 모두 대답을 했고, 동규는 연종이 봤다고 주장하는 수 들을 ‘수첩2’에 적어 두었다.
	 *  집에 돌아온 동규는 답이 맞는지 확인하려 하지만, 연종을 따라다니느라 너무 힘들어서 여러분에게 도움을 요청했다.
	 *  동규를 도와주기 위해 ‘수첩2’에 적혀있는 순서대로, 각각의 수에 대하여, ‘수첩1’에 있으면 1을, 없으면 0을 출력하는 프로그램을 작성해보자.
	 *   - 제한시간 2초
	 *   - ‘수첩 1’에 적어 놓은 정수의 개수 N(1 ≤ N ≤ 1,000,000)이
	 *   - ‘수첩 2’에 적어 놓은 정수의 개수 M(1 ≤ M ≤ 1,000,000) 
	 * 
	 * => System.out.println() 사용 시 시간 초과 발생하여 StringBuilder 사용
	 * 
	 * 시간: 1912 ms
	 * 메모리: 384824 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 0; test_case < T; test_case++) {
			HashSet<Integer> note = new HashSet<>(); // 수첩1
			
			// 연종이 하루 동안 본 정수 저장
			int N = Integer.parseInt(br.readLine()); // 적어놓은 정수의 개수
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				note.add(Integer.parseInt(st.nextToken()));
			}
			
			// 연종이 봤다고 주장한 숫자가 실제로 맞는지 확인
			int M = Integer.parseInt(br.readLine()); // 적어놓은 정수의 개수
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int num = Integer.parseInt(st.nextToken());
				
				// 맞으면 1, 아니면 0
				if (note.contains(num)) 
					sb.append(1).append('\n');
				else 
					sb.append(0).append('\n');
			}
		}
		
		System.out.println(sb.toString());
	}

}
