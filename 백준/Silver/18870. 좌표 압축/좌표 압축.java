import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/12932
 * */

//2차원 배열 정렬...

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(br.readLine());
		int numArr[][] = new int[n][2]; 
		int indexArr[][] = new int[n][2]; 
		
		//뒤에는 해당 수의 index를 담는다.
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			numArr[i][0] = Integer.parseInt(st.nextToken());
			numArr[i][1] = i;
		}
		
		//2차원 배열 정렬
		Arrays.sort(numArr, (a,b)->{
			return a[0]-b[0];
		});
		
		//인덱스 배열 초기설정
		indexArr[0][0] = numArr[0][1];  //앞에는 순서
		indexArr[0][1] = 0;				//뒤에는 큰 수의 개수를 카운팅한다.
		
		//같은 수 확인
		int cnt = 0;
		
		for (int i = 1; i < n; i++) {
			//만약 같은 수가 있다면 증가시키기
			if(numArr[i][0] == numArr[i-1][0]) {
				cnt++;
			}
			indexArr[i][0] = numArr[i][1]; //수의 인덱스를 받아넣는다.
			indexArr[i][1] = i-cnt; //같은 수는 중복해서 세면 안됨
		}
		//2차원 배열 정렬
		Arrays.sort(indexArr, (a,b)->{
			return a[0]-b[0];
		});
		//수의 인덱스에 맞게 출력
		for (int i = 0; i < n; i++) {
			sb.append(indexArr[i][1]+" ");
		}
		System.out.println(sb);
	}
}