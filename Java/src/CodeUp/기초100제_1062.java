package CodeUp;

import java.util.Scanner;

public class 기초100제_1062 {

	public static void main(String[] args) {
		// [기초-비트단위논리연산] 비트단위로 XOR 하여 출력하기
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		// XOR
		System.out.println(num1 ^ num2);
	}

}
