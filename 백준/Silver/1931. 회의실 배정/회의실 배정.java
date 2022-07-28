/*
 * https://www.acmicpc.net/problem/1931
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
	public static int[][] numArr;
	public static boolean[] ty;
	public static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] numArr=  new int[N][2];
		StringTokenizer st;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			numArr[i][0] = Integer.parseInt(st.nextToken()); 
			numArr[i][1] = Integer.parseInt(st.nextToken()); 
		}
		
		Arrays.sort(numArr, new Comparator<int[]>() { /*2차원 배열 정렬 */
			
			@Override
			public int compare(int[] temp1, int[] temp2) {
				if(temp1[1] == temp2[1]) {
					return temp1[0]-temp2[0];
				}
				return temp1[1]-temp2[1];
			}
		});
		
		int cnt = 0;
		int temp = 0;
		for(int i = 0; i<N;i++) {
			if(temp<=numArr[i][0]) {
				temp = numArr[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}

   