package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1072 {

	/**
	 * 문제
	 *  김형택은 지금 몰래 Spider Solitaire(스파이더 카드놀이)를 하고 있다. 형택이는 이 게임을 이길 때도 있었지만, 질 때도 있었다.
	 *  누군가의 시선이 느껴진 형택이는 게임을 중단하고 코딩을 하기 시작했다. 의심을 피했다고 생각한 형택이는 다시 게임을 켰다.
	 *  그 때 형택이는 잠시 코딩을 하는 사이에 자신의 게임 실력이 눈에 띄게 향상된 것을 알았다. 이제 형택이는 앞으로의 모든 게임에서 지지 않는다.
	 *  하지만, 형택이는 게임 기록을 삭제 할 수 없기 때문에, 자신의 못하던 예전 기록이 현재 자신의 엄청난 실력을 증명하지 못한다고 생각했다.
	 *  게임 기록은 다음과 같이 생겼다.
	 *    - 게임 횟수 : X
	 *    - 이긴 게임 : Y (Z%)
	 *    - Z는 형택이의 승률이고, 소수점은 버린다. 예를 들어, X=53, Y=47이라면, Z=88이다.
	 *  X와 Y가 주어졌을 때, 형택이가 게임을 최소 몇 번 더 해야 Z가 변하는지 구한다. 만약 Z가 절대 변하지 않는다면 -1을 출력한다.
	 *   - 1 ≤ X ≤ 1,000,000,000
	 *   - 0 ≤ Y ≤ X
	 * 
	 * => Y/X*100와 Y*100/X는 서로 답이 다르게 나온다.. why?
	 * => 99%의 승률에서 몇번을 이겨도 100이 될 수 없다!
	 * 
	 * 시간: 4480 ms
	 * 메모리: 11608 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		double X = Double.parseDouble(st.nextToken()); // 게임 횟수
		double Y = Double.parseDouble(st.nextToken()); // 이긴 게임 횟수
		
		int winRate = (int) (Y*100/X); // 승률
		
		int answer = 0; // 형택이가 게임을 더 해야 하는 횟수
		
		if (winRate >= 99) { 
			// 승률이 절대 변하지 않는 경우
			// 99%는 절대 100이 될 수 없다.
			answer = -1;
		} else {
			// 승률이 변동되려면(즉, 올라가려면) 게임 횟수가 증가할 때 이긴 게임 수도 함께 증가해야 한다.
			int rate = (int) (Y*100/X); // 새로찾는 확률
			while(rate <= winRate) {
				X++;
				Y++;
				answer++;
				rate = (int) (Y*100/X);
			}
		}
		
		System.out.println(answer);
	}

}
