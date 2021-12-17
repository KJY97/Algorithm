package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1085 {

	/**
	 * 문제
	 *  현재 위치 (x,y)에서 직사각형의 경계선까지 가는 거리의 최솟값을 구하기
	 *   - 직사각형은 각 변이 좌표축에 평행
	 *   - 왼쪽 아래 꼭짓점은 (0,0), 오른쪽 위 꼭짓점은 (w,h)에 있다.
	 *   - 1 ≤ w, h ≤ 1,000
	 *   - 1 ≤ x ≤ w-1, 1 ≤ y ≤ h-1
	 * => (x,y)에서 상하좌우 사이 거리 중 가장 짧은 값 구하는 문제 
	 *   
	 * 시간 : 76 ms
	 * 메모리 : 11532 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int minX = Math.min(x, w-x); // 좌우 거리 비교
		int minY = Math.min(y, h-y); // 상하 거리 비교
		
		System.out.println(Math.min(minX, minY));
	}

}
