package CodeUp;

import java.util.Scanner;

public class 기초100제_1025 {

	public static void main(String[] args) {
		// [기초-입출력] 정수 1개 입력받아 나누어 출력하기
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int x = 10000;
		
		while(num != 0) {
			System.out.println("[" + num/x * x + "]");
			num = num % x;
			x = x / 10;
		}
	}
}
