package CodeUp;

import java.util.Scanner;

public class 기초100제_1027 {

	public static void main(String[] args) {
		// [기초-입출력] 년월일 입력 받아 형식 바꿔 출력하기
		Scanner sc = new Scanner(System.in);
		String []date = sc.nextLine().split("\\.");
		
		System.out.println(date[2] + "-" + date[1] + "-" + date[0]);
	}

}
