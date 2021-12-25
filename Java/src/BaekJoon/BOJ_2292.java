package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2292 {

	/**
	 * 문제
	 *  벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나가는지 계산하기
	 *   - 벌집은 육각형 모양
	 *   - 시작과 끝 포함
	 * 
	 * 시간: 80 ms
	 * 메모리: 11472 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 찾는 방 번호. 1 ≤ N ≤ 1,000,000,000
		
		int num = 1;
		int cnt = 1;
		while(num < N) {
			num += cnt * 6;
			cnt++;
		}
		System.out.println(cnt);
	}

}
