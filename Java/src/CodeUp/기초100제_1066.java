package CodeUp;

import java.util.Scanner;

public class 기초100제_1066 {

	public static void main(String[] args) {
		// [기초-조건/선택실행구조] 정수 3개 입력받아 짝/홀 출력하기
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		if (num1 % 2 == 0) System.out.println("even");
		else System.out.println("odd");
		
		if (num2 % 2 == 0) System.out.println("even");
		else System.out.println("odd");
		
		if (num3 % 2 == 0) System.out.println("even");
		else System.out.println("odd");
	}

}
