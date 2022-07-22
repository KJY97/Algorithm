package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2447 {

	/**
	 * 문제
	 *  재귀적인 패턴으로 별을 찍어 보자. 
	 *  N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양이다.
	 *  크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.
	 *  -----
	 *   ***
	 *   * *
	 *   ***
	 *  -----
	 *  N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다.
	 *  예를 들어 크기 27의 패턴은 예제 출력 1과 같다.
	 *   - N은 3의 거듭제곱이다. 즉 어떤 정수 k에 대해 N=3^k이며, 이때 1 ≤ k < 8이다.
	 * 
	 * => 분할 정복
	 * => System.out.println을 사용하면 시간초과 발생
	 * 
	 * 시간: 280 ms
	 * 메모리: 68752 kb
	 */
	private static char[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());

		// 별 찍기 전 ' '으로 초기화
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = ' ';
			}
		}
		
		// 분할정복을 통한 별 찍기
		Division(0,0,N);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static void Division(int x, int y, int size) {
		// 더 이상 나눌 수 없으므로 출력
		if (size == 1) {
			map[x][y] = '*';
			return ;
		}
		
		int third = size/3;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				// 가운데이면 공백이 나와야 한다.
				if (i == 1 && j == 1) continue;
				else Division(x + third*i, y + third*j, third);
			}
		}
	}

}
