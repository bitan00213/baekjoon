/*
 * https://www.acmicpc.net/problem/7662
 * 전형적인 큐와의 차이점은 데이터를 삭제할 때 연산(operation) 명령에 따라 우선순위가 가장 높은 데이터 또는 가장 낮은 데이터 중 하나를 삭제하는 점이다. 
 * ==> remove를 다른 방식으로 해야 한다.
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T =  Integer.parseInt(st.nextToken());
		int K;
		for(int i = 0; i<T; i++) {
			K = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
			StringTokenizer str;
			for(int j = 0; j<K; j++) {
				str = new StringTokenizer(br.readLine());
				String order = str.nextToken();
				int temp = Integer.parseInt(str.nextToken());
				if("I".equals(order)) {
					map.put(temp, map.getOrDefault(temp, 0)+1);
				} else {
					if(map.size()==0) continue;
					int temp2;
					if(temp == -1) {
						temp2 = map.firstKey();
					} else {
						temp2 = map.lastKey();
					}
					if(map.put(temp2, map.get(temp2)-1)==1) {
						map.remove(temp2);
					}
				}
			}
			
			if(map.size()==0) {
				sb.append("EMPTY").append('\n');
			} else {
				sb.append(map.lastKey()).append(" ").append(map.firstKey()).append('\n');
			}
		}
		System.out.println(sb);
	};
};