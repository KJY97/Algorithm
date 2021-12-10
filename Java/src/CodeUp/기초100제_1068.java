package CodeUp;

import java.util.Scanner;

public class 기초100제_1068 {

	public static void main(String[] args) {
		// [기초-조건/선택실행구조] 정수 1개 입력받아 평가 출력하기
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		
		if(90 <= score && score <= 100) 
			System.out.println("A");
        else if(70 <= score && score <= 89) 
        	System.out.println("B");
        else if(40 <= score && score <= 69) 
            System.out.println("C");
        else 
            System.out.println("D");
        
	}

}
