package CodeUp;

import java.util.Scanner;

public class 기초100제_1014 {

	public static void main(String[] args) {
		// [기초-입출력] 문자 2개 입력받아 순서 바꿔 출력하기
		Scanner sc = new Scanner(System.in);
		char x = sc.next().charAt(0);
		char y = sc.next().charAt(0);
		
		System.out.println(y + " " + x);
	}

}
