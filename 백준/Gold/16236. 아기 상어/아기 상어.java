/*
 * https://www.acmicpc.net/problem/16236
 * */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
    private static class descaretes {
        private int x;
        private int y;

        private descaretes(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
	
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int N;
    private static int[][] map;
    private static int[][] dist;
    private static int sharkX = -1;
    private static int sharkY = -1;
    private static int sharkSize = 2;
    private static int eatingCount = 0;
    private static int count = 0;
    private static int minX;
    private static int minY;
    private static int minDist;

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
        	st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            dist = new int[N + 1][N + 1];
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            minDist = Integer.MAX_VALUE;

            BFS(sharkX, sharkY);

            if (minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
                eatingCount++;
                map[minX][minY] = 0;
                sharkX = minX;
                sharkY = minY;
                count += dist[minX][minY];

                if (eatingCount == sharkSize) {
                    sharkSize++;
                    eatingCount = 0;
                }
            } else {
                break;
            }
        }

        System.out.println(count);
    }

    private static void BFS(int x, int y) {
        Queue<descaretes> queue = new LinkedList<>();
        queue.add(new descaretes(x, y));

        while (!queue.isEmpty()) {
        	descaretes p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = p.x + dx[i];
                int newY = p.y + dy[i];

                if (isInArea(newX, newY) && isAbleToMove(newX, newY) && dist[newX][newY] == 0) {
                    dist[newX][newY] = dist[p.x][p.y] + 1;

                    if (isEatable(newX, newY)) {
                        if (minDist > dist[newX][newY]) {
                            minDist = dist[newX][newY];
                            minX = newX;
                            minY = newY;
                        } else if (minDist == dist[newX][newY]) {
                            if (minX == newX) {
                                if (minY > newY) {
                                    minX = newX;
                                    minY = newY;
                                }
                            } else if (minX > newX) {
                                minX = newX;
                                minY = newY;
                            }
                        }
                    }

                    queue.add(new descaretes(newX, newY));
                }
            }
        }
    }

    private static boolean isAbleToMove(int x, int y) {
        return map[x][y] <= sharkSize;
    }

    private static boolean isEatable(int x, int y) {
        return map[x][y] != 0 && map[x][y] < sharkSize;
    }

    private static boolean isInArea(int x, int y) {
        return x <= N && x > 0 && y <= N && y > 0;
    }
}