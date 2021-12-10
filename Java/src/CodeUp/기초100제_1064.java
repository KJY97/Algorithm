package CodeUp;

import java.util.Scanner;

public class 기초100제_1064 {

	public static void main(String[] args) {
		// [기초-삼항연산] 정수 3개 입력받아 가장 작은 수 출력하기
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		System.out.println((num1 < num2 ? num1 : num2) < num3 ? (num1 < num2 ? num1 : num2) : num3);
	}

}
