package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1057 {

	/**
	 * 문제
	 *  김지민은 N명이 참가하는 스타 토너먼트에 진출했다. 토너먼트는 다음과 같이 진행된다.
	 *  일단 N명의 참가자는 번호가 1번부터 N번까지 배정받는다. 그러고 난 후에 서로 인접한 번호끼리 스타를 한다.
	 *  이긴 사람은 다음 라운드에 진출하고, 진 사람은 그 라운드에서 떨어진다. 만약 그 라운드의 참가자가 홀수명이라면, 마지막 번호를 가진 참가자는 다음 라운드로 자동 진출한다.
	 *  다음 라운드에선 다시 참가자의 번호를 1번부터 매긴다. 이때, 번호를 매기는 순서는 처음 번호의 순서를 유지하면서 1번부터 매긴다.
	 *  이 말은 1번과 2번이 스타를 해서 1번이 진출하고, 3번과 4번이 스타를 해서 4번이 진출했다면, 4번은 다음 라운드에서 번호 2번을 배정받는다.
	 *  번호를 다시 배정받은 후에 한 명만 남을 때까지 라운드를 계속 한다.
	 *  침 이 스타 대회에 임한수도 참가했다. 김지민은 갑자기 스타 대회에서 우승하는 욕심은 없어지고, 몇 라운드에서 임한수와 대결하는지 궁금해졌다.
	 *  일단 김지민과 임한수는 서로 대결하기 전까지 항상 이긴다고 가정한다.
	 *  1 라운드에서 김지민의 번호와 임한수의 번호가 주어질 때, 과연 김지민과 임한수가 몇 라운드에서 대결하는지 출력하는 프로그램을 작성하시오.
	 *  첫째 줄에 김지민과 임한수가 대결하는 라운드 번호를 출력한다. 만약 서로 대결하지 않을 때는 -1을 출력한다.
	 *   - 참가자의 수 N (2 <= N <= 100,000)
	 *   - 김지민의 번호와 임한수의 번호는 N보다 작거나 같은 자연수이고, 서로 다르다.
	 *   - 제한 시간 1초
	 * 
	 * => 토너먼트의 규칙을 파악한다!
	 * 
	 * 시간: 76 ms
	 * 메모리: 11516 kb
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 참가자 수
		int jiMin = Integer.parseInt(st.nextToken()); // 김지민 번호
		int hanSu = Integer.parseInt(st.nextToken()); // 임한수 번호
		
		int round = 0;
		while(jiMin != hanSu) {
			jiMin = jiMin/2 + jiMin%2;
			hanSu = hanSu/2 + hanSu%2;
			round++;
		}
		
		System.out.println(round);
	}

}
