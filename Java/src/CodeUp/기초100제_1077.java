package CodeUp;

import java.util.Scanner;

public class 기초100제_1077 {

	public static void main(String[] args) {
		// [기초-반복실행구조] 정수 1개 입력받아 그 수까지 출력하기
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
        
        for(int i = 0; i <= num; i++) {
            System.out.println(i);
        }
	}

}
