package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {

	/**
	 * 문제
	 *  한수는 크기가 2^N × 2^N인 2차원 배열을 Z모양으로 탐색하려고 한다.
	 *  예를 들어, 2×2배열을 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸 순서대로 방문하면 Z모양이다.
	 *  N > 1인 경우, 배열을 크기가 2^(N-1) × 2^(N-1)로 4등분 한 후에 재귀적으로 순서대로 방문한다.
	 *  N이 주어졌을 때, r행 c열을 몇 번째로 방문하는지 출력하는 프로그램을 작성하시오.
	 *   - 1 ≤ N ≤ 15
	 *   - 0 ≤ r, c < 2ⁿ
	 *   - 시간 제한 존재(0.5초)
	 *   
	 * => 분할정복 이용
	 * 
	 * 시간 : 84 ms
	 * 메모리 : 11480 kb
	 */
	private static int r, c, answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 
		r = Integer.parseInt(st.nextToken()); // 행
		c = Integer.parseInt(st.nextToken()); // 열
		
		answer = 0;
		
		// 2ⁿ x 2ⁿ 크기인 배열
		divide(0, 0, (int)Math.pow(2, N));
	}
	
	public static void divide(int x, int y, int N) {
		
		if(r == x && c == y) {
			System.out.println(answer);
			return ;
		}
		
		if(x <= r && r < x + N && y <= c && c < y + N) {
			divide(x, y, N/2); // 왼쪽 위칸
			divide(x, y+N/2, N/2); // 오른쪽 위칸
			divide(x+N/2, y, N/2); // 왼쪽 아래칸
			divide(x+N/2, y+N/2, N/2); // 오른쪽 아래칸
		}
		else answer += N*N; 
	}
}
