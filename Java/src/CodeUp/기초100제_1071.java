package CodeUp;

import java.util.Scanner;

public class 기초100제_1071 {

	public static void main(String[] args) {
		// [기초-반복실행구조] 0 입력될 때까지 무한 출력하기1
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int num = sc.nextInt();
			
			if(num == 0) break;
			
			System.out.println(num);
		}
	}

}
