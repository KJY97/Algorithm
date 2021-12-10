package CodeUp;

import java.util.Scanner;

public class 기초100제_1074 {

	public static void main(String[] args) {
		// [기초-반복실행구조] 정수 1개 입력받아 카운트다운 출력하기1
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		while(num != 0) {
			System.out.println(num);
			num--;
		}
	}

}
