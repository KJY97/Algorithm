package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182 {

	/**
	 * 문제
	 *  N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하라.
	 *   - 정수의 개수를 나타내는 N과 정수 S (1 ≤ N ≤ 20, |S| ≤ 1,000,000)
	 *   - 주어지는 정수의 절댓값은 100,000을 넘지 않는다.
	 *   - 제한 시간 2초
	 *   
	 * => 투포인터로 해결할 수 없다. 왜냐하면 연속된 수가 아닌 경우도 부분 수열이 되기 때문
	 * => 수열의 크기(즉 원소의 개수)가 양수이어야 하기 때문에 S=0인 경우, 공집합은 체크하지 않는다.
	 * 
	 * 시간: 84 ms
	 * 메모리: 11500 kb
	 */
	
	private static int N, S, ans;
	private static int[] num;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정수의 개수
		S = Integer.parseInt(st.nextToken()); 
		
		num = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		ans = 0;
		
		func(0, 0);
		if (S == 0) ans--; // 공집합인 경우 제외
		
		System.out.println(ans);
	}
	
	// 각 수를 더할지 말지 고려한다.
	// sum : 합, idx : 현재 원소의 위치
	public static void func(int sum, int idx) {
		
		if (idx == N) {
			if (sum == S) ans++;
			return ;
		}
		
		func(sum, idx+1); // idx 위치의 수를 더하지 않는다.
		func(sum+num[idx], idx+1); // idx 위치의 수를 더한다.
	}

}
