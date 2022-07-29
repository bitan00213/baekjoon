/*
 * https://www.acmicpc.net/problem/1620
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] poketName = new String[N+1];
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 1; i<=N; i++) {
			String tempName = br.readLine();
			map.put(tempName,i);
			poketName[i] = tempName;
		};
		
		for(int i = 0; i<M; i++) {
			String temp = br.readLine();
			if(temp.matches("[+-]?\\d*(\\.\\d+)?")) { //숫자인 경우
				sb.append(poketName[Integer.parseInt(temp)]).append('\n');
			} else {
				sb.append(map.get(temp)).append('\n');
			}
		}
		System.out.println(sb);
	};
};
