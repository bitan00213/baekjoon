/*
 * https://www.acmicpc.net/problem/1107
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int btnCnt = Integer.parseInt(br.readLine());
		boolean[] ty = new boolean[10]; //가능한 가짓수
		StringTokenizer st = null;
		if(btnCnt>0) {
			st = new StringTokenizer(br.readLine());
		}
		for(int i = 0; i<btnCnt; i++) {
			ty[Integer.parseInt(st.nextToken())] = true;
		}
		int cnt = Math.abs(N-100); //+-만 누를 경우
		int length;
		boolean breakTy;	//부숴진 수 사용 유무
		String tempNum;
		for(int i = 0; i<= 1000000;i++) {	//50만 이상에서 돌아올 수 있으므로 큰 수 지정
			breakTy = false;			//사용 가능한 수로 가정
			tempNum = i+"";				
			length = tempNum.length();
			for(int j = 0; j<length; j++) {
				if(ty[tempNum.charAt(j)-48]) {	
					breakTy = true;
					break;
				}
			}
			if(!breakTy) {	//부숴진 수를 사용한게 아니라면 저장
				cnt = Math.min(cnt, Math.abs(N-i)+length);
			}
		}
		System.out.println(cnt);
	};
};