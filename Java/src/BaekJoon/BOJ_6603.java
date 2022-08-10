package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603 {

	/**
	 * 문제
	 *  독일 로또는 {1, 2, ..., 49}에서 수 6개를 고른다.
	 *  로또 번호를 선택하는데 사용되는 가장 유명한 전략은 49가지 수 중 k(k>6)개의 수를 골라 집합 S를 만든 다음 그 수만 가지고 번호를 선택하는 것이다.
	 *  예를 들어, k=8, S={1,2,3,5,8,13,21,34}인 경우 이 집합 S에서 수를 고를 수 있는 경우의 수는 총 28가지이다. 
	 *  ([1,2,3,5,8,13], [1,2,3,5,8,21], [1,2,3,5,8,34], [1,2,3,5,13,21], ..., [3,5,8,13,21,34])
	 *  집합 S와 k가 주어졌을 때, 수를 고르는 모든 방법을 구하는 프로그램을 작성하시오.
	 *  각 테스트 케이스마다 수를 고르는 모든 방법을 출력한다. 이때, 사전 순으로 출력한다.
	 *   - k (6 < k < 13)
	 *   - k개 수는 집합 S에 포함되는 수이다
	 *   - S의 원소는 오름차순으로 주어진다.
	 *   - 입력의 마지막 줄에는 0이 하나 주어진다. 
	 * 
	 * => 순열 활용
	 * 
	 * 시간: 248 ms
	 * 메모리: 14604 kb
	 */
	
	private static int k;
	private static int S[], num[];
	private static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			k = Integer.parseInt(st.nextToken()); 
			
			// 입력으로 0 들어오면 stop
			if (k == 0) break;
			
			S = new int[k]; // 집합 S
			num = new int[7]; // 집합 S로 만들 수 있는 6개의 수를 저장하는 배열 (1부터 사용)
			visited = new boolean[k]; // 해당 숫자를 접근했는지 체크하는 배열
			
			// 오름차순으로 입력됨
			for (int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			
			// 경우의 수 구하기  - 순열 활용
			permutation(1);
			System.out.println();
		}
		
	}
	
	// 순열 이용
	public static void permutation(int idx) {

		if (idx == 7) {

			// 경우의 수 출력
			for (int i = 1; i <= 6; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
			
			return;
		}
		
		for (int i = 0; i < k; i++) {
			// 이미 저장한 수 or num 저장 시 사전 순이 아닌 경우 skip
			if (visited[i] || num[idx-1] > S[i]) continue;
			
			visited[i] = true;
			num[idx] = S[i];
			
			permutation(idx+1);
			
			visited[i] = false;
			num[idx] = 0;
		}
	}

}
