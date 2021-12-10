package CodeUp;

import java.util.Scanner;

public class 기초100제_1031 {

	public static void main(String[] args) {
		// [기초-출력변환] 10진 정수 1개 입력받아 8진수로 출력하기
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.printf("%o", num);
	}

}
