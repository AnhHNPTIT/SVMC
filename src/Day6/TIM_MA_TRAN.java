package Day6;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TIM_MA_TRAN {
	public static int sumMatrix(int[][] arr, int x, int y, int m) {
		int sum = 0;
		for(int i = 0; i < x + m; i++) {
			for(int j = 0; j < y + m; j++) {
				sum += arr[i][j];
			}
		}
		return sum;
	}
	
	public static void main(String[] args) throws IOException {				
		FileReader fReader = new FileReader("src\\input6.txt");			
		Scanner scanner = new Scanner(fReader);			
					
		int tc = scanner.nextInt();
		for(int count = 1; count <= tc; count++) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int k = scanner.nextInt();
			int[][] arr = new int[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					arr[i][j] = scanner.nextInt();
				}
			}
			
			int[][] arr_sum = new int[n - m][n - m];
			int x = 0, y = 0;
			int min = k;
			for(int i = 0; i < n - m; i++) {
				for(int j = 0; j < n - m; j++) {
					arr_sum[i][j] = sumMatrix(arr, i, j, m);
					int tmp = Math.abs(arr_sum[i][j] - k);
					if(tmp < min) {
						min = tmp;
						x = i; 
						y = j;
					}
				}
			}
			
			System.out.println("#" + count + " " + x + " " + y);
		}
		
		fReader.close();
	}			
}
