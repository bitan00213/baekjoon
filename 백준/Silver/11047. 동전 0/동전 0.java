/*
 * https://www.acmicpc.net/problem/11047
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int K;
	public static int[] numArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		numArr= new int[N];
		for(int i =0; i<N;i++) {
			numArr[i] = Integer.parseInt(br.readLine());
		}
		int cnt = 0;
		for(int i = N-1; i>=0; i--) {
			cnt += K/numArr[i];
			K %= numArr[i];
		};
		System.out.println(cnt);
	};
};
