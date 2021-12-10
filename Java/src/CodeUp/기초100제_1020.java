package CodeUp;

import java.util.Scanner;

public class 기초100제_1020 {

	public static void main(String[] args) {
		// [기초-입출력] 주민번호 입력받아 형태 바꿔 출력하기
		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine().replace("-", "");
		System.out.println(num);
	}

}
