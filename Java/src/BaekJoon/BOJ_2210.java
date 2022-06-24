package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_2210 {

	/**
	 * 문제
	 *  5×5 크기의 숫자판이 있다. 각각의 칸에는 숫자(digit, 0부터 9까지)가 적혀 있다. 
	 *  이 숫자판의 임의의 위치에서 시작해서, 인접해 있는 네 방향으로 다섯 번 이동하면서, 각 칸에 적혀있는 숫자를 차례로 붙이면 6자리의 수가 된다.
	 *  이동을 할 때에는 한 번 거쳤던 칸을 다시 거쳐도 되며, 0으로 시작하는 000123과 같은 수로 만들 수 있다.
	 *  숫자판이 주어졌을 때, 만들 수 있는 서로 다른 여섯 자리의 수들의 개수를 구하는 프로그램을 작성하시오.
	 * 
	 * => 브루트포스 + DFS 사용
	 * 
	 * 시간: 820 ms
	 * 메모리: 15876 kb
	 */
	
	private static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private static String[][] board;
	private static List<String> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		board = new String[5][5]; // 5x5 크기의 숫자판
		list = new ArrayList<>(); // 만들어진 여섯 자리 수 저장하는 리스트
		
		// 숫자판 초기화
		for (int i = 0; i < 5; i++) {
			board[i] = br.readLine().split(" ");
		}
		
		// 임의의 위치에서 시작해서 인접한 모든 칸 이동하면서 숫자를 만드므로 모든 경우를 따져본다. (브루트포스 알고리즘)
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				DFS(i, j, "");
			}
		}
		
		// 출력
		System.out.println(list.size());
	}
	
	public static void DFS(int x, int y, String number) {
		
		if(number.length() == 6) {
			// 저장하지 않은 여섯 자리의 숫자라면 list에 추가
			if (!isContaines(number)) list.add(number);
			
			return ;
		}
		
		number += board[x][y];
		
		for (int d = 0; d < 4; d++) {
			int nx = x + deltas[d][0];
			int ny = y + deltas[d][1];
			
			// 범위를 벗어낫다면 skip
			if(!isRange(nx, ny)) continue;
			
			DFS(nx, ny, number);
		}
	}

	// 이미 만들어진 여섯자리의 숫자인가?
	private static boolean isContaines(String number) {
		return list.contains(number);
	}
	
	// 범위를 벗어나지 않았나?
	private static boolean isRange(int x, int y) {
		return 0 <= x && x < 5 && 0 <= y && y < 5;
	}

}
