package CodeUp;

import java.util.Scanner;

public class 기초100제_1056 {

	public static void main(String[] args) {
		// [기초-논리연산] 참/거짓이 서로 다를 때에만 참 출력하기
		Scanner sc = new Scanner(System.in);
		int TF1 = sc.nextInt();
		int TF2 = sc.nextInt();
		
		// XOR
		if((TF1 == 1 && TF2 == 0) || (TF1 == 0 && TF2 == 1)) 
			System.out.println(1);
        else 
        	System.out.println(0);
	}

}
