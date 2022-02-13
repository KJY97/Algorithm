package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_11688 {

	/**
	 * 문제
	 *  Calkin-Wilf tree는 모든 양의 유리수를 정확히 하나씩 포함하고 있는 트리다.
	 *  루트 노드에서부터, 자식을 따라 내려간 방향이 순서대로 주어질 때, 마지막에 위치한 노드가 어떤 유리수를 나타내는지 구하기
	 *  이  트리는 다음과 깉이 정의된다.
	 *   - 트리의 루트는 1/1 을 나타낸다.
	 *   - 트리의 각 노드는 왼쪽 자식과 오른쪽 자식을 가지는데 어떤 노드가 a/b 를 나타내고 있다면, 
	 *   	왼쪽 자식은 a/a+b 를 오른쪽 자식은 a+b/b 를 나타낸다.
	 * 
	 * => 모든 트리의 노드 값을 출력하는 것이 아닌 도착한 위치의 a,b 값을 계산하는 것이므로 굳이 tree를 만들 필요가 없다.
	 * 
	 * 시간: 194 ms
	 * 메모리: 42,932 kb
	 */
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
     
        for(int test_case = 1; test_case <= T; test_case++) {
        	String command = br.readLine(); // 길이가 1 ~ 30이하인 문자열. L/R로만 구성
        	
        	int a = 1, b = 1; // 초기화
        	for (int i = 0; i < command.length(); i++) {
				char ch = command.charAt(i);
				if(ch == 'L') {
					b = a + b;
				} else {
					a = a + b;
				}
			}
        	
        	System.out.println("#" + test_case + " " + a + " " + b);
        }
    }
}
