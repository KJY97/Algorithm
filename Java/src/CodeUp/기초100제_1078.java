package CodeUp;

import java.util.Scanner;

public class 기초100제_1078 {

	public static void main(String[] args) {
		// [기초-종합] 짝수 합 구하기
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum = 0;
		
		for (int i = 1; i <= num; i++) {
			if(i % 2 == 0) 
				sum += i;
		}
		System.out.println(sum);
	}

}
