package CodeUp;

import java.util.Scanner;

public class 기초100제_1036 {

	public static void main(String[] args) {
		// [기초-출력변환] 영문자 1개 입력받아 10진수로 출력하기
		Scanner sc = new Scanner(System.in);
		int strToNum = (int)sc.next().charAt(0);
		System.out.println(strToNum);
	}

}
