package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SWEA_2805 {

	/**
	 * 문제
	 *  N X N크기의 농장이 있다.
	 *  농장의 크기 N와 농작물의 가치가 주어질 때, 규칙에 따라 얻을 수 있는 수익은 얼마인지 구하여라.
	 *   - 농장은 크기는 항상 홀수이다. (1 X 1, 3 X 3 … 49 X 49)
	 *   - 수확은 항상 농장의 크기에 딱 맞는 정사각형 마름모 형태로만 가능하다.
	 *   
	 * 시간: 116 ms
	 * 메모리: 20,672 kb
	 */
	public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
     
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());    //농장 배열 크기
            int[][] farm = new int[N][N];
             
            for(int i = 0; i < N; i++) {
                String str = br.readLine();
                for(int j = 0; j < N; j++) {
                    farm[i][j] = str.charAt(j) - '0';
                }
            }
             
            /*
                        arr[0][n/2]
                arr[1][n/2-1] ~ arr[1][n/2+1]
            arr[2][n/2-2]     ~     arr[2][n/2+2]   - n/2
               arr[n-2][n/2-1]~arr[3][n/2-1]
                        arr[n-1][n/2]
            */
            //N/2를 중심으로 위아래를 보면 열의 규칙이 똑같음.
            // 위 아래 삼각형 더하고, 가운데 한 줄 따로 더하기
            // 2씩 커지는 더하는 범위..
            int ans = 0;
             
            int range = 1;
            for(int i = 0; i < N/2; i++)
            {
                int j = N/2 - i;
                for(int k = 0; k < range; k++) 
                {
                	ans += farm[i][j+k]; //삼각형 위
                	ans += farm[N-1-i][j+k]; //삼각형 아래
                }
                range += 2;
            }
             
            for(int j = 0; j < N; j++) {
            	ans += farm[N/2][j];
            }
 
            System.out.println("#" + test_case + " " + ans);     
        }
    }

}
