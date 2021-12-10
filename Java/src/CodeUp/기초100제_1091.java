package CodeUp;

import java.util.Scanner;

public class 기초100제_1091 {

	public static void main(String[] args) {
		// [기초-종합] 수 나열하기3
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int m = sc.nextInt();
		int d = sc.nextInt();
		int n = sc.nextInt() - 1;
		
		for (int i = 0; i < n; i++) {
			a = a * m + d;
		}
		System.out.println(a);
	}

}
