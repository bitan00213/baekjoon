/*
 * https://www.acmicpc.net/problem/25304
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int temp = 0;
		for(int i = 0; i<m;i++) {
			st = new StringTokenizer(br.readLine());
			temp += Integer.parseInt(st.nextToken())*Integer.parseInt(st.nextToken());
		}
		if(n==temp) System.out.println("Yes");
		else System.out.println("No");
	};
};