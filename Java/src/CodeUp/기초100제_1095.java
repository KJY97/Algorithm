package CodeUp;

import java.util.Scanner;

public class 기초100제_1095 {

	public static void main(String[] args) {
		// [기초-1차원배열] 이상한 출석 번호 부르기3
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int min = 23; //학생은 23번까지 존재하므로 가장 큰 수 저장.
		
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			min = min > num ? num : min;
		}
		System.out.println(min);
	}

}
