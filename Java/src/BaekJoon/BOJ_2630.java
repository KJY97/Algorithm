package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {

	/**
	 * 문제
	 *  아래 <그림 1>과 같이 여러개의 정사각형칸들로 이루어진 정사각형 모양의 종이가 주어져 있고, 각 정사각형들은 하얀색으로 칠해져 있거나 파란색으로 칠해져 있다.
	 *  주어진 종이를 일정한 규칙에 따라 잘라서 다양한 크기를 가진 정사각형 모양의 하얀색 또는 파란색 색종이를 만들려고 한다.
	 *  전체 종이의 크기가 N×N이라면 종이를 자르는 규칙은 다음과 같다.
	 *  ===============================================================================================
	 *   전체 종이가 모두 같은 색으로 칠해져 있지 않으면 가로와 세로로 중간 부분을 잘라서 똑같은 크기의 네 개의 N/2 × N/2색종이로 나눈다.
	 *   나누어진 종이 각각에 대해서도 앞에서와 마찬가지로 모두 같은 색으로 칠해져 있지 않으면 같은 방법으로 똑같은 크기의 네 개의 색종이로 나눈다.
	 *   이와 같은 과정을 잘라진 종이가 모두 하얀색 또는 모두 파란색으로 칠해져 있거나, 하나의 정사각형 칸이 되어 더 이상 자를 수 없을 때까지 반복한다.
	 *  ===============================================================================================
	 *  입력으로 주어진 종이의 한 변의 길이 N과 각 정사각형칸의 색(하얀색 또는 파란색)이 주어질 때 잘라진 하얀색 색종이와 파란색 색종이의 개수를 구하라.
	 *   - 한 변의 길이 N = 2^k, k는 1 이상 7 이하의 자연수
	 *   - 하얀색 칸은 0, 파란색 칸은 1
	 * 
	 * => 분할 정복 사용
	 * 
	 * 시간 : 108 ms
	 * 메모리 : 13160 kb
	 */
	private static int N, white, blue;
	private static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 한 변의 길이
		
		// 종이 초기화
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 규칙에 따라 종이 자르기
		divide(0,0,N);
		
		System.out.println(white);
		System.out.println(blue);
	}
	
	private static void divide(int x, int y, int size) {
		// 잘라진 종이가 모두 한가지 색으로 이루어져 있다면..
		 if(isAllOneColor(x,y,size)) {
			 // 0은 하얀색, 1은 파란색
			 if(map[x][y] == 0) white++;
			 else blue++;
			 
			 return;
		 }
		 
		 int half = size / 2;
		 
		 divide(x, y, half);
		 divide(x + half, y, half);
		 divide(x, y + half, half);
		 divide(x + half, y + half, half);
	}
	
	// 주어진 범위가 모두 하나의 color로 이루어져 있는지 체크
	private static boolean isAllOneColor(int x, int y, int size) {
		int color = map[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if(color != map[i][j]) return false;
			}
		}
		return true;
	}

}
