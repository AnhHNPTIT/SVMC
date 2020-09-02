package Day6;

import java.io.FileReader;					
import java.io.IOException;					
import java.util.Scanner;					
					
public class QBMAX {					
					
	public static int max(int[][] arr, int i, int j) {
		int max = (arr[i - 1][j - 1] > arr[i][j - 1]) ? arr[i - 1][j - 1] : arr[i][j - 1];
		max = (arr[i + 1][j - 1] > max) ? arr[i + 1][j - 1] : max;
		return max;
	}				
					
	public static void main(String[] args) throws IOException {				
		FileReader fReader = new FileReader("src\\input6.txt");			
		Scanner scanner = new Scanner(fReader);			
					
		int m = scanner.nextInt();			
		int n = scanner.nextInt();			
		int arr[][] = new int[105][105];				
		for(int i = 1; i <= m; i++) {			
			for(int j = 1; j <= n; j++) {		
				arr[i][j] = scanner.nextInt();	
			}		
		}			
					
		int f[][] = new int[105][105];			
		int max = -Integer.MAX_VALUE;			
		for(int j = 0; j <= n; j++) {			
			f[0][j] = -Integer.MAX_VALUE;
			f[m+1][j] = -Integer.MAX_VALUE;		
		}			
					
		for(int j = 1; j <= n; j++) {			
			for(int i = 1; i <= m; i++) {		
				f[i][j] = arr[i][j] + max(f, i, j);	
			}		
		}			
					
		for(int i = 1; i <= m; i++) {			
			max = (f[i][n] >= max) ? f[i][n] : max;		
		}			
		System.out.println(max);
		
		fReader.close();
					
	}				
}	