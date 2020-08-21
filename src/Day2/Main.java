package Day2;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException{
		FileReader fReader = new FileReader("src\\input2.txt");
		Scanner scanner = new Scanner(fReader);
		
		//QBSQUARE - Hình vuông 0 1
//		int m = scanner.nextInt();
//		int n = scanner.nextInt();
//		int[][] arr = new int[m][n];
//		for(int i = 0; i < m; i++) {
//			for(int j = 0; j < n; j++) {
//				arr[i][j] = scanner.nextInt();
//			}
//		}
//		
//		int[][] tmp = new int[m][n];
//		for(int i = 0; i < m; i++) {
//			tmp[i][0] = 1;
//		}
//		for(int j = 0; j < n; j++) {
//			tmp[0][j] = 1;
//		}
//		int max = 1;
//		for(int i = 1; i < m; i++) {
//			for(int j = 1; j < n; j++) {
//				if(arr[i][j] == arr[i - 1][j - 1] && arr[i][j] == arr[i - 1][j] && arr[i][j] == arr[i][j - 1]) {
//					int min = (tmp[i - 1][j - 1] < tmp[i - 1][j]) ? tmp[i - 1][j - 1] : tmp[i - 1][j];
//					min = (tmp[i][j - 1] < min) ? tmp[i][j - 1] : min;
//					tmp[i][j] = min + 1;
//					max = (tmp[i][j] > max) ? tmp[i][j] : max;
//				}
//				else {
//					tmp[i][j] = 1;
//				}
//			}
//		}
//		System.out.println(max);
		
		//MTXOAYOC - Ma trận xoáy ốc
//		int m = scanner.nextInt();
//		int n = scanner.nextInt();
//		int[][] arr = new int[m][n];
//		int d = 1, i = 0, j = 0, di = 0, dj = 0;
//		while (d <= m * n) {
//			for (j = dj; j < n - dj - 1 && d <= m * n; j++) {
//				arr[i][j] = d; d++; 
//			}
//			for (i = di; i < m - di - 1 && d <= m * n; i++) {
//				arr[i][j] = d; d++; 
//			}
//			for (j = n - dj - 1; j > dj && d <= m * n; j--) { 
//				arr[i][j] = d; d++; 
//				}
//			for (i = m - di - 1; i > di && d <= m * n; i--) { 
//				arr[i][j] = d; d++; 
//			}
//			di++; dj++; i++;
//		}
//		for(i = 0; i < m; i++) {
//			for(j = 0; j < n; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		
		//FOOTBALLRANK - Bóng đá
//		int m = scanner.nextInt();
//		int[][] arr = new int[m][m];
//		for(int i = 0; i < m; i++) {
//			for(int j = 0; j < m; j++) {
//				arr[i][j] = scanner.nextInt();
//			}
//		}
//		
//		// In ra màn hình tất cả các đội có số điểm lớn nhất
//		int max = 0, index = 1;
//		for(int i = 0; i < m; i++) {
//			int sum = 0;
//			for(int j =0; j < m; j++) {
//				sum += arr[i][j];
//			}
//			if(sum > max) {
//				max = sum;
//				index = i + 1;
//			}
//		}
//		System.out.println(index);
//		
//		// In ra màn hình tất cả các đội có số trận thắng nhiều hơn thua?
//		for(int i = 0; i < m; i++) {
//			int count_win = 0;
//			int count_lose = 0;
//			for(int j =0; j < m; j++) {
//				if(arr[i][j] == 3) {
//					count_win++;
//				}
//				if(arr[i][j] == 0) {
//					count_lose++;
//				}
//			}
//			if(count_win > count_lose) {
//				System.out.print(i + 1 + " ");
//			}
//		}
//		System.out.println();
//		
//		//  Hãy chỉ ra các đội không thua trận nào?
//		for(int i = 0; i < m; i++) {
//			int count = 0;
//			for(int j =0; j < m; j++) {
//				if(arr[i][j] == 0) {
//					count++;
//				}
//			}
//			if(count == 1) {
//				System.out.print(i + 1 + " ");
//			}
//		}
		
		
		// Pacman
		int m = scanner.nextInt();
		for(int k = 0; k < m; k++) {
			int n = scanner.nextInt();
			int[][] arr = new int[n][n];
			int x = 0, y = 0; // vị trí của Pacman
			// nhập mảng đồng thời tìm vị trí của Pacman
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					arr[i][j] = scanner.nextInt();
					if(arr[i][j] == 2) {
						x = i;
						y = j;
					}
				}
			}
			int sum = 0;
			int i = 1;
			while(x - i >= 0 && y - i >= 0 && arr[x-i][y-i] == 0) {
				sum++;
				i++;
			}
			i = 1;
			while(y - i >= 0 && arr[x][y-i] == 0) {
				sum++;
				i++;
			}
			i = 1;
			while(x + i < n && y - i >= 0 && arr[x+i][y-i] == 0) {
				sum++;
				i++;
			}
			
			i = 1;
			while(x - i >= 0 && y + i < n && arr[x-i][y+i] == 0) {
				sum++;
				i++;
			}
			i = 1;
			while(y + i < n && arr[x][y+i] == 0) {
				sum++;
				i++;
			}
			i = 1;
			while(x + i < n && y + i < n && arr[x+i][y+i] == 0) {
				sum++;
				i++;
			}
			int j = 1;
			while(x - j >= 0 && arr[x-j][y] == 0) {
				sum++;
				j++;
			}
			j = 1;
			while(x + j < n && arr[x+j][y] == 0) {
				sum++;
				j++;
			}
			System.out.println("#" + (k + 1) + ": " + sum);
		}
		
		//AREA - Diện tích hình chữ nhật
//		int m = scanner.nextInt();
//		int x1, y1, x2, y2;
//		int[][] hcn = new int[101][101];
//		for(int i = 0; i < m; i++) {
//			x1 = scanner.nextInt();
//			y1 = scanner.nextInt();
//			x2 = scanner.nextInt();
//			y2 = scanner.nextInt();
//			for(int k = x1; k < x2; k++) {
//				for(int t = y1; t < y2; t++) {
//					hcn[k][t] = 1;
//				}
//			}
//		}
//		int sum = 0;
//		for(int k = 0; k <= 100; k++) {
//			for(int t = 0; t <= 100; t++) {
//				if (hcn[k][t] == 1) {
//					sum += 1;
//				}
//			}
//		}
//		System.out.println(sum);

		
		fReader.close();
	}
}
