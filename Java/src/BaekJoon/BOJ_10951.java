package BaekJoon;

import java.util.Scanner;

public class BOJ_10951 {

	/**
	 * 문제
	 *  A+B 출력하기
	 *   - 테스트케이스 개수가 주어지지 않는다.
	 * => 더 이상 입력 데이터가 없으면 종료
	 *   
	 * 시간 : 136 ms
	 * 메모리 : 13092 kb
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			System.out.println(A+B);
		}

	}

}
