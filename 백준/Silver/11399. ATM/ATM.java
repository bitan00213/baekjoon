/*
 * https://www.acmicpc.net/problem/11399
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] numArr= new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0 ;i <N;i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numArr);
		int result = 0;
		for(int i = 0; i<N;i++) {
			result += numArr[i]*(N-i);
		}
		System.out.println(result);
	};
};
