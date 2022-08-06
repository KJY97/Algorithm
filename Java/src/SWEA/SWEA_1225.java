package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1225 {
	
	/**
	 * 문제
	 *  다음 주어진 조건에 따라 n개의 수를 처리하면 8자리의 암호를 생성할 수 있다.
	 *   - 8개의 숫자를 입력 받는다.
	 *   - 첫 번째 숫자를 1 감소한 뒤, 맨 뒤로 보낸다. 
	 *  다음 첫 번째 수는 2 감소한 뒤 맨 뒤로, 그 다음 첫 번째 수는 3을 감소하고 맨 뒤로, 그 다음 수는 4, 그 다음 수는 5를 감소한다.
	 *  이와 같은 작업을 한 사이클이라 한다.
	 *  숫자가 감소할 때 0보다 작아지는 경우 0으로 유지되며, 프로그램은 종료된다. 이 때의 8자리의 숫자 값이 암호가 된다.
	 *  각 테스트 케이스의 첫 줄에는 테스트 케이스의 번호가 주어지고, 그 다음 줄에는 8개의 데이터가 주어진다.
	 *   - 주어지는 각 수는 integer 범위를 넘지 않는다.
	 *   - 마지막 암호 배열은 모두 한 자리 수로 구성되어 있다.
	 * 
	 * => 테스트 케이스가 10개 이다.
	 * 
	 * 시간: 106 ms
	 * 메모리: 18,672 kb
	 */
	
	private static int[] num;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			
			int T = Integer.parseInt(br.readLine()); // 테스트 케이스 번호
			
			num = new int[8];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			int cnt = 1;
			
			while(true) {
				num[0] -= cnt;
				cnt++;
				
				move();
				
				// 0보다 작아지거나 0일 경우 0으로 저장되며 사이클 stop
				if (num[7] <= 0) {
					num[7] = 0;
					break;
				}
				
				// cnt 사이클은 1 ~ 5
				if (cnt == 6) cnt = 1;
			}
			
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
		}
		
	}
	
	// 맨 앞에 있는 수가 맨 뒤로 이동한다.
	private static void move() {
		int tmp = num[0];
		for (int i = 1; i < 8; i++) {
			num[i-1] = num[i];
		}
		num[7] = tmp;
	}

}
