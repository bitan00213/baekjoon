/*
 * https://www.acmicpc.net/problem/2920
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int temp1= Integer.parseInt(st.nextToken());
		int result = 0;
		String print = " ";
		for(int i =0 ; i<7; i++) {
			int temp2= Integer.parseInt(st.nextToken());
			int tempResult = temp1-temp2;
			if(result !=0) {
				if(result != tempResult) {
					print = "mixed";
					break;
				}
			} else {
				result = tempResult;	
			};
			temp1 = temp2;
		};
		if(!print.equals("mixed")) {
			if(result == 1) {
				System.out.println("descending");
			} else if(result == -1){
				System.out.println("ascending");
			}
		} else {
			System.out.println(print);
		}
		
	};
};
