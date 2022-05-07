package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1107 {

	/**
	 * 문제
	 *  수빈이는 TV를 보고 있다. 수빈이는 채널을 돌리려고 했지만, 버튼을 너무 세게 누르는 바람에, 일부 숫자 버튼이 고장났다.
	 *  리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다. +를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고, -를 누르면 -1된 채널로 이동한다. 
	 *  채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다. 수빈이가 지금 이동하려고 하는 채널은 N이다. 
	 *  어떤 버튼이 고장났는지 주어졌을 때, 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오. 
	 *  수빈이가 지금 보고 있는 채널은 100번이다.
	 *   - 수빈이가 이동하려고 하는 채널 N (0 ≤ N ≤ 500,000)
	 *   - 고장난 버튼의 개수 M (0 ≤ M ≤ 10)
	 *   - 시간제한 2초
	 * 
	 * => 브루트포스(완전탐색)
	 *   => 500,000번 채널까지 존재하므로 리모컨 버튼으로 999_999까지 누를 수 있다.
	 *   
	 * 시간 : 300 ms
	 * 메모리 : 69140 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine()); // 이동하려는 채널
		int M = Integer.parseInt(br.readLine()); // 고장난 버튼 수
		
		boolean[] brokenNumber = new boolean[10];
		
		// 고장난 버튼 입력 받기
		if (M != 0) 
			st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			brokenNumber[Integer.parseInt(st.nextToken())] = true;
		}
		
		// 처음 시작 위치가 100번이므로 절대값을 이용해서 이동 횟수를 저장한다. (초기값 설정)
		int ans = Math.abs(100 - N);
		
		// 500,000번 까지 채널이 존재하므로 버튼은 최대 999_999까지 누를 수 있다.
		for (int i = 0; i <= 999_999; i++) {
			String str = Integer.toString(i);
			int length = str.length(); // N의 길이 = 채널 N으로 이동하기 위해 반드시 눌러야 하는 수
			
			// 고장난 버튼을 누르는 채널인지 체크한다.
			boolean isBroken = false;
			for (int j = 0; j < length; j++) {
				if (brokenNumber[str.charAt(j) - '0']) { // 고장난 버튼을 누른다면
					isBroken = true;
					break; // 더 이상 탐색하지 않는다.
				}
			}
			
			// 채널 str이 고장난 버튼을 누른다면 다음 채널을 탐색한다.
			if(isBroken) continue;
			
			// 찾은 채널과 N의 차이 구하기. 두 채널의 차가 중요하기 때문에 절대값을 씌운다
			int cnt = length + Math.abs(N - i);
			
			// 100에서 +,-로 탐색한 수 와 채널을 누른 후 +,-로 탐색한 수 비
			ans = Math.min(ans, cnt);
		}
		
		System.out.println(ans);
	}
}
