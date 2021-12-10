package CodeUp;

import java.util.Scanner;

public class 기초100제_1032 {

	public static void main(String[] args) {
		// [기초-출력변환] 10진 정수 입력받아 16진수 소문자로 출력하기1
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.printf("%x", num);
	}

}
