package Day4;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class NUAMATRAN {
	public static void main(String[] args) throws IOException{
		FileReader fReader = new FileReader("src\\Day4_Ex2.txt");
		Scanner scanner = new Scanner(fReader);
		
		int tc = scanner.nextInt();
		for(int k = 1; k <= tc; k++) {
			int n = scanner.nextInt();
			int[][] arr = new int[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					arr[i][j] = scanner.nextInt();
				}
			}
			
			int sum = 0;
			for(int i = 0; i < n; i++) {
				for(int j = i + 1; j < n; j++) {
					sum += arr[i][j];
				}
			}
			System.out.print("#" + k + " " + sum + " ");
			
			sum = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < i; j++) {
					sum += arr[i][j];
				}
			}
			System.out.print(sum + " ");
			
			sum = 0;
			for(int i = 0; i < n; i++) {
				for(int j = n - i; j < n; j++) {
					sum += arr[i][j];
				}
			}
			System.out.print(sum + " ");
			
			sum = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n - i - 1; j++) {
					sum += arr[i][j];
				}
			}
			System.out.println(sum);
		}
		
		fReader.close();
	}
}
