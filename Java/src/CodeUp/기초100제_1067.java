package CodeUp;

import java.util.Scanner;

public class 기초100제_1067 {

	public static void main(String[] args) {
		// [기초-조건/선택실행구조] 정수 1개 입력받아 분석하기
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if(num > 0){
            System.out.println("plus");
            
            if(num % 2 == 0) System.out.println("even");
            else System.out.println("odd");
 
        }else{
            System.out.println("minus");
            
            if(num % 2 == 0) System.out.println("even");
            else System.out.println("odd");
        }
	}

}
