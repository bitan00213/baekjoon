/*
 * https://www.acmicpc.net/problem/10026
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int temp = Integer.parseInt(br.readLine());
		
		System.out.println(((m+temp)/60+h)%24 + " " + (m+temp)%60);
	}
}