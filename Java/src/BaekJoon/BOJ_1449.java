package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1449 {

	/**
	 * 문제
	 *  항승이는 품질이 심각하게 나쁜 수도 파이프 회사의 수리공이다. 항승이는 세준 지하철 공사에서 물이 샌다는 소식을 듣고 수리를 하러 갔다.
	 *  파이프에서 물이 새는 곳은 신기하게도 가장 왼쪽에서 정수만큼 떨어진 거리만 물이 샌다.
	 *  항승이는 길이가 L인 테이프를 무한개 가지고 있다.
	 *  항승이는 테이프를 이용해서 물을 막으려고 한다. 항승이는 항상 물을 막을 때, 적어도 그 위치의 좌우 0.5만큼 간격을 줘야 물이 다시는 안 샌다고 생각한다.
	 *  물이 새는 곳의 위치와, 항승이가 가지고 있는 테이프의 길이 L이 주어졌을 때, 항승이가 필요한 테이프의 최소 개수를 구하는 프로그램을 작성하시오.
	 *  테이프를 자를 수 없고, 테이프를 겹쳐서 붙이는 것도 가능하다.
	 *   - 물이 새는 곳의 개수 N과 테이프의 길이 L
	 *   - N과 L은 1,000보다 작거나 같은 자연수이고, 물이 새는 곳의 위치는 1,000보다 작거나 같은 자연수이다.
	 *   - 시간제한 2초
	 *   
	 * 시간: 80 ms
	 * 메모리: 11732 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 물이 새는 곳의 개수
		int L = Integer.parseInt(st.nextToken()); // 테이프의 길이
		
		int[] loc = new int[N]; // 물이 새는 위치
		
		// 물이 새는 곳의 위치 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			loc[i] = Integer.parseInt(st.nextToken());
		}
		
		// 위치값은 랜덤으로 주어지므로 오름차순으로 정렬
		Arrays.sort(loc);
		
		int cnt = 1; // 기본 1개부터 시작
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				// 두 위치 간격이 테이브의 길이보다 크거나 같으면
				if (loc[j] - loc[i] >= L) {
					cnt++; // 필요한 테이프 개수 1증가
					i = j-1; // 더이상 L길이의 테이프로 덮어지지 않는 위치 j를 i에 저장
					break;
				}
			}
		}
		System.out.println(cnt);
	}

}
