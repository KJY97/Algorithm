package CodeUp;

import java.util.Scanner;

public class 기초100제_1019 {

	public static void main(String[] args) {
		// [기초-입출력] 연월일 입력받아 그대로 출력하기
		Scanner sc = new Scanner(System.in);
		
		// . 으로만 하면 안 잘린다. \\. 사용해야 함.
		// \ ← 이것 하나도 예약어이기 때문에 2개 붙여야 함.
		String[] date = sc.nextLine().split("\\.");
		
		String year = String.format("%04d", Integer.parseInt(date[0]));
		String mon = String.format("%02d", Integer.parseInt(date[1]));
		String day = String.format("%02d", Integer.parseInt(date[2]));
		
		System.out.println(year + "." + mon + "." + day);
	}

}
