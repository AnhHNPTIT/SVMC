package Day6;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import javafx.util.Pair;

public class MTWALK {
	public static int n, h_max, h_min;
	public static int[][] arr = new int[105][105];
	public static int[][] d = new int[105][105];
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, -1, 0, 1};
	
	public static boolean bfs(int del) {
		for(int l = h_min; l <= h_max - del; l++) {
			int r = l + del;
			if(arr[1][1] < l || arr[1][1] > r) {
				continue;
			}
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					d[i][j] = 0;
				}
			}
			d[1][1] = 1;
			Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
			Pair<Integer, Integer> tmp = new Pair(1, 1);
			queue.add(tmp);
			while(!queue.isEmpty()) {
				int i = queue.peek().getKey();
				int j = queue.peek().getValue();
				if (i == n && j == n) return true;
				for(int k = 0; k <= 3; k++) {
					int u = i + dx[k], v = j + dy[k];
					if (u < 1 || u > n || v < 1 || v > n) {
						continue;
					}
					if (arr[u][v] < l || arr[u][v] > r) {
						continue;
					}
					d[u][v] = 1;
					tmp = new Pair(u, v);
					queue.add(tmp);
				}	
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) throws IOException {				
		FileReader fReader = new FileReader("src\\input6.txt");			
		Scanner scanner = new Scanner(fReader);			
					
		//https://vn.spoj.com/problems/MTWALK/
		n = scanner.nextInt();
		h_max = 110;
		h_min = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				arr[i][j] = scanner.nextInt();
				h_max = (arr[i][j] > h_max) ? arr[i][j] : h_max;
				h_min = (arr[i][j] < h_min) ? arr[i][j] : h_min;
			}
		}
		
		int left = 0, right = h_max - h_min, del = 0;
		while(left <= right) {
			int mid = (left + right)/ 2;
			if(bfs(mid)) {
				del = mid; right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		
		System.out.println(del);
		
		fReader.close();
	}
}
