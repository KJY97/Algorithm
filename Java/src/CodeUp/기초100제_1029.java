package CodeUp;

import java.util.Scanner;

public class 기초100제_1029 {

	public static void main(String[] args) {
		// [기초-데이터형] 실수 1개 입력받아 그대로 출력하기2
		Scanner sc = new Scanner(System.in);
		double d = sc.nextDouble();
		// 소수점 아래 11자리로 출력
		System.out.printf("%.11f", d);
	}

}
