package CodeUp;

import java.util.Scanner;

public class 기초100제_1094 {

	public static void main(String[] args) {
		// [기초-1차원배열] 이상한 출석 번호 부르기2
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String []call = sc.nextLine().split(" ");
		
		for (int i = n-1; i >= 0; i--) {
			System.out.print(call[i] + " ");
		}
	}

}
