package CodeUp;

import java.util.Scanner;

public class 기초100제_1033 {

	public static void main(String[] args) {
		// [기초-출력변환] 10진 정수 입력받아 16진수 대문자로 출력하기2
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.printf("%X", num);
	}

}
