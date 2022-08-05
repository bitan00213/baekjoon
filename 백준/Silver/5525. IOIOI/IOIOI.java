/*
 * https://www.acmicpc.net/problem/5525
 * 문제 이해를 하자.
 * O는 항상 N개!
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static int N;
	public static int S;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = Integer.parseInt(br.readLine());

		int[] dp = new int[S];
		String str = br.readLine();
		char[] strArr = str.toCharArray();
		int result = 0;
		for(int i = 1; i<S-1; i++) {
			if(strArr[i]=='O' && strArr[i+1]=='I') {
				dp[i+1] = dp[i-1]+1;
				if(dp[i+1]>= N && strArr[i-2*N+1]=='I') {
					result++;
				}
			}
		}
		System.out.println(result);
		/*
		 * 50점 짜리...
		String str = br.readLine();
		String temp = "IOI";
		for(int i = 1; i<N; i++) {
			temp +="OI";
		}
		int result = 0;
		for(int i =0; i<=S-(2*N+1); i++) {
			if(temp.equals(str.substring(i, i+2*N+1))) {
				result++;
				i++;
			}
		}
		System.out.println(result);
		*/
	}
};

   