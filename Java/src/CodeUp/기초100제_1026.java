package CodeUp;

import java.util.Scanner;

public class 기초100제_1026 {

	public static void main(String[] args) {
		// [기초-입출력] 시분초 입력받아 분만 출력하기
		Scanner sc = new Scanner(System.in);
		String []date = sc.nextLine().split(":");
		
		// 6:00:00 -> 0 으로 출력되어야 함
        System.out.println(Integer.parseInt(date[1]));
	}

}
