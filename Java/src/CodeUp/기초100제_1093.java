package CodeUp;

import java.util.Scanner;

public class 기초100제_1093 {

	public static void main(String[] args) {
		// [기초-1차원배열] 이상한 출석 번호 부르기1
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []student = new int[24]; // 0번 index 사용 안함.
		
		for (int i = 0; i < n; i++) {
			student[sc.nextInt()]++;
		}
		
		for(int i = 1; i < 24; i++){
            System.out.print(student[i] + " ");
        }
	}

}
