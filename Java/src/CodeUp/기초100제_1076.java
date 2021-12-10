package CodeUp;

import java.util.Scanner;

public class 기초100제_1076 {

	public static void main(String[] args) {
		// [기초-반복실행구조] 문자 1개 입력받아 알파벳 출력하기
		Scanner sc = new Scanner(System.in);
		char end = sc.next().charAt(0);
		char start = 'a';
		
		do {
			System.out.println(start++);
		} while(start <= end);
	}

}
