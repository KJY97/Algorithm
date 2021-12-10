package CodeUp;

import java.util.Scanner;

public class 기초100제_1046 {

	public static void main(String[] args) {
		// [기초-산술연산] 정수 3개 입력받아 합과 평균 출력하기
		Scanner sc = new Scanner(System.in);
		long num = sc.nextLong(); // 입력범위 -2147483648 ~ +2147483647
        num += sc.nextLong();
        num += sc.nextLong();
        
        System.out.println(num);
        System.out.printf("%.1f", (float)num/3);

	}

}
