/*
 * https://www.acmicpc.net/problem/18111
 * 브루트포스 문제인데 시간계산을 잘못함.
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] numArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		numArr= new int[N][M];
		StringTokenizer str;
		int min =Integer.MAX_VALUE;
		int max =Integer.MIN_VALUE;
		for(int i = 0; i<N; i++) {
			str = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				numArr[i][j] = Integer.parseInt(str.nextToken());
				min = Math.min(numArr[i][j], min);
				max = Math.max(numArr[i][j], max);
			};
		};
		int time = Integer.MAX_VALUE;
		int height = 0;
		for(int i = min; i<=max; i++) {
			int cnt = 0;
			int block = B;
			for(int j = 0; j<N;j++) {
				for(int k=0; k<M; k++) {
					if(i<numArr[j][k]) {
						cnt += (numArr[j][k]-i)*2;
						block += numArr[j][k]-i;
					} else {
						cnt += i-numArr[j][k];
						block -= i-numArr[j][k];
					}
				}
			}
			if(block>=0 && time>=cnt) {
				time = cnt;
				height = i;
			};
		};
		System.out.println(time +" "+ height);
	};
};