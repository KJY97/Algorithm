package CodeUp;

import java.util.Scanner;

public class 기초100제_1063 {

	public static void main(String[] args) {
		// [기초-삼항연산] 두 정수 입력받아 큰 수 출력하기
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		System.out.println(num1 > num2 ? num1 : num2);
	}

}
