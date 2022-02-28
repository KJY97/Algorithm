package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215 {

	/**
	 * 문제
	 *  민기는 햄버거의 맛은 최대한 유지하면서 정해진 칼로리를 넘지 않는 햄버거를 주문하여 먹으려고 한다.
	 *  민기가 주로 이용하는 햄버거 가게에서는 고객이 원하는 조합으로 햄버거를 만들어서 준다.
	 *  하지만 재료는 미리 만들어서 준비해놓기 때문에 조합에 들어가는 재료를 잘라서 조합해주지는 않고, 
	 *  재료를 선택하면 준비해놓은 재료를 그대로 사용하여 조합해준다. 
	 *  민기는 이 가게에서 자신이 먹었던 햄버거의 재료에 대한 맛을 자신의 오랜 경험을 통해 점수를 매겨놓았다.
	 *  민기의 햄버거 재료에 대한 점수와 가게에서 제공하는 재료에 대한 칼로리가 주어졌을 때,
	 *  정해진 칼로리 이하의 조합 중에서 민기가 가장 선호하는 햄버거를 조합해주는 프로그램을 만들어보자.
	 *   - 단, 여러 재료를 조합하였을 햄버거의 선호도는 조합된 재료들의 맛에 대한 점수의 합으로 결정
	 *   - 같은 재료를 여러 번 사용할 수 없으며, 햄버거의 조합의 제한은 칼로리를 제외하고는 없다.
	 *   - 재료의 수, 제한 칼로리 N, L(1 ≤ N ≤ 20, 1 ≤ L ≤ 10⁴)
	 *   - 맛에 대한 점수와 칼로리 Ti, Ki(1 ≤ Ti ≤ 10³, 1 ≤ Ki ≤ 10³)
	 * 
	 * => 단순히 칼로리 이하 조합 중 선호도가 높은 것이 아닌 재료가 가장 많이 쓰이면서 선호도가 높은 것을 찾는 것이다.
	 * => 조합 X, 부분조합 사용!
	 * 
	 * 시간: 166 ms
	 * 메모리: 20,072 kb
	 */
	
	private static int N, L, max;
	private static int taste[], calorie[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료의 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리
			
			// 각 재료에 대한 맛에 대한 점수와 칼로리 초기화
			taste = new int[N];
			calorie = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				taste[i] = Integer.parseInt(st.nextToken());
				calorie[i] = Integer.parseInt(st.nextToken());
			}
			
			max = 0; // 햄버거의 맛은 최대한 유지하면서 칼로리는 넘지 않는 가장 큰 맛의 점수
			
			// 구해진 조합의 맛의 합과 칼로리 합 구하면서 재귀 타기
			Subset(0, 0, 0);
			
			System.out.println("#" + test_case + " " + max);
		}
		
	}
	
	// 부분집합으로 재귀를 반복하면서 조합의 맛의 합과 칼로리 합 구하기
	public static void Subset(int idx, int t_sum, int c_sum) {
		
		if(idx == N) {
			// 칼로리 넘지 않고 선호도가 가장 높은 경우
			if(c_sum < L && t_sum > max) max = t_sum;
			return ;
		}
			
		Subset(idx+1, t_sum + taste[idx], c_sum + calorie[idx]);
		Subset(idx+1, t_sum, c_sum);
	}
	
}
