/*
 * https://www.acmicpc.net/problem/1789
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long S = Long.parseLong(br.readLine());
		long temp= 0;
		int cnt = 0;
		while(true) {
			if(S<temp) {
				break;
			}
			cnt++;
			temp+=cnt;
		}
		if(temp!=S) cnt--;
		System.out.println(cnt);
	}
};