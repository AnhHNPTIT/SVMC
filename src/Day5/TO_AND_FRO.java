package Day5;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TO_AND_FRO {
	public static void main(String[] args) throws IOException{
		FileReader fReader = new FileReader("src\\input5.txt");
		Scanner scanner = new Scanner(fReader);
		
		int n = scanner.nextInt();
		while(n != 0) {
			scanner.nextLine();
			String str = scanner.nextLine();
			int m = str.length() / n;
			char[][] arr = new char[m][n];
			int k = 0;
			
			for(int i = 0; i < m; i++) {
				if(i % 2 == 0) {
					for(int j = 0; j < n; j++) {
						arr[i][j] = str.charAt(k);
						k++;
					}
				}
				else {
					for(int j = n - 1; j >= 0; j--) {
						arr[i][j] = str.charAt(k);
						k++;
					}
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					System.out.print(arr[j][i]);
				}
			}
			System.out.println();
			
			n = scanner.nextInt();
		}
		
		fReader.close();
	}
}
