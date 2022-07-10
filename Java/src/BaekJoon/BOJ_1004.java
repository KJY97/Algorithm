package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1004 {

	/**
	 * 문제
	 *  어린 왕자는 소혹성 B-664에서 자신이 사랑하는 한 송이 장미를 위해 살아간다. 
	 *  어느 날 장미가 위험에 빠지게 된 것을 알게 된 어린 왕자는, 장미를 구하기 위해 은하수를 따라 긴 여행을 하기 시작했다.
	 *  하지만 어린 왕자의 우주선은 그렇게 좋지 않아서 행성계 간의 이동을 최대한 피해서 여행해야 한다.
	 *  아래의 그림은 어린 왕자가 펼쳐본 은하수 지도의 일부이다.
	 *   .. 그림 생략 ..
	 *  빨간 실선은 어린 왕자가 출발점에서 도착점까지 도달하는데 있어서 필요한 행성계 진입/이탈 횟수를 최소화하는 경로이며, 원은 행성계의 경계를 의미한다.
	 *  이러한 경로는 여러 개 존재할 수 있지만 적어도 3번의 행성계 진입/이탈이 필요하다는 것을 알 수 있다.
	 *  위와 같은 은하수 지도, 출발점, 도착점이 주어졌을 때 어린 왕자에게 필요한 최소의 행성계 진입/이탈 횟수를 구하는 프로그램을 작성해 보자.
	 *  행성계의 경계가 맞닿거나 서로 교차하는 경우는 없다. 또한, 출발점이나 도착점이 행성계 경계에 걸쳐진 경우 역시 입력으로 주어지지 않는다.
	 *  각 테스트 케이스에 대해 어린 왕자가 거쳐야 할 최소의 행성계 진입/이탈 횟수를 출력한다.
	 *  - 테스트 케이스의 개수 T
	 *  - 출발점 (x1, y1)과 도착점 (x2, y2)의 범위 : -1000 ≤ x1, y1, x2, y2, cx, cy ≤ 1000
	 *  - 성계의 개수 n (1 ≤ n ≤ 50)
	 *  - 행성계의 중점과 반지름 (cx, cy, r)의 범위 : 1 ≤ r ≤ 1000
	 *  - 좌표와 반지름은 모두 정수
	 * 
	 * => 기하학을 이용한 문제
	 * => 원의 경계가 맞닿거나 교차하는 경우가 없기 때문에 출발점과 도착점이 둘 다 원 안에 있거나 / 둘 다 원 밖에 있거나 / 둘 중 하나만 원 안에 있는 경우 를 체크한다
	 * => 두 점사이의 거리를 구하는 공식을 이용하기
	 * 
	 * 시간: 120 ms
	 * 메모리: 13224 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 0; test_case < T; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			// 출발점 좌표
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			
			// 도착점 좌표
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int N = Integer.parseInt(br.readLine()); // 성계의 개수
			int ans = 0; // 어린 왕자가 거쳐야 할 최소의 행성계 진입/이탈 횟수
			
			// 행성계 중점과 반지름 입력받으면서 해당 좌표가 원 안에 포함되는지 계산
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int cx = Integer.parseInt(st.nextToken());
				int cy = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());

				boolean start = isContain(x1, cx, y1, cy, r); // 출발점이 원 안에 포함되는가?
				boolean end = isContain(x2, cx, y2, cy, r); // 도착점이 원 안에 포함되는가?
				
				// 하나의 원 안에 출발/도착점이 모두 포함되면 원 안에 머무르고 있다는 것으로 이탈 혹은 진입이 발생하지 않았다는 의미가 된다.
				// 그러므로 제외한다.
				if (start && end) continue;
				
				// 원 밖에 있는 경우 제외
				if (!start && !end) continue;
				
				// 출발/도착점 중 하나만 원 밖에 있는 경우
				if ((start && !end) || (!start && end)) ans++;
			}
			
			System.out.println(ans);
		}
	}
	
	// 원의 원점 좌표 (x0, y0), 좌표 (x, y), 반지름 r
	// 한 원이 좌표 (x, y)를 포함하고 있는가? (두 점 사이의 거리공식 이용)
	public static boolean isContain(int x0, int x, int y0, int y, int r) {
		return Math.sqrt(Math.pow(x0 - x, 2) + Math.pow(y0 - y, 2)) < r;
	}

}
