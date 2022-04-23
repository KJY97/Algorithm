package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6064 {

	/**
	 * 문제
	 *  최근에 ICPC 탐사대는 남아메리카의 잉카 제국이 놀라운 문명을 지닌 카잉 제국을 토대로 하여 세워졌다는 사실을 발견했다. 
	 *  카잉 제국의 백성들은 특이한 달력을 사용한 것으로 알려져 있다. 
	 *  그들은 M과 N보다 작거나 같은 두 개의 자연수 x, y를 가지고 각 년도를 <x:y>와 같은 형식으로 표현하였다. 
	 *  그들은 이 세상의 시초에 해당하는 첫 번째 해를 <1:1>로 표현하고, 두 번째 해를 <2:2>로 표현하였다. 
	 *  <x:y>의 다음 해를 표현한 것을 <x':y'>이라고 하자. 만일 x < M 이면 x' = x + 1이고, 그렇지 않으면 x' = 1이다. 
	 *  같은 방식으로 만일 y < N이면 y' = y + 1이고, 그렇지 않으면 y' = 1이다. 
	 *  <M:N>은 그들 달력의 마지막 해로서, 이 해에 세상의 종말이 도래한다는 예언이 전해 온다. 
	 *  예를 들어, M = 10 이고 N = 12라고 하자. 첫 번째 해는 <1:1>로 표현되고, 11번째 해는 <1:11>로 표현된다. 
	 *  <3:1>은 13번째 해를 나타내고, <10:12>는 마지막인 60번째 해를 나타낸다. 
	 *  네 개의 정수 M, N, x와 y가 주어질 때, <M:N>이 카잉 달력의 마지막 해라고 하면 <x:y>는 몇 번째 해를 나타내는지 구하는 프로그램을 작성한다.
	 *  만일 <x:y>에 의해 표현되는 해가 없다면, 즉, <x:y>가 유효하지 않은 표현이면, -1을 출력한다.
	 *   - 1 ≤ M, N ≤ 40,000
	 *   - 1 ≤ x ≤ M, 1 ≤ y ≤ N
	 *   - <M:N>은 카잉 달력의 마지막 해
	 *   - 제한 시간 1초
	 *   
	 * => 완탐으로 할 경우 시간 초과 발생(4만 * 4만 = 16억)
	 * 
	 * 시간 : 356 ms
	 * 메모리 : 21312 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 0; test_case < T; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			// 카잉 달력의 마지막 해
			int M = Integer.parseInt(st.nextToken()); 
			int N = Integer.parseInt(st.nextToken());
			
			// 구해햐 하는 해
			int x = Integer.parseInt(st.nextToken()); 
			int y = Integer.parseInt(st.nextToken());
			
			// <M:N>가 되는 해는 M과 N의 최소공배수가 되는 해
			// 최소공배수를 구하기 위해서는 우선 최대공약수를 구해야 한다.(유클리드 호제법)
			int gcd = gcd(Math.max(M, N), Math.min(M, N));
			int lcm = M * N / gcd;
			
			// x와 y는 각각 M와 N주기로 돌아온다.
			// 즉, x = answer % M, y = answer % N
			// 겹치는 answer 구하기!
			
			int answer = -1; // <x:y>가 유효하지 않은 표현이면 -1
			for (int i = x; i <= lcm; i+=M) { // x 먼저 고려
				// y와 일치하는 경우 찾기
				int tmp = i % N; 
				
				// 주의!! 만약 y == N이라면??? -> i % N의 값은 0이 된다.
				// y == N인 경우와 구분하기 위해 아닌 경우 y != N 도 체크 
				if((y == N && tmp == 0) || (y != N && tmp == y)) {
					answer = i;
					break;
				}
			}
			
			System.out.println(answer);
		}

	}
	
	// 최대공약수 구하기 (x>y)
	public static int gcd(int x, int y) {
		if(x % y == 0) return y;
		return gcd(y, x % y);
	}

}
