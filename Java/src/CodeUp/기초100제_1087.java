package CodeUp;

import java.util.Scanner;

public class 기초100제_1087 {

	public static void main(String[] args) {
		// [기초-종합] 여기까지! 이제 그만~
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		
		for (int i = 1; ; i++) {
			sum += i;
			if (sum >= n) break;
		}
		
		System.out.println(sum);
	}

}
