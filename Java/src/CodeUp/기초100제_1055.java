package CodeUp;

import java.util.Scanner;

public class 기초100제_1055 {
	
	public static void main(String[] args) {
		// [기초-논리연산] 하나라도 참이면 참 출력하기
		Scanner sc = new Scanner(System.in);
		int TF1 = sc.nextInt();
		int TF2 = sc.nextInt();
		
		// OR
		if(TF1 == 1 || TF2 == 1) 
			System.out.println(1);
        else 
        	System.out.println(0);
		
	}
}
