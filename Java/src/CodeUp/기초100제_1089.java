package CodeUp;

import java.util.Scanner;

public class 기초100제_1089 {

	public static void main(String[] args) {
		// [기초-종합] 수 나열하기1 
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		// 1번째 수는 a여야 함.(n=0)
		// 즉, idx로 따졌을 때 4의 값이 위치가 5번째인 값이 된다.
		int n = sc.nextInt() - 1; 
		
		// 등차수열 a +bn
		System.out.println(a + b * n);
	}

}
