package Day3;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException{
		FileReader fReader = new FileReader("src\\input3.txt");
		Scanner scanner = new Scanner(fReader);
		
		//https://vn.spoj.com/problems/HYDRO/
//		int m = scanner.nextInt();
//		for(int k = 0; k < m; k++) {
//			int n = scanner.nextInt();
//			int[] arr = new int[n];
//			for(int i = 0; i < n; i++) {
//				arr[i] = scanner.nextInt();
//			}
//			int min = (arr[0] < arr[n - 1]) ? arr[0] : arr[n - 1];
//			int sum = 0;
//			for(int i = 1; i < n - 1; i++) {
//				if(arr[i] < min) {
//					sum += min - arr[i];
//				}
//			}
//			System.out.println(sum);
//		}
		
		
		//https://vn.spoj.com/problems/NKINV/
//		int m = scanner.nextInt();
//		int[] arr = new int[m];
//		for(int i = 0; i < m; i++) {
//			arr[i] = scanner.nextInt();
//		}
//		int count = 0;
//		for(int i = 0; i < m - 1; i++) {
//			for(int j = i + 1; j < m; j++) {
//				if(arr[i] > arr[j]) {
//					count++;
//				}
//			}
//		}
//		System.out.println(count);
		
		//Tổng âm
//		int tc = scanner.nextInt();
//		for(int k = 0; k < tc; k++) {
//			int m = scanner.nextInt();
//			int n = scanner.nextInt();
//			int[][] arr = new int[m + 2][n + 2];
//			for(int i = 1; i <= m; i++) {
//				for(int j = 1; j <= n; j++) {
//					arr[i][j] = scanner.nextInt();
//				}
//			}
//			for(int j = 0; j <= n + 1; j++) {
//				arr[0][j] = 0;
//				arr[m + 1][j] = 0;
//			}
//			for(int i = 0; i <= m + 1; i++) {
//				arr[i][0] = 0;
//				arr[i][n + 1] = 0;
//			}
//			int sum = 0;
//			int count = 0;
//			for(int i = 1; i <= m; i++) {
//				for(int j = 1; j <= n; j++) {
//					int tmp = arr[i-1][j-1] + arr[i][j-1] + arr[i+1][j-1]+ arr[i-1][j] + arr[i][j] + arr[i+1][j] + arr[i-1][j+1] + arr[i][j+1] + arr[i+1][j+1];
//					if (tmp < 0) {
//						sum += arr[i][j];
//						count++;
//					}
//				}
//			}
//			if(count == 0) {
//				System.out.println("NOT FOUND");
//			}
//			else{
//				System.out.println("#" + (k + 1) + " " + sum);
//			}
//		}
						
		
		//https://www.spoj.com/problems/SMPSUM/
//		int m = scanner.nextInt();
//		int n = scanner.nextInt();
//		int sum = 0;
//		for(int i = m; i <= n; i++) {
//			sum += i * i;
//		}
//		System.out.println(sum);
		
		
		//https://vn.spoj.com/problems/GSS/
//		int m = scanner.nextInt();
//		int[] arr = new int[m + 1];
//		for(int i = 1; i <= m; i++) {
//			arr[i] = scanner.nextInt();
//		}
//		int tc = scanner.nextInt();
//		for(int k = 0; k < tc; k++) {
//			int x = scanner.nextInt();
//			int y = scanner.nextInt();
//			int max = arr[x];
//			for(int i = x; i <= y; i++) {
//				int sum = 0;
//				for(int j = i; j <= y; j++) {
//					sum += arr[j];
//					max = (sum > max) ? sum : max;
//				}
//			}
//			System.out.println(max);
//		}
		
		fReader.close();
	}
}
