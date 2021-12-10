package CodeUp;

import java.util.Scanner;

public class 기초100제_1012 {

	public static void main(String[] args) {
		// [기초-입출력] 실수 1개 입력받아 그대로 출력하기
		Scanner sc = new Scanner(System.in);
		float f = sc.nextFloat();
		// 소수점 6자리까지 출력
		String x6 = String.format("%.6f", f); 
        System.out.println(x6);
	}

}
