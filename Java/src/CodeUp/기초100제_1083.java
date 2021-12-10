package CodeUp;

import java.util.Scanner;

public class 기초100제_1083 {

	public static void main(String[] args) {
		// [기초-종합] 3 6 9 게임의 왕이 되자!
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for (int i = 1; i <= num; i++) {
			if (i % 3 == 0)
				System.out.println("X");
            else
                System.out.println(i);
		}
	}

}
