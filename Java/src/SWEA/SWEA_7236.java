package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_7236 {

	/**
	 * 문제
	 *  NxN 구획으로 이루어진 지역에 있는 저수지의 물(W)의 총 깊이를 구하려 한다.  
	 *  각 구획의 물(W)의 깊이는 구획을 애워싼 영역에 땅(G)이 있으면 땅을 뺀 합이 그 구획의 물 깊이다.  
	 *  하지만 둘러싼 모든 영역이 땅(G)인 경우  그 구획의 물 깊이는 1이된다. 
	 *  NxN 구획으로 이루어진 지역에 있는 저수지의 물(W)의 총 깊이는 각 구획의 물 깊이 중  
	 *  가장 깊은 구획의 깊이가 저수지에서 가장 깊은 물의 깊이로 저수지의 총 깊이가 된다.
	 *   - 저수지 구획의 크기(N)은 9<= N <= 100
	 * 
	 * 시간: 109 ms
	 * 메모리: 17,424 kb
	 */
	static int[][] map;
    static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			//물의 총 깊이 = 주변 W 개수
			//단, 주변이 모두 G이면 깊이는 1
			//가장 깊은 저수지의 총 깊이는??
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String[] tmp = br.readLine().split(" ");
				
				for (int j = 0; j < N; j++) {
					if(tmp[j].equals("W"))	//W은 1로 바꿔서 저장
						map[i][j] = 1;
					else 
						map[i][j] = 0;
				}
			}
			
			//가운데 구역 중심으로 주변 W의 개수 세기
			//모두 0이면 1 출력
			int ans = 0;	//최대 깊이
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					ans = Math.max(ans, Sum(i-1, j-1));
				}
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}
	
	public static int Sum(int x, int y) {
		int sum = 0;
		for (int i = x; i < x+3; i++) {
			for (int j = y; j < y+3; j++) {
                if(i >= 0 && i < N && j >= 0 && j < N)
					sum += map[i][j];
			}
		}
		if(sum == 1) return sum;	//주변이 모두 G(=0)인 경우
		return sum-1;	//중앙 구역 빼기
	}

}
