package Day6;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static int n, h_max, h_min;
	public static int[][] arr = new int[105][105];
	public static int[][] d = new int[105][105];
	public static int dx[] = {0, 1, 0, -1};
	public static int dy[] = {1, 0, -1, 0};
	
	public static void reset(int[][] arr, int n) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = 0;
			}
		}
	}
	public static boolean dfs(int u, int v) {
	    d[u][v] = 1; 
	    if( u == n - 1 && v == n-1 ) {
	    	return true;
	    }
	    
	    for(int i = 0; i < 4; i++) {
	        int x = u + dx[i], y = v + dy[i];
	        if( x >= 0 && y >= 0 && x < n && y < n && d[x][y] == 0 && arr[x][y] >= h_min && arr[x][y] <= h_max ) {
	            if(dfs(x,y)) {
	            	return true;
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
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}
		
		int del = 110;
	    for(h_min = 0; h_min <= arr[0][0]; h_min++) {
	        int L = 0, H = 110;
	        while(L <= H) {
	            int mid = (L+H)>>1;
	            h_max = h_min + mid;
	            reset(d, n);
	            boolean isCheck = dfs(0,0);

	            if(L == H) {
	                if(!isCheck) {
	                	L = 110;
	                }
	                break;
	            }
	            
	            if(isCheck) {
	            	H = mid;
	            }
	            else {
	            	L = mid + 1;
	            }
	        }
	        del = (del < L) ? del : L;
	    }
	    System.out.println(del);
		
		fReader.close();
	}
}
