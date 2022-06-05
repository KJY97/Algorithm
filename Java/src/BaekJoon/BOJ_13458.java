package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13458 {

	/**
	 * 문제
	 *  총 N개의 시험장이 있고, 각각의 시험장마다 응시자들이 있다. i번 시험장에 있는 응시자의 수는 Ai명이다. 감독관은 총감독관과 부감독관으로 두 종류가 있다. 
	 *  총감독관은 한 시험장에서 감시할 수 있는 응시자의 수가 B명이고, 부감독관은 한 시험장에서 감시할 수 있는 응시자의 수가 C명이다.
	 *  각각의 시험장에 총감독관은 오직 1명만 있어야 하고, 부감독관은 여러 명 있어도 된다.
	 *  각 시험장마다 응시생들을 모두 감시해야 한다. 이때, 필요한 감독관 수의 최솟값을 구하는 프로그램을 작성하시오.
	 *   - 시험장의 개수 N(1 ≤ N ≤ 1,000,000)
	 *   - 각 시험장에 있는 응시자의 수 Ai (1 ≤ Ai ≤ 1,000,000)
	 *   - 1 ≤ B, C ≤ 1,000,000
	 * 
	 * => 자료형 크기 주의
	 * 
	 * 시간 : 412 ms
	 * 메모리 : 121436 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 시험장 개수
		
		// 각 시험장에 있는 응시자 수 입력
		int[] room = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			room[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken()); // 총감독관이 감시할 수 있는 응시자 수
		int C = Integer.parseInt(st.nextToken()); // 부감독관이 감시할 수 있는 응시자 수

		long monitor = 0;
		for (int i = 0; i < N; i++) {
			// 총감독관이 감시하는 응시자 수 제거
			// 총감독관은 한반에 한명씩 반드시 배치
			room[i] -= B;
			monitor++;
			
			// 남은 응시자가 없다면 다음 시험장으로 이동
			if (room[i] <= 0) continue;
			
			// 기본 필요한 부감독관 인원 수 구하기
			monitor += room[i] / C;

			// 남은 인원 담당하는 부감독관 한명 추가
			if (room[i] % C != 0) monitor++;
		}
		
		// 최소 필요한 감독관 수
		System.out.println(monitor);
	}

}
