/*
 * https://www.acmicpc.net/problem/17626
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		dp[1] =1;
		func(n);
		System.out.println(dp[n]);
	};
	public static void func(int n) {
		int min;
		for(int i = 2; i<=n; i++) {
			min = Integer.MAX_VALUE;
			for(int j = 1; (int) Math.pow(j, 2)<=i; j++) {
				min = Math.min(min, dp[i - (int) Math.pow(j, 2)] );
			}
			dp[i] = min+1;
		};
	};
};