package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_15903 {

	/**
	 * 문제
	 *  석환이는 아기다. 아기 석환이는 자연수가 쓰여져있는 카드를 갖고 다양한 놀이를 하며 노는 것을 좋아한다. 
	 *  오늘 아기 석환이는 무슨 놀이를 하고 있을까? 바로 카드 합체 놀이이다!
	 *  아기 석환이는 자연수가 쓰여진 카드를 n장 갖고 있다. 처음에 i번 카드엔 ai가 쓰여있다. 카드 합체 놀이는 이 카드들을 합체하며 노는 놀이이다. 
	 *  카드 합체는 다음과 같은 과정으로 이루어진다.
	 *   1. x번 카드와 y번 카드를 골라 그 두 장에 쓰여진 수를 더한 값을 계산한다. (x ≠ y)
	 *   2. 계산한 값을 x번 카드와 y번 카드 두 장 모두에 덮어 쓴다.
	 *  이 카드 합체를 총 m번 하면 놀이가 끝난다. m번의 합체를 모두 끝낸 뒤, n장의 카드에 쓰여있는 수를 모두 더한 값이 이 놀이의 점수가 된다. 
	 *  이 점수를 가장 작게 만드는 것이 놀이의 목표이다.
	 *  아기 석환이는 수학을 좋아하긴 하지만, 아직 아기이기 때문에 점수를 얼마나 작게 만들 수 있는지를 알 수는 없었다(어른 석환이는 당연히 쉽게 알 수 있다)
	 *  그래서 문제 해결 능력이 뛰어난 여러분에게 도움을 요청했다. 만들 수 있는 가장 작은 점수를 계산하는 프로그램을 만들어보자.
	 *   - 카드의 개수를 나타내는 수 n(2 ≤ n ≤ 1,000)과 카드 합체를 몇 번 하는지를 나타내는 수 m(0 ≤ m ≤ 15×n)
	 *   - 맨 처음 카드의 상태를 나타내는 n개의 자연수의 범위 : 1 ≤ ai ≤ 1,000,000
	 *   - 제한시간 1초
	 * 
	 * => 1000 x 1000000 x 15000 = 15,000,000,000,000
	 * => int의 범위는 20억 이므로 범위를 넘어간다!
	 * => 그러므로 자료형 타입은 long을 사용
	 * 
	 * 시간: 132 ms
	 * 메모리: 13048 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 카드의 개수
		int M = Integer.parseInt(st.nextToken()); // 카드 합체 하는 횟수
		
		PriorityQueue<Long> card = new PriorityQueue<>(); // 오름차순 정렬
		
		// 맨 처음 카드 상태 초기화
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card.add(Long.parseLong(st.nextToken()));
		}
		
		// M번 만큼 카드 합체
		while(M-- != 0) {
			long a = card.poll();
			long b = card.poll();
			
			card.add(a+b);
			card.add(a+b);
		}
		
		// 모든 카드의 점수 더하기
		long sum = 0;
		while(!card.isEmpty()) {
			sum += card.poll();
		}
		
		System.out.println(sum);
	}

}
