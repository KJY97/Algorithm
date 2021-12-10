package CodeUp;

import java.util.Scanner;

public class 기초100제_1080 {

	public static void main(String[] args) {
		// [기초-종합] 언제까지 더해야 할까?
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum = 0, i = 0;
		
		while(sum < num) {
			i++;
			sum = sum + i;
		}
		System.out.println(i);
	}

}
