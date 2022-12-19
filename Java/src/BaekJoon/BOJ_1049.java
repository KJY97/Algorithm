package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1049 {

	/**
	 * 문제
	 *  Day Of Mourning의 기타리스트 강토가 사용하는 기타에서 N개의 줄이 끊어졌다.
	 *  따라서 새로운 줄을 사거나 교체해야 한다. 강토는 되도록이면 돈을 적게 쓰려고 한다.
	 *  6줄 패키지를 살 수도 있고, 1개 또는 그 이상의 줄을 낱개로 살 수도 있다.
	 *  끊어진 기타줄의 개수 N과 기타줄 브랜드 M개가 주어지고, 
	 *  각각의 브랜드에서 파는 기타줄 6개가 들어있는 패키지의 가격, 낱개로 살 때의 가격이 주어질 때, 
	 *  적어도 N개를 사기 위해 필요한 돈의 수를 최소로 하는 프로그램을 작성하시오.
	 *   - N과 M(1 <= N <= 100, 1 <= M <= 50)
	 *   - M개의 줄에는 각 브랜드의 패키지 가격과 낱개의 가격이 공백으로 구분하여 주어진다. 
	 *   - 가격은 0보다 크거나 같고, 1,000보다 작거나 같은 정수이다.
	 *   - 시간제한 2초
	 *   
	 * 시간: 80 ms
	 * 메모리: 11652 kb
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 끊어진 기타줄의 개수(=즉, 구매해야 하는 기타줄 수)
		int M = Integer.parseInt(st.nextToken()); // 기타줄 브랜드 
		
		// 브랜드별로 구매하는 것이 아닌, 가장 싼 것을 찾는 것이므로 하나의 배열에 묶을 필요가 없다.
		int[] g_package = new int[M];
		int[] g_single = new int[M];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int package_price = Integer.parseInt(st.nextToken()); // 6개 들어있는 패키지 가격
			int single_price = Integer.parseInt(st.nextToken()); // 낱개 가격
			
			g_package[i] = package_price;
			g_single[i] = single_price;
		}

		// 패키지, 낱개 오름차순 정렬
		Arrays.sort(g_package);
		Arrays.sort(g_single);
		
		// 모든 경우의 수를 고려한다.
		// 1. 낱개로 모두 구매하는 경우
		int all_s = N*g_single[0];
		
		// 2. 패키지 + 낱개로 구매하는 경우
		int p_s = (N/6)*g_package[0] + (N%6)*g_single[0];
		
		// 3. 패키지로 모두 구매하는 경우
		int all_p = (N/6)*g_package[0];
		if (N%6 != 0) // 반드시 N개를 맞출 필요는 없다.
			all_p += g_package[0];
		
		int ans = Math.min(all_s, Math.min(p_s, all_p));
		System.out.println(ans);
	}

}
