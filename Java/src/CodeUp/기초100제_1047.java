package CodeUp;

import java.util.Scanner;

public class 기초100제_1047 {
	
	public static void main(String[] args) {
		// [기초-비트시프트연산] 정수 1개 입력받아 2배 곱해 출력하기
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		// << : 이동개수만큼 2배 증가
		// >> : 이동개수만큼 2배 감소
		System.out.println(num << 1);
	}

}
