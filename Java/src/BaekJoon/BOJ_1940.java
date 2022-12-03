package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1940 {

	/**
	 * 문제
	 *  주몽은 철기군을 양성하기 위한 프로젝트에 나섰다. 그래서 야철대장을 통해 철기군이 입을 갑옷을 만들게 하였다.
	 *  야철대장은 주몽의 명에 따르기 위하여 연구에 착수하던 중 아래와 같은 사실을 발견하게 되었다.
	 *  갑옷을 만드는 재료들은 각각 고유한 번호를 가지고 있다.
	 *  갑옷은 두 개의 재료로 만드는데 두 재료의 고유한 번호를 합쳐서 M(1 ≤ M ≤ 10,000,000)이 되면 갑옷이 만들어 지게 된다.
	 *  야철대장은 자신이 만들고 있는 재료를 가지고 갑옷을 몇 개나 만들 수 있는지 궁금해졌다.
	 *  이러한 궁금증을 풀어 주기 위하여 N(1 ≤ N ≤ 15,000) 개의 재료와 M이 주어졌을 때 몇 개의 갑옷을 만들 수 있는지를 구하는 프로그램을 작성하시오.
	 *   - 재료의 개수 N(1 ≤ N ≤ 15,000)
	 *   - 갑옷을 만드는데 필요한 수 M(1 ≤ M ≤ 10,000,000) 
	 *   - N개의 재료들이 가진 고유한 번호들이 공백을 사이에 두고 주어진다. 고유한 번호는 100,000보다 작거나 같은 자연수이다.
	 *   - 제한시간 2초
	 * 
	 * => 투포인터 활용
	 *    2중 반복문과 비교하면 시간 2배 감소
	 *    
	 * 시간: 140 ms
	 * 메모리: 16072 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine()); // 재료 수
		int M = Integer.parseInt(br.readLine()); // 갑옷 만드는데 필요한 수
		
		int[] material = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			material[i] = Integer.parseInt(st.nextToken());
		}

		// 오름차순 정렬
		Arrays.sort(material);
		
		// 갑옷은 2개의 재료로 만들어진다.
		int start = 0, end = N-1;
		int cnt = 0;
		while(start < end) {
			if (material[start] + material[end] == M) {
				cnt++;
				start++;
			}
			else if (material[start] + material[end] > M) {
				end--;
			} else {
				start++;
			}
		}
		
		System.out.println(cnt);
	}

}
