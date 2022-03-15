package Programmers;

import java.util.Arrays;

public class PG_카펫 {

	/**
	 * 문제
	 * Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤다.
	 * Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했다.
	 * Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때
	 * 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
	 *  - 갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수
	 *  - 노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수
	 *  - 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 길다.
	 */
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(10, 2)));
		System.out.println(Arrays.toString(solution(8, 1)));
		System.out.println(Arrays.toString(solution(24, 24)));
	}
	
	public static int[] solution(int brown, int yellow) {
		// 격자 모양의 카펫이므로 반드시 중앙에 yellow가 있어야 한다.
		// 중앙에 yellow가 있는 최소의 경우는 3x3 형태의 배열(brown=8, yellow=1)
		
		// 가로,세로의 최소 크기는 3이므로 최소 크기로 나눈 값까지 완탐하기
		int size = (brown+yellow)/3; 
		
		for (int i = 3; i <= size; i++) {
			for (int j = 3; j <= size; j++) {
				int tmp = (i - 2) * (j - 2); // ixj 배열일 경우 중앙에 몇 개의 yellow가 있는지 체크
				if(tmp == yellow && (i*j - tmp) == brown) {
					return new int[] {j, i}; // 가로 길이가 세로보다 크거나 같다
				}
			}
		}
        return null;
    }

}
