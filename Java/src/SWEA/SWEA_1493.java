package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1493 {

	/**
	 * 문제
	 *  2차원 평면 제 1사분면 위의 격자점 (x,y)에 할당된 수는 #(x,y)로 나타내며, 대각선 순서로 점에 수를 붙인다.
	 *  반대로 수 p가 할당된 점을 &(p)로 나타낸다.
	 *  두 점에 대해서 덧셈을 정의한다. 점 (x,y) + 점 (z,w) = 점 (x+z, y+w)로 정의한다.
	 *  우리가 해야 할 일은 수와 수에 대한 새로운 연산 ★를 구현하는 것으로, p★q는 #(&(p)+&(q))으로 나타난다.
	 *   - 격자점에 할당된 수 표현 : #(1,1) = 1, #(2,1)=3, #(2,2) = 5, #(4,4) = 25
	 *   - 할당된 점의 격자점 표현 : &(1) = (1,1), &(3) = (2,1), &(5) = (2,2), &(25) = (4,4)
	 *   - 새로운 연산 : &(1)=(1,1), &(5) = (2,2)이므로, 1★5 = #(&(1)+&(5)) = #((1,1)+(2,2)) = #(3,3) = 13
	 *   - 두 정수 p,q(1 ≤ p, q ≤ 10,000)
	 *   
	 * 시간: 216 ms
	 * 메모리: 21,088 kb
	 */
	public static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			// p★q = #(&(p)+&(q)) 계산
			Point p_XY = findXY(p);
			Point q_XY = findXY(q);
			
			// 계산 결과
			int ans = findValue(p_XY.x + q_XY.x, p_XY.y + q_XY.y);
			
			System.out.println("#" + test_case + " " + ans);
		}
	}
	
	// x, y 좌표 찾기
	public static Point findXY(int find) {
		int value = 1;
		
		for (int n = 1; ; n++) {
			for (int x = 1, y = n; x <= n; x++, y--) {
				if(value == find) return new Point(x, y);
				value++;
			}
		}
	}
	
	// 할당된 값 찾기
	public static int findValue(int X, int Y) {
		int value = 1;

		for (int n = 1; ; n++) {
			for (int x = 1, y = n; x <= n; x++, y--) {
				if(x == X && y == Y) return value;
				value++;
			}
		}
	}
}
