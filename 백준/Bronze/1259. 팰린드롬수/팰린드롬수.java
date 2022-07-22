/*
 * https://www.acmicpc.net/problem/1259
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String n = br.readLine();
			if(n.equals("0")) break;
			boolean ty = true;
			for(int i = 0; i<n.length()/2; i++) {
				if((n.charAt(i) !=n.charAt(n.length()-i-1)) && ty) {
					sb.append("no").append("\n");
					ty = false;
				};
			};
			if(ty) {
				sb.append("yes").append("\n");
			};
		};
		System.out.println(sb);
	};
};