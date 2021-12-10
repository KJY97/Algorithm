package CodeUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 기초100제_1084 {

	public static void main(String[] args) throws IOException {
		// [기초-종합] 빛 섞어 색 만들기
		// 시간초과 발생. Scanner, println() 대신 BufferedReader, BufferedWriter 사용
		// StringBuilder를 사용하면 메모리 초과 발생. 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String []color = br.readLine().split(" ");

		int cnt = 0;
		for (int i = 0; i < Integer.parseInt(color[0]); i++) {
			for (int j = 0; j < Integer.parseInt(color[1]); j++) {
				for (int k = 0; k < Integer.parseInt(color[2]); k++) {
					bw.write(i + " " + j + " " + k + "\n");
					cnt++;
				}
			}
		}
		
		// BufferedWriter는 버퍼에 문자열로만 작성가능
		bw.write(String.valueOf(cnt)); 
		bw.flush(); // 남아있는 데이터 모두 출력
		bw.close(); // 스트림 닫음
	}

}
