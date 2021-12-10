package CodeUp;

import java.util.Scanner;

public class 기초100제_1041 {

	public static void main(String[] args) {
		// [기초-산술연산] 문자 1개 입력받아 다음 문자 출력하기
		Scanner sc = new Scanner(System.in);
		char ch = sc.next().charAt(0);
		System.out.println(++ch);
	}

}
