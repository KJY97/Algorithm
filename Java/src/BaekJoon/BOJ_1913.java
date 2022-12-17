package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1913 {

	/**
	 * 문제
	 *  홀수인 자연수 N이 주어지면, 다음과 같이 1부터 N2까지의 자연수를 달팽이 모양으로 N×N의 표에 채울 수 있다.
	 *   ...그림...
	 *  N이 주어졌을 때, 이러한 표를 출력하는 프로그램을 작성하시오.
	 *  또한 N² 이하의 자연수가 하나 주어졌을 때, 그 좌표도 함께 출력하시오. 예를 들어 N=5인 경우 6의 좌표는 (4,3)이다.
	 *   - 홀수인 자연수 N(3 ≤ N ≤ 999)
	 *   - 둘째 줄에는 위치를 찾고자 하는 N² 이하의 자연수가 하나 주어진다.
	 *   - 제한시간 2초
	 * 
	 * => System.out.println 사용 시 시간 초과 발생하여 StirngBuilder 사용
	 * 
	 * 시간: 352 ms
	 * 메모리: 69300 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int find = Integer.parseInt(br.readLine()); // 찾고자 하는 자연수

		int[][] map = new int[N+1][N+1]; // 인덱스 1부터 시작
		
		int cnt = N*N; // N²부터 1까지 거꾸로 채우기
		int row = 0, col = 1, flag = 1;
		
		while(cnt > 0) {
			for (int i = 0; i < N; i++) {
				row += flag;
				map[row][col] = cnt;
				cnt--;
			}
			
			N--;
			
			for (int i = 0; i < N; i++) {
				col += flag;
				map[row][col] = cnt;
				cnt--;
			}
			
			flag *= -1;
		}
		
		int[] loc = new int[2]; //find의 좌표 저장
		
		// 출력
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[i].length; j++) {
				sb.append(map[i][j]).append(' ');
				
				// find의 좌표 저장
				if (map[i][j] == find) {
					loc[0] = i; loc[1] = j;
				}
			}
			sb.append('\n');
		}
		
		sb.append(loc[0]).append(' ').append(loc[1]);
		
		System.out.println(sb.toString());
	}

}
