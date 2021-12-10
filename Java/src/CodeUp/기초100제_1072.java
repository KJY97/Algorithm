package CodeUp;

import java.util.Scanner;

public class 기초100제_1072 {

	public static void main(String[] args) {
		// [기초-반복실행구조] 정수 입력받아 계속 출력하기
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println(sc.nextInt());
		}
	}

}
