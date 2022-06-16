package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2512 {

	/**
	 * 문제
	 *  국가의 역할 중 하나는 여러 지방의 예산요청을 심사하여 국가의 예산을 분배하는 것이다.
	 *  국가예산의 총액은 미리 정해져 있어서 모든 예산요청을 배정해 주기는 어려울 수도 있다. 
	 *  그래서 정해진 총액 이하에서 가능한 한 최대의 총 예산을 다음과 같은 방법으로 배정한다.
	 *    1. 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정한다.
	 *    2. 모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 계산하여 그 이상인 예산요청에는 모두 상한액을 배정한다. 
	 *        상한액 이하의 예산요청에 대해서는 요청한 금액을 그대로 배정한다. 
	 *  예를 들어, 전체 국가예산이 485이고 4개 지방의 예산요청이 각각 120, 110, 140, 150이라고 하자.
	 *  이 경우, 상한액을 127로 잡으면, 위의 요청들에 대해서 각각 120, 110, 127, 127을 배정하고 그 합이 484로 가능한 최대가 된다. 
	 *  여러 지방의 예산요청과 국가예산의 총액이 주어졌을 때, 위의 조건을 모두 만족하도록 예산을 배정하는 프로그램을 작성하시오.
	 *   - 지방의 수를 의미하는 정수 N (3 <= N <= 10000)
	 *   - 각 지방의 예산요청 값은 모두 1 이상 100,000 이하
	 *   - 총 예산을 나타내는 정수 M (N <= M <= 1,000,000,000)
	 *   
	 * => 이진 탐색 이용하기
	 * 
	 * 시간: 128 ms
	 * 메모리: 14048 kb
	 */
	
	private static int N, M;
	private static int[] money;
	private static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine()); // 지방의 수
		money = new int[N];
		
		// 각 지방의 예산요청 금액 저장
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine()); // 총 예산을 나타내는 정수
		answer = 0; // 배정된 예산들 중 최댓값
		
		Arrays.sort(money);
		
		// binarySearch(이진탐색)을 통해 적절한 상한액 찾기
		int start = 0, end = money[N-1], mid = 0;
		
		while(start <= end) {
			mid = (start + end) / 2;
			
			if(isAvailable(mid)) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		System.out.println(answer);
	}
	
	// 예상 상한액이 사용 가능한가? (limit: 예상 상한액)
	public static boolean isAvailable(int limit) {
		
		// 예상 상한액 기준으로 예산요청 금액을 모두 제공할 때 그 합이 국가예산 총액을 넘는가?
		int sum = 0;
		for (int i = 0; i < N; i++) {
			// 상한액 이하의 예산요청이라면 그대로 배정
			if(money[i] <= limit) sum += money[i];
			else sum += limit;
		}
		
		// 총 예산보다 큰 경우 fail
		if(sum > M) 
			return false;
		
		// 상한액보다 큰 예산요청 금액이라면 상한액만큼만 배정. 
		// 오름차순으로 정렬했기 때문에 마지막 요청금액만 확인한다.
		int tmp = money[N-1] > limit ? limit : money[N-1];
		answer = Math.max(answer, tmp);
		return true;
	}

}