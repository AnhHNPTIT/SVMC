package Day5;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CHAY_DUA {
	public static int findY(int y, int num) {
		if(num == 1) {
			y--;
		}
		else if(num == 2) {
			y++;
		}
		return y;
	}
	
	public static void main(String[] args) throws IOException{
		FileReader fReader = new FileReader("src\\input5.txt");
		Scanner scanner = new Scanner(fReader);
		
		int tc = scanner.nextInt();
		for(int k = 1; k <= tc; k++) {
			int m = scanner.nextInt();
			int n = scanner.nextInt();
			int[] time = {1, 2, 2, 3};
			int[][] arr = new int[m][n + 2];
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					arr[i][j] = scanner.nextInt();
				}
			}
			
			
			int min = 999999;
			int[] list_time = new int[n]; // danh sách time chạy đua của từng vđv
			
			for(int j = 0; j < n; j++) {
				int x = 0;
				int y = j;
				int sum_time = 0;
				while(x < m) {
					boolean isLeftBoundary = (y == 0 && arr[x][y] == 1);
					boolean isRightBoundary = (y == n - 1 && arr[x][y] == 2);
					if(isLeftBoundary || isRightBoundary) {
						sum_time += time[0];
					}
					else {
						sum_time += time[arr[x][y]];
						y = findY(y, arr[x][y]);
					}
					x++;
				}
				list_time[j] = sum_time;
				min = (sum_time <= min) ? sum_time : min; // tìm time nhỏ nhất
			}
			
			for(int j = n - 1; j >= 0; j--) {
				if(list_time[j] == min) {
					System.out.println("#" + k + " " + (j + 1)); // in ra thứ tự của vđv
				}
			}
		}
		
		fReader.close();
	}
}
