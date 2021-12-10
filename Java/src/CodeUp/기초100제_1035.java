package CodeUp;

import java.util.Scanner;

public class 기초100제_1035 {

	public static void main(String[] args) {
		// [기초-출력변환] 16진 정수 1개 입력받아 8진수로 출력하기
		Scanner sc = new Scanner(System.in);
		String h = sc.nextLine();
		
		// 16진수 -> 10진수
		int num = Integer.parseInt(h, 16); 
		
		// 10진수 -> 8진수
		String o = Integer.toString(num, 8); 
		
		System.out.println(o);
	}

}
