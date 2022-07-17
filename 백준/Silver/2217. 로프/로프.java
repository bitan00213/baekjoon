/*
 * https://www.acmicpc.net/problem/2217
 * 로프
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //로프의 개수
		int[] ropeArr = new int[N];
		for(int i = 0; i<N; i++) {
			ropeArr[i] = Integer.parseInt(br.readLine());
		};
		
		Arrays.sort(ropeArr); //정렬
		int max = 1; //로프는 10,000을 넘지 않는 자연수
		for(int i = 0; i<N;i++) {
			max = Math.max(max, ropeArr[i]*(N-i)); //모든 수에 대해 검증
		};
		System.out.println(max);
	};
};