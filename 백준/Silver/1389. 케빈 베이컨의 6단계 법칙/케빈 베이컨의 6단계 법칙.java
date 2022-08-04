/*
 * https://www.acmicpc.net/problem/11047
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int M;
	public static int[][] numArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numArr= new int[N+1][N+1];
		for(int i =1; i<=N;i++) { //갱신을 위한 초기화 필요
			for(int j= 1; j<=N; j++) {
				numArr[i][j] = 500001;
				if(i==j) numArr[i][j]=0; //자기자신
			}
		}
		StringTokenizer str;
		for(int i = 0; i<M; i++) {
			str = new StringTokenizer(br.readLine());
			int tempX = Integer.parseInt(str.nextToken());
			int tempY = Integer.parseInt(str.nextToken());
			
			numArr[tempX][tempY] = 1; 
			numArr[tempY][tempX] = 1; 
		}
		
		/* 
		 * 경로탐색처럼 for문 돌리기 
		 * */
		
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				for(int k = 1; k<=N; k++) {
					if(numArr[j][k]>numArr[j][i] + numArr[i][k]) {
						numArr[j][k] = numArr[j][i]+ numArr[i][k]; //적은 값으로 갱신
					}
				}
			}
		}
		
		int temp = Integer.MAX_VALUE;
		int result = Integer.MAX_VALUE;
		for(int i = 1; i<=N; i++) {
			int tempSum = 0;
			for(int j =1; j<=N; j++) {
				tempSum += numArr[i][j];
			}
			if(temp>tempSum) {
				temp= tempSum;
				result = i;
			}
		}
		System.out.println(result);
	};
};