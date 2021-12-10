package CodeUp;

import java.util.Scanner;

public class 기초100제_1086 {

	public static void main(String[] args) {
		// [기초-종합] 그림 파일 저장용량 계산하기
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt(); // 가로 해상도
		int h = sc.nextInt(); // 세로 해상도
		int b = sc.nextInt(); // 한 픽셀을 저장하기 위한 비트
		
		double Byte = 1.0 * w * h * b;
		System.out.printf("%.2f MB", Byte/8/1024/1024);
		
	}

}
