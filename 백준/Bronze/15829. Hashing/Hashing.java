/*
 * https://www.acmicpc.net/problem/15829
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int M = 1234567891;
	public static int r = 31;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());
		String num = br.readLine();
		/*a의 charAt 값은 97*/
		long temp = 1;
		long result = 0;
		for(int i = 0; i<length; i++) {
			result += ((num.charAt(i)-96)*temp)%M;
			result %= M;
			temp = (temp*r)%M;
		};
		System.out.println(result);
	};
};
