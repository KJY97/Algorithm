package CodeUp;

import java.util.Scanner;

public class 기초100제_1079 {

	public static void main(String[] args) {
		// [기초-종합] 원하는 문자가 입력될 때까지 반복 출력하기
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			char ch = sc.next().charAt(0);
			System.out.println(ch);
			
			if(ch == 'q') break;
		}
	}

}
