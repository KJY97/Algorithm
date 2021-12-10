package CodeUp;

import java.util.Scanner;

public class 기초100제_1023 {

	public static void main(String[] args) {
		// [기초-입출력] 실수 1개 입력받아 부분별로 출력하기
		Scanner sc = new Scanner(System.in);
		String[] num = sc.nextLine().split("\\.");
		
		System.out.println(num[0]);
		System.out.println(num[1]);
	}

}
