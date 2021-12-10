package CodeUp;

import java.util.Scanner;

public class 기초100제_1024 {

	public static void main(String[] args) {
		// [기초-입출력] 단어 1개 입력받아 나누어 출력하기
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		for (int i = 0; i < str.length(); i++) {
			System.out.println("'" + str.charAt(i) + "'");
		}
	}

}
