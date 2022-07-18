/*
 * https://www.acmicpc.net/problem/14002
 * LIS문제4번. 메모리가 256제한이 있다.
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numArr= new int[N+1];
		int[][] dp = new int[N+1][2]; //문제가 길이와 해당 LIS를 출력해야 하므로 인덱스 위치용으로 설정
		/* StringBuilder sb = new StringBuilder(); */
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i<N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
			dp[i][0] =1; //자기자신은 길이 1
			dp[i][1] =-1; //0번 인덱스가 포함될 수 있으므로 초기화
			for(int j = 0; j<i; j++) {	//DP
				if(numArr[j]<numArr[i] 	 //다음 수가 이전 수보단 작아야 하고
				&& dp[i][0] < dp[j][0]+1 //다음 수의 길이가 이전수까지의 LIS보다 짧을 때 길어짐 
				) {
					dp[i][0] = dp[j][0]+1;
					dp[i][1] = j; //앞의 수 인덱스
				};
			};
		};
		
		int max = 1;
		int temp1 = 0; //인덱스
		for(int i =0; i<N;i++) {
			if(dp[i][0] >max) {
				max = dp[i][0];
				temp1 = i;
			}
			/*
			 * 중복값을 제거해야 함.
			 * if(dp[i][1] != -1) { sb.append(numArr[dp[i][1]+1]).append(" "); };
			 */
		};
		String result = ""; //다음에 수정하자.. 다른 방법이 있을듯?
		while(true) {
			if(temp1 == -1) {
				break;
			};
			result = numArr[temp1]+" "+result;
			temp1 = dp[temp1][1];
		}
		System.out.println(max);
		System.out.println(result);
	};
};
