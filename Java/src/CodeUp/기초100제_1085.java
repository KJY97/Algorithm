package CodeUp;

import java.util.Scanner;

public class 기초100제_1085 {

	public static void main(String[] args) {
		// [기초-종합] 소리 파일 저장용량 계산하기
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt(); // 1초 동안 마이크로 소리강약 체크(Hz)
		int b = sc.nextInt(); // 한 번 체크한 결과 저장 비트
		int c = sc.nextInt(); // 소리를 저장할 트랙 개수
		int s = sc.nextInt(); // 녹음 시간
		
        double Byte = 1.0 * h * b * c * s; // 필요한 저장 용량
        System.out.printf("%.1f MB",Byte/8/1024/1024); // MB 단위로 출력
	}

}
