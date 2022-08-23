/*
 * https://www.acmicpc.net/problem/15657
 * */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int i = Integer.parseInt(st.nextToken());
    	int j = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	if(i==j && j ==k) {
    		System.out.println(10000+i*1000);
    	} else if(i!=j && j!=k && k!=i) {
    		System.out.println(Math.max(i, Math.max(j, k))*100);
    	} else {
    		if(i==j || i==k) {
    			System.out.println(1000+i*100);
    		} else {
    			System.out.println(1000+j*100);
    		}
    	}
    }
}