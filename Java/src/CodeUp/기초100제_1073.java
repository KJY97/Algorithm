package CodeUp;

import java.util.Scanner;

public class 기초100제_1073 {

	public static void main(String[] args) {
		// [기초-반복실행구조] 0 입력될 때까지 무한 출력하기2
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		while(num != 0) {
			System.out.println(num);
			num = sc.nextInt();
		}
	}

}
