package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_1780 {

	/**
	 * 문제
	 *  N×N크기의 행렬로 표현되는 종이가 있다. 종이의 각 칸에는 -1, 0, 1 중 하나가 저장되어 있다. 
	 *  우리는 이 행렬을 다음과 같은 규칙에 따라 적절한 크기로 자르려고 한다.
	 *  ======================================================================
	 *   1. 만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
	 *   2. (1)이 아닌 경우에는 종이를 같은 크기의 종이 9개로 자르고, 각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.
	 *  ======================================================================
	 *  이와 같이 종이를 잘랐을 때, -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수를 구해내는 프로그램을 작성하시오.
	 *   - 1 ≤ N ≤ 3⁷, N은 3ⁿ
	 * 
	 * => 분할정복으로 문제풀기
	 * 
	 * 시간 : 872 ms
	 * 메모리 : 319596 kb
	 */
	private static int[][] map;
	private static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = new int[3];
		
		Divide(0,0,N);
	
		for (int i = 0; i < 3; i++) {
			System.out.println(result[i]);
		}
	}
	
	public static void Divide(int x, int y, int size) {
		
		// -1, 0, 1로만 채워져있는지 확인
		if(numberCheck(x, y, size)) {

			if(map[x][y] == -1) result[0]++;
			else if(map[x][y] == 0) result[1]++;
			else result[2]++;
			
			return;
		}
		
		// 모든 수가 같은 수가 아니라면 같은 크기의 종이 9개로 자른다.
		size = size/3;
		
		Divide(x, y, size);
		Divide(x, y+size, size);
		Divide(x, y+size*2, size);
		
		Divide(x+size, y, size);
		Divide(x+size, y+size, size);
		Divide(x+size, y+size*2, size);
		
		Divide(x+size*2, y, size);
		Divide(x+size*2, y+size, size);
		Divide(x+size*2, y+size*2, size);
	}
	
	// 모든 수가 같은 수로 되어 있는지 확인해본다.
	public static boolean numberCheck(int x, int y, int size) {
		int num = map[x][y];
		
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if(num != map[i][j]) return false;
			}
		}

		return true;
	}

}
