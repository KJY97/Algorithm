package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1284 {

	/**
	 * 문제
	 *  종민이의 집에서 한 달간 사용하는 수도의 양이 W리터라고 할 때, 요금이 더 저렴한 회사를 골라 그 요금을 출력하기
	 *   - A사 : 1리터당 P원의 돈을 내야 한다.
	 *   - B사 : 기본 요금이 Q원이고, 월간 사용량이 R리터 이하인 경우 요금은 기본 요금만 청구된다. 
	 *   		하지만 R 리터보다 많은 양을 사용한 경우 초과량에 대해 1리터당 S원의 요금을 더 내야 한다
	 *   - 1 ≤ P, Q, R, S, W ≤ 10000, 자연수
	 *   
	 * 시간: 100 ms
	 * 메모리: 18,360 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken()); // A회사의 1리터당 금액
			int Q = Integer.parseInt(st.nextToken()); // B회사의 기본 요금
			int R = Integer.parseInt(st.nextToken()); // B회사의 월간 사용량 기준
			int S = Integer.parseInt(st.nextToken()); // B회사의 추가 요금
			int W = Integer.parseInt(st.nextToken()); // 종민이의 한 달 사용량
			
			// 각 회사별 종민이가 지불한 금액
			int Acost = P * W;
			int Bcost = R >= W ? Q : Q + (W-R)*S;
			
			// 가장 저렴한 회사는?
			int min = Math.min(Acost, Bcost);
			System.out.println("#" + test_case + " " + min);
		}
	}
}
