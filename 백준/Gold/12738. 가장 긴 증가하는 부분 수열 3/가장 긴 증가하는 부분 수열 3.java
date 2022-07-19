/*
 * https://www.acmicpc.net/problem/12738
 * LIS문제3번.
 * 이분탐색 이용. LIS 3번처럼 했을 경우 시간초과됨.
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] numArr;
	public static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		numArr= new int[N+1];
		dp = new int[N+1]; //
		/* StringBuilder sb = new StringBuilder(); */
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i<N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		};
		

		dp[0] = Integer.MIN_VALUE;
		int cnt = 0;
		for(int i = 0; i<N;i++) {
			if(dp[cnt]<numArr[i]) {
				dp[cnt+1] = numArr[i]; //해당 수를 다음에 넣는다.
				cnt++; //가장 마지막 index
			} else { //이분탐색
				dp[fn(numArr[i],0,cnt)] = numArr[i];
			};
		};
		System.out.println(cnt);
	};
	
	public static int fn(int searhNum, int left, int right) {
		int result = 0;
		while(true) {
			if(left>=right) {
				break;
			};
			result = (left+right)/2;
			if(searhNum<=dp[result]) {
				right = result;
			} else {
				left = result+1;
			}
		}
		return right;
	}
};