package CodeUp;

import java.util.Scanner;

public class 기초100제_1092 {

	public static void main(String[] args) {
		// [기초-종합] 함께 문제 푸는 날
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int day = 1;
		while(day % a != 0 || day % b != 0 || day % c != 0) day++;
		System.out.println(day);
	}

}
