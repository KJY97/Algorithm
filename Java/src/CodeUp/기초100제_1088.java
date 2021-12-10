package CodeUp;

import java.util.Scanner;

public class 기초100제_1088 {

	public static void main(String[] args) {
		// [기초-종합] 3의 배수는 통과?
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for (int i = 1; i <= num; i++) {
			if(i % 3 == 0) continue;
			System.out.println(i);
		}
	}

}
