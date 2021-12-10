package CodeUp;

import java.util.Scanner;

public class 기초100제_1082 {

	public static void main(String[] args) {
		// [기초-종합] 16진수 구구단?
		Scanner sc = new Scanner(System.in);
		String hex = sc.nextLine();
		int num = Integer.parseInt(hex, 16);
		
		for (int i = 1; i < 16; i++) {
			System.out.printf("%X*%X=%X\n", num, i, num*i);
		}
	}

}
