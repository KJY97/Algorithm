package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1547 {

	/**
	 * 문제
	 *  세준이는 컵 3개를 탁자 위에 일렬로 엎어놓았다. 컵의 번호는 맨 왼쪽 컵부터 순서대로 1번, 2번 3번이고, 세준이는 이 컵을 이용해서 게임을 하려고 한다.
	 *  먼저 1번 컵의 아래에 공을 하나 넣는다. 세준이는 두 컵을 고른 다음, 그 위치를 맞바꾸려고 한다.
	 *  예를 들어, 고른 컵이 1번과 2번이라면, 1번 컵이 있던 위치에 2번 컵을 이동시키고, 동시에 2번 컵이 있던 위치에 1번 컵을 이동시켜야 한다.
	 *  이때 공은 움직이지 않기 때문에, 공의 위치는 맨 처음 1번 컵이 있던 위치와 같다.
	 *  세준이는 컵의 위치를 총 M번 바꿀 것이며, 컵의 위치를 바꾼 방법이 입력으로 주어진다. 위치를 M번 바꾼 이후에 공이 들어있는 컵의 번호를 구하는 프로그램을 작성하시오.
	 *  첫째 줄에 공이 들어있는 컵의 번호를 출력한다. 공이 사라져서 컵 밑에 없는 경우에는 -1을 출력한다.
	 *   - 컵의 위치를 바꾼 횟수 M (0 < M <= 50)
	 *   - X번 컵과 Y번 컵의 위치를 서로 바꾸는 것을 의미한다. X와 Y의 값은 3보다 작거나 같고, X와 Y가 같을 수도 있다.
	 *   - 컵을 이동시킨 후에 공이 컵 바깥에 있는 경우는 없다.
	 *   - 제한 시간 2초
	 *   
	 * 시간: 76 ms
	 * 메모리: 11568 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		boolean[] cups = new boolean[4]; // 1번부터 사용
		cups[1] = true; // 1번 컵 아래 공 넣기
		
		int M = Integer.parseInt(br.readLine()); // 컵의 위치를 바꾼 횟수
		
		// X번 컵과 Y번 컵의 위치를 서로 바꾼다.
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			swap(cups, X, Y);
		}
		
		// 공이 들어있는 컵의 번호 출력
		for (int i = 1; i <= 3; i++) {
			if (cups[i]) System.out.println(i);
		}
	}
	
	public static void swap(boolean[] cups, int X, int Y) {
		boolean tmp = cups[X];
		cups[X] = cups[Y];
		cups[Y] = tmp;
	}
	
}
