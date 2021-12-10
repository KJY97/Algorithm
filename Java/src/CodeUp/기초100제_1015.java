package CodeUp;

import java.util.Scanner;

public class 기초100제_1015 {

	public static void main(String[] args) {
		// [기초-입출력] 실수 입력받아 둘째 자리까지 출력하기
		Scanner sc = new Scanner(System.in);
		float f = sc.nextFloat();
		
		System.out.println(String.format("%.2f", f));
//		System.out.println((float)Math.round(f*100)/100.0);
	}

}
