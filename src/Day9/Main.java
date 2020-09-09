package Day9;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static int countBlocks(int[][] arr, int n) {
		int sum = 0;
		int bottom = 1, up = 2, no = 0;
		int temp = no;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[j][i] == bottom) {
					temp = bottom;
				}
				if (arr[j][i] == up) {
					if (temp == bottom) {
						sum++;
					}
					temp = no;
				}
			}
			temp = no;
		}
		return sum;
	}
		
	public static void main(String[] args) throws IOException{
		FileReader fReader = new FileReader("src\\input9.txt");
		Scanner scanner = new Scanner(fReader);
		
		// https://www.spoj.com/SVMCCLAS/problems/MAGETIC_SVMC/
		int tc = 10;
		for (int count = 1; count <= tc; count++) {
			int n = scanner.nextInt();
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = scanner.nextInt();
				}
			}
			
			System.out.println("#" + count + " " + countBlocks(arr, n));
		}
		
		fReader.close();
	}
}
